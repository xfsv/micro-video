package edu.hhu.liweijia.entity;

import lombok.Data;

@Data
public class VideoType {

    private Integer id;
    private String name;
    private String description;

    public String getDesc(){
        if(description.length()>10){
            return description.substring(0,10)+"...";
        }else{
            return description;
        }
    }
}
