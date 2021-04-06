package com.kashuba.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "category")
    private List<ProductAttribute> productAttribute;
    @OneToMany(mappedBy = "category")
    private List<InstanceProduct> instanceProducts;
}
