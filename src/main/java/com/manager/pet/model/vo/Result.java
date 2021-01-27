package com.manager.pet.model.vo;

import lombok.Data;

/**
 * i
 * 2020 \ 12 \ 16
 */
@Data
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result() {}

    public Result(Integer code) {
        this.code = code;
    }
}
