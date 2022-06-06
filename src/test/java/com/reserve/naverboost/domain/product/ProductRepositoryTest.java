package com.reserve.naverboost.domain.product;

import com.reserve.naverboost.domain.dto.req.FileInfoDtoReq;
import com.reserve.naverboost.domain.product.dto.ProductsByCategoryQueryDto;
import com.reserve.naverboost.domain.product.dto.ProductsDto;
import com.reserve.naverboost.entity.*;
import com.reserve.naverboost.entity.enums.EnumContentType;
import com.reserve.naverboost.entity.enums.EnumImageType;
import com.reserve.naverboost.entity.enums.EnumPriceType;
import com.reserve.naverboost.util.exception.CustomException;
import com.reserve.naverboost.util.exception.CustomResponseStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.reserve.naverboost.domain.dto.req.FileInfoDtoReq.createFileInfo;
import static com.reserve.naverboost.entity.ProductImage.createProductImages;

import static com.reserve.naverboost.entity.Promotion.createPromotion;
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
        Product product2 = insertProduct(category1, "테스트2", "테스트2", "이벤트 내용2");
        Product product3 = insertProduct(category2, "테스트2", "테스트2", "이벤트 내용2");

        List<FileInfoDtoReq> testFiles = insertFileInfo("productImageFile", "/productImageFile");
        List<FileInfoDtoReq> testFiles1 = insertFileInfo("productImageFile", "/productImageFile");
        List<FileInfoDtoReq> testFiles2 = insertFileInfo("productImageFile", "/productImageFile");

        insertProductImage(product, testFiles);
        insertProductImage(product2, testFiles1);
        insertProductImage(product3, testFiles2);

        DisplayInfo di = insertDisplayInfo(product, "미술관", "미술관옆", "용산로");
        DisplayInfo di2 = insertDisplayInfo(product2, "미술관2", "미술관2옆", "용산로2");
        DisplayInfo di3 = insertDisplayInfo(product2, "미술관3", "미술관3옆", "용산로2");

        DisplayInfo di4 = insertDisplayInfo(product3, "미술관4", "미술관4옆", "용산로2");

        List<FileInfoDtoReq> testDiFileInfo = getFileInfoDtoReqs("displayfile", "/display/displayFile", EnumImageType.ETC, EnumContentType.BMP);
        List<FileInfoDtoReq> testDiFileInfo2 = getFileInfoDtoReqs("displayfile", "/display/displayFile", EnumImageType.ETC, EnumContentType.BMP);
        List<FileInfoDtoReq> testDiFileInfo3 = getFileInfoDtoReqs("displayfile", "/display/displayFile", EnumImageType.ETC, EnumContentType.BMP);
        List<FileInfoDtoReq> testDiFileInfo4 = getFileInfoDtoReqs("displayfile", "/display/displayFile", EnumImageType.ETC, EnumContentType.BMP);


        insertDisplayInfoImg(di, testDiFileInfo);
        insertDisplayInfoImg(di2, testDiFileInfo2);
        insertDisplayInfoImg(di3, testDiFileInfo3);
        insertDisplayInfoImg(di4, testDiFileInfo4);

        List<ProductsDto> displayInfoByCategoryId = productRepository.findDisplayInfoByCategoryId(1L);

//        ProductImage productImage1 = product.getProductImages().stream()
//                .filter(o -> o.getImgType().equals(EnumImageType.MA))
//                .findFirst()
//                .orElseThrow(() -> new CustomException(CustomResponseStatus.DB_ERR));
        insertPromotion(product);

        ReservationInfo reservationInfo = insertReservationInfo(product, di, "이름", "연락처", "이메일", LocalDateTime.now(), true);
        ProductPrice productPrice = insertProductPrice(product, EnumPriceType.A, 20000, 0.25F);
        insertReservationInfoPrice(reservationInfo, productPrice, 6);


    }

    private ReservationInfoPrice insertReservationInfoPrice(ReservationInfo reservationInfo, ProductPrice productPrice, int count) {
        ReservationInfoPrice reservationInfoPrice = ReservationInfoPrice.createReservationInfoPrice(reservationInfo, productPrice, count);
        em.persist(reservationInfoPrice);
        return reservationInfoPrice;
    }


    private ProductPrice insertProductPrice(Product product, EnumPriceType a, int i, float v) {
        ProductPrice productPrice = ProductPrice.createProductPrice(product, a, i, v);
        em.persist(productPrice);
        return productPrice;
    }


    private ReservationInfo insertReservationInfo(Product product, DisplayInfo di, String name, String tel, String email, LocalDateTime currentTime, boolean cancelFlag) {
        ReservationInfo reservationInfo = ReservationInfo.createReservationInfo(product, di, name, tel, email, currentTime, cancelFlag);
        em.persist(reservationInfo);
        return reservationInfo;
    }


    private void insertPromotion(Product product) {
        Promotion pr = createPromotion(product);
        em.persist(pr);
    }

    
    private void insertDisplayInfoImg(DisplayInfo di, List<FileInfoDtoReq> testDiFileInfo) {
        for (FileInfoDtoReq req : testDiFileInfo) {
            DisplayInfoImage displayInfoImg = DisplayInfoImage.createDisplayInfoImg(di, req);
            di.getImages().add(displayInfoImg);
            em.persist(displayInfoImg);
        }
    }

    private List<FileInfoDtoReq> getFileInfoDtoReqs(String fileName, String saveFileName , EnumImageType imageType, EnumContentType contentType) {
        List<FileInfoDtoReq> testDiFileInfo = new ArrayList<>();
        for(int i = 0 ; i<3 ; i++) {
            FileInfoDtoReq req = createFileInfo(fileName + i, saveFileName + i, EnumImageType.ETC, EnumContentType.BMP);
            testDiFileInfo.add(req);
        }
        return testDiFileInfo;
    }

    private DisplayInfo insertDisplayInfo(Product product, String 미술관, String 미술관옆, String 용산로) {
        DisplayInfo di = new DisplayInfo(product, "9~12", 미술관, 미술관옆, 용산로, "01066655555", "na.com", "sdaf@ci.com");
        product.getDisplayInfos().add(di);
        em.persist(di);
        return di;
    }

    private void insertProductImage(Product product, List<FileInfoDtoReq> testFiles) {
        for(FileInfoDtoReq req : testFiles){
            ProductImage productImages = createProductImages(product, req);
            product.getProductImages().add(productImages);
            em.persist(productImages);
        }
    }

    private Product insertProduct(Category category, String content, String description, String event) {
        Product product = new Product(category,content, description, event);
        category.getProducts().add(product);
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

    @Test
    public void tdst() throws Exception{
        //given
        char c1 = 'a';
        //when

        //then
    }


    @Test
    public void tdd1() throws Exception{
        //given
        double s = 100;
        double t = 1;

        while(s-t>0){
            t=t*2;
        }

        System.out.println(t);


        //when

        //then
    }
}