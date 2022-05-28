package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.auditing.BaseTimeEntity;
import com.reserve.naverboost.domain.dto.req.FileInfoDtoReq;
import com.reserve.naverboost.domain.enums.EnumImageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.ImageType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.reserve.naverboost.domain.FileInfo.createFileInfo;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductImage extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="product_image_id")
    private Long id;


    /**
     * product -> img 연관관계 주인 고민해볼것!
     *
     */
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Enumerated(value=EnumType.STRING)
    private EnumImageType imgType;

    @ManyToOne
    @JoinColumn(name="file_info_id")
    private FileInfo fileInfo;


    ProductImage(Product product, EnumImageType imgType, FileInfoDtoReq req){
        this.product = product;
        this.imgType = imgType;
        this.fileInfo = createFileInfo(req);
    }

    public static ProductImage createProductImages(Product product, FileInfoDtoReq req){
        return new ProductImage(product, req.getImgType(), req);
    }

    public List<ProductImage> arrayProductImages(Product product,List<FileInfoDtoReq> fileInfoDtoReqs) {
        List<ProductImage> tmp = new ArrayList<>();
        for(FileInfoDtoReq fileInfoDtoReq : fileInfoDtoReqs){
            ProductImage productImage = createProductImages(product, fileInfoDtoReq);
            product.getProductImages().add(productImage);
            tmp.add(productImage);
        }
        return tmp;
    }





    





}
