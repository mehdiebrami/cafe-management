package com.cafemanagement.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddOrderDto {
    @NotNull
    private String name;
    @NotNull
    private long tableId;
}
