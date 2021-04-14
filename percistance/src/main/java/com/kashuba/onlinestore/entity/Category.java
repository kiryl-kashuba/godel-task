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
    //    @JsonManagedReference
    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private List<ProductAttribute> productAttribute;

    private String name;
    //    @JsonManagedReference
    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private List<InstanceProduct> instanceProducts;

    public Category(String name) {
        this.name = name;
    }
}
