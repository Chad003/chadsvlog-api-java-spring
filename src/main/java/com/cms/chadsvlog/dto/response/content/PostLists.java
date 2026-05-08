package com.cms.chadsvlog.dto.response.content;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostLists {
    private int id;
    private String title;
    private String message;
    private String heroImageSource;
    private String createdBy;
    private int replyCount;
    private LocalDateTime createdDate;
}
