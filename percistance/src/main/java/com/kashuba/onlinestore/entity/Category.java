package com.kashuba.onlinestore.entity;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Category extends BaseEntity {

    private String name;
    private List<ProductAttribute> productAttribute;

    public Category(String name) {
        this.name = name;
    }

    public Category(long id) {
        super(id);
    }
}
