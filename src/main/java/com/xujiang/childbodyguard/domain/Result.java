package com.xujiang.childbodyguard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public  class Result<T> {

    private Integer code;
    private String msg;

    private T data;
}
