package com.kashuba.onlinestore.entity;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class InstanceProductContainer extends BaseEntity { //как быть с этим классом контейнером?
    private InstanceProduct instanceProduct;
    private Integer count;
    //    @ManyToOne(optional=false)
//    @JoinColumn(name = "id")
    private Cart cart;
}
