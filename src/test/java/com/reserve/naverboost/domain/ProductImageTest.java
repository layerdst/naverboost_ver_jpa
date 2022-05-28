package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.dto.req.FileInfoDtoReq;
import com.reserve.naverboost.domain.enums.EnumContentType;
import com.reserve.naverboost.domain.enums.EnumImageType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.reserve.naverboost.domain.dto.req.FileInfoDtoReq.createFileInfo;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class ProductImageTest {


    @PersistenceContext
    EntityManager em;




    @Test
    @Rollback(value = false)
        public void test() throws Exception{





        Category category = new Category();
        category.setCategoryName("testCategory");
        em.persist(category);

        Product product = new Product(category,"testContent", "testDescription", "testEvent");
        em.persist(product);

        FileInfo info1 = new FileInfo();
        info1.setContentType(EnumContentType.BMP);
        info1.setDeleteFlag(false);
        info1.setFileName("testFile");
        info1.setSaveFileName("/testFile");

        em.persist(info1);

        FileInfo info2 = new FileInfo();
        info2.setContentType(EnumContentType.BMP);
        info2.setDeleteFlag(false);
        info2.setFileName("testFile");
        info2.setSaveFileName("/testFile");

        em.persist(info2);

        ProductImage image1 = new ProductImage();

        image1.setImgType(EnumImageType.MA);
        image1.setFileInfo(info1);
        image1.setProduct(product);
        image1.setFileInfo(info1);

        em.persist(image1);

        ProductImage image2 = new ProductImage();
        image2.setImgType(EnumImageType.ETC);
        image2.setFileInfo(info2);
        image2.setProduct(product);
        image2.setFileInfo(info2);

        em.persist(image2);
        product.getProductImages().add(image1);
        product.getProductImages().add(image2);

        Product productTest = em.find(Product.class, product.getId());
        List<ProductImage> productImages = productTest.getProductImages();
        System.out.println("==========================");
        System.out.println(productImages.size());


        for(ProductImage productImage : productImages){
            System.out.println(productImage.getFileInfo().getId());
        }
        System.out.println("==========================");


        //given

        //when

        //then
    }


    @Test
    @Rollback(value = false)
    public void test1() throws Exception{
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

        ProductImage pro = new ProductImage();
        pro.arrayProductImages(product, testFiles);

        Product productTest = em.find(Product.class, product.getId());
        List<ProductImage> productImages = productTest.getProductImages();
        System.out.println("==========================");
        System.out.println(productImages.size());

        for(ProductImage productImage : productImages){
            System.out.println(productImage.getId());
        }
//
//
//
//        FileInfo info1 = new FileInfo();
//        info1.createFileInfo()
//        info1.setDeleteFlag(false);
//        info1.setFileName("testFile");
//        info1.setSaveFileName("/testFile");
//
//        em.persist(info1);
//
//        FileInfo info2 = new FileInfo();
//        info2.setContentType(EnumContentType.BMP);
//        info2.setDeleteFlag(false);
//        info2.setFileName("testFile");
//        info2.setSaveFileName("/testFile");

        //then
    }

    static int v1 = 20;

    @Test
    public void scope() throws Exception{
        ProductImageTest test = new ProductImageTest();
        System.out.println(test.v1);

        test.v1 = 30;
        System.out.println(test.v1);

    }

}