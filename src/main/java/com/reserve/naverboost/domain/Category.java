package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.auditing.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category{

    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

}
