package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "categories")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
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
