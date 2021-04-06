package com.kashuba.onlinestore.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "category")
    private List<ProductAttribute> productAttribute;
    @OneToMany(mappedBy = "category")
    private List<InstanceProduct> instanceProducts;

    public Category(String name) {
        this.name = name;
    }

    public Category(long id) {
        super(id);
    }
}
