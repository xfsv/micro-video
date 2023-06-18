package edu.hhu.liweijia.entity;

import lombok.Data;

import java.util.Date;

@Data
public class History {

    private Integer id;
    private int videoId;
    private String videoName;
    private int userId;
    private String userName;
    private Date time;
    private String imagePath;
    private String videoPath;
}
