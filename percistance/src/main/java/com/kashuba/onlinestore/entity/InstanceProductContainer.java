package com.kashuba.onlinestore.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class InstanceProductContainer extends BaseEntity { //как быть с этим классом контейнером?
    private InstanceProduct instanceProduct;
    private Integer count;
    //    @ManyToOne(optional=false)
//    @JoinColumn(name = "id")
    private Cart cart;
}
