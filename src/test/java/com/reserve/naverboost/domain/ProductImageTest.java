package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.category.CategoryRespository;
import com.reserve.naverboost.domain.dto.req.FileInfoDtoReq;
import static com.reserve.naverboost.entity.ProductImage.createProductImages;

import com.reserve.naverboost.domain.product.ProductRepository;
import com.reserve.naverboost.domain.product.ProductService;
import com.reserve.naverboost.entity.Category;
import com.reserve.naverboost.entity.FileInfo;
import com.reserve.naverboost.entity.Product;
import com.reserve.naverboost.entity.ProductImage;
import com.reserve.naverboost.entity.enums.EnumContentType;
import com.reserve.naverboost.entity.enums.EnumImageType;
import com.reserve.naverboost.util.exception.CustomException;
import com.reserve.naverboost.util.exception.CustomResponseStatus;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.reserve.naverboost.domain.dto.req.FileInfoDtoReq.createFileInfo;


@SpringBootTest
@Transactional
class ProductImageTest {


    @PersistenceContext
    EntityManager em;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;




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



        System.out.println(productRepository.findByCategoryId(1L).get(0));


//        Assertions.assertThatThrownBy(
//                () -> productService.categorySearch(2L))
//                .isInstanceOf(CustomException.class);


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
        ProductImageTest test2 = new ProductImageTest();
        System.out.println(test.v1);

        test.v1 = 30;
        test2.v1= 40;
        System.out.println(test.v1);

    }

}