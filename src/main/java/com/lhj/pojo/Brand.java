package com.lhj.pojo;


import lombok.Data;

//lombok
//Lombok下的@Data注解提供了get/set方法，toString方法，hashCode方法,equals方法等
@Data
public class Brand {
    private Integer id;
    private String brandName;
    private String companyName;
    private Integer ordered;
    private String description;
    private Integer status;
    public String getStatusStr(){
        if(status==null){
            return "未知";
        }else {
            return status==0?"禁用":"启用";
        }
    }
}
