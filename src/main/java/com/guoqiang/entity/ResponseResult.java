package com.guoqiang.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseResult<T> {
    //状态码
    private Integer code;
    //提示信息，如果有错误，前端可以获取该字段进行提示
    private String msg;
    //查询到的结果数据
    private T data;

//    public ResponseResult ok(Integer code, String msg ,T data){
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//        return this;
//    }
//
//    public static ResponseResult success(){
//        return new
//    }
}
