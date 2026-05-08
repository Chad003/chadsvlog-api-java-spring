package com.cms.chadsvlog.dao.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String message;
    private String heroImageSource;
    private String createdBy;
    private int replyCount;
    private LocalDateTime createdDate;

}
