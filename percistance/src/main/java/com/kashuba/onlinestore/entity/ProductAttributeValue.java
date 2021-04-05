package com.kashuba.onlinestore.entity;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductAttributeValue extends BaseEntity {

    private String value;
    private ProductAttribute productAttribute;
}
