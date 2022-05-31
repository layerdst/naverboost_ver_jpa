package com.reserve.naverboost.domain.product;

import com.reserve.naverboost.domain.dto.req.FileInfoDtoReq;
import com.reserve.naverboost.entity.*;
import com.reserve.naverboost.entity.enums.EnumContentType;
import com.reserve.naverboost.entity.enums.EnumImageType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static com.reserve.naverboost.domain.dto.req.FileInfoDtoReq.createFileInfo;
import static com.reserve.naverboost.entity.ProductImage.createProductImages;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @PersistenceContext
    EntityManager em;


    @Test
    public void productDisplayInfoInsertTest() throws Exception{
        //given
        Category category = new Category();
        category.setCategoryName("testCategory");
        em.persist(category);

        Product product = new Product(category,"testContent", "testDescription", "testEvent");
        em.persist(product);

        List<FileInfoDtoReq> testFiles = new ArrayList<>();
        for(int i = 0 ; i<3 ; i++){
            FileInfoDtoReq req = createFileInfo("test" + i, "/test" + i, EnumImageType.MA, EnumContentType.BMP);
            testFiles.add(req);
        }


        System.out.println("00000000000");
        System.out.println(testFiles.get(0).getFileName());
        for(FileInfoDtoReq req : testFiles){
            System.out.println(req.getFileName());
        }



        for(FileInfoDtoReq req : testFiles){
            ProductImage productImages = createProductImages(product, req);
            product.getProductImages().add(productImages);
            em.persist(productImages);
        }

//        pro.arrayProductImages(product, testFiles);

        Product productTest = em.find(Product.class, product.getId());
        List<ProductImage> productImages = productTest.getProductImages();
        System.out.println("==========================");
        System.out.println(productImages.size());

        for(ProductImage productImage : productImages){
            System.out.println(productImage.getFileInfo().getId());
            System.out.println(productImage.getId());
        }


        DisplayInfo di = new DisplayInfo(product, "9~12", "미술관", "미술관옆", "용산로", "01066655555", "na.com", "sdaf@ci.com");
        em.persist(di);


        List<FileInfoDtoReq> testDiFileInfo = new ArrayList<>();
        for(int i = 0 ; i<3 ; i++) {

            FileInfoDtoReq req = null;
            if (i == 0) {
                req = createFileInfo("displayFileInfo" + i, "/difi" + i, EnumImageType.MA, EnumContentType.BMP);
            } else{
                req = createFileInfo("displayFileInfo" + i, "/difi" + i, EnumImageType.ETC, EnumContentType.BMP);
            }
            testDiFileInfo.add(req);
        }



        //when

        //then
    }
}