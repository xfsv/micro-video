package edu.hhu.liweijia.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Video {

    private Integer id;
    private String name;
    private String director;
    private String roles;
    private Integer minuteLength;
    private Date productDate;
    private String area;
    private String description;
    private Integer typeId;
    private String imagePath;
    private String videoPath;

}
