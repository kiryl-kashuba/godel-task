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
public class InstanceProductContainer extends BaseEntity {
    private InstanceProduct instanceProduct;
    private Integer count;
}
