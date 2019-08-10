package com.tipo.witter.pojo;

import com.tipo.witter.enums.ResultEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 *  备选方案一，单例返回中间件，暂时不开启token,错误优化，找时间取缔了,来不及了现在就开车！！
 * @author  Tipo
 * @date 7/27/20198:38 AM
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Msg {
    @JsonProperty
    private Meta meta;
    @JsonProperty
    private Object data;
    @JsonIgnore
    private static Msg result;

    private Msg(){

    }
    /**
     * 构造器隐藏，只能通过下面的方法获取对象
     * */
    public static Msg success(){
        if (null==result){
            result=new Msg();
        }
        result.setMeta(new Meta(ResultEnum.SUCCESS.value()));
        result.data=null;
        return result;
    }
    public static Msg success(String msg){
        if (null==result){
            result=new Msg();
        }
        result.setMeta(new Meta(ResultEnum.SUCCESS.value(),msg));
        result.data=null;
        return result;
    }
    public static Msg success(String msg,Object obj){
        if (null==result){
            result=new Msg();
        }
        result.setMeta(new Meta(ResultEnum.SUCCESS.value(),msg));
        result.data=obj;
        return result;
    }
    public static Msg success(Object obj){
        if (null==result){
            result=new Msg();
        }
        result.setMeta(new Meta(ResultEnum.SUCCESS.value()));
        result.data=obj;
        return result;
    }
    public static Msg fail(){
        if (null==result){
            result=new Msg();
        }
        result.setMeta(new Meta(ResultEnum.FAIL.value()));
        result.data=null;
        return result;
    }
    public static Msg fail(Object obj){
        if (null==result){
            result=new Msg();
        }
        result.setMeta(new Meta(ResultEnum.FAIL.value()));
        result.data=obj;
        return result;
    }
    public static Msg fail(ResultEnum resultEnum){
        if (null==result){
            result=new Msg();
        }
        result.setMeta(new Meta(resultEnum.value()));
        result.data=null;
        return result;
    }

    public static Msg fail(ResultEnum resultEnum,String msg){
        if (null==result){
            result=new Msg();
        }
        result.setMeta(new Meta(resultEnum.value(),msg));
        result.data=null;
        return result;
    }

    public Meta getMeta() {
        return meta;
    }

    private void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }
    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static class Meta{
        private Integer code;
        private String message;
//        private String token;

        //        public String getToken() {
//            return token;
//        }
        Meta(Integer code){
            this.code=code;
//            this.token= RequestUtil.getToken();
        }
        Meta(Integer code,String msg){
            this.code=code;
            this.message=msg;
//            this.token= RequestUtil.getToken();
        }
        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }


    }
}
