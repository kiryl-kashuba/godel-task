package com.kashuba.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "categories")
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {
    @JsonManagedReference
    @OneToMany(mappedBy = "category", orphanRemoval = false, fetch = FetchType.LAZY)
    private List<ProductAttribute> productAttribute;

    @JsonManagedReference
    @OneToMany(mappedBy = "category", orphanRemoval = false)
    private List<InstanceProduct> instanceProducts;

    private String name;

    public Category(String name) {
        this.name = name;
    }
}
