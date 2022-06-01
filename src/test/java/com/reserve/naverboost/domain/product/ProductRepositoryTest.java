package com.reserve.naverboost.domain.product;

import com.reserve.naverboost.domain.dto.req.FileInfoDtoReq;
import com.reserve.naverboost.domain.product.dto.ProductsByCategoryQueryDto;
import com.reserve.naverboost.domain.product.dto.ProductsDto;
import com.reserve.naverboost.entity.*;
import com.reserve.naverboost.entity.enums.EnumContentType;
import com.reserve.naverboost.entity.enums.EnumImageType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static com.reserve.naverboost.domain.dto.req.FileInfoDtoReq.createFileInfo;
import static com.reserve.naverboost.entity.ProductImage.createProductImages;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ProductRepository productRepository;


    @Test
    @Rollback(value = false)
    public void productDisplayInfoInsertTest() throws Exception{
        //given
        Category category = insertCategory("전시");
        Category category1 = insertCategory("콘서트");
        Category category2 = insertCategory("라이브");


        Product product = insertProduct(category, "테스트1", "테스트1", "이벤트 내용");

        List<FileInfoDtoReq> testFiles = insertFileInfo("productImageFile", "/productImageFile");


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

        DisplayInfo di2 = new DisplayInfo(product, "9~12", "미술관2", "미술관2옆", "용산로2", "01066655555", "na.com", "sdaf@ci.com");
        em.persist(di2);


        List<FileInfoDtoReq> testDiFileInfo = new ArrayList<>();
        for(int i = 0 ; i<3 ; i++) {
            FileInfoDtoReq req = createFileInfo("displayFileInfo" + i, "/difi" + i, EnumImageType.ETC, EnumContentType.BMP);
            testDiFileInfo.add(req);
        }

        for(FileInfoDtoReq req : testDiFileInfo){
            DisplayInfoImage displayInfoImg = DisplayInfoImage.createDisplayInfoImg(di, req);
            di.getImages().add(displayInfoImg);
            em.persist(displayInfoImg);
        }

        for(FileInfoDtoReq req : testDiFileInfo){
            DisplayInfoImage displayInfoImg = DisplayInfoImage.createDisplayInfoImg(di2, req);
            di2.getImages().add(displayInfoImg);
            em.persist(displayInfoImg);
        }

        List<ProductsDto> displayInfoByCategoryId = productRepository.findDisplayInfoByCategoryId(1L);
        System.out.println(displayInfoByCategoryId.get(0).getDisplayInfoId());

        //when

        //then
    }

    private Product insertProduct(Category category, String content, String description, String event) {
        Product product = new Product(category,content, description, event);
        em.persist(product);
        return product;
    }

    private Category insertCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        em.persist(category);
        return category;
    }


    private List<FileInfoDtoReq> insertFileInfo(String fileName, String saveFileName) {
        List<FileInfoDtoReq> testFiles = new ArrayList<>();
        for(int i = 0 ; i<3 ; i++){
            FileInfoDtoReq req = null;
            if (i == 0) {
                req = createFileInfo(fileName + i, saveFileName + i, EnumImageType.MA, EnumContentType.BMP);
            } else{
                req = createFileInfo(fileName + i, saveFileName + i, EnumImageType.ETC, EnumContentType.BMP);
            }
            testFiles.add(req);
        }
        return testFiles;
    }


    @Test
    public void getData() throws Exception{
        //given
        System.out.println(productRepository.findDisplayInfoByCategoryId(1L));


        //when

        //then
    }
}