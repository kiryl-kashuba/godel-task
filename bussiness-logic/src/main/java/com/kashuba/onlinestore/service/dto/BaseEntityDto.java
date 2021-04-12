package com.kashuba.onlinestore.service.dto;

import lombok.*;

@EqualsAndHashCode
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntityDto {
    private Long id;
}
