package com.cms.chadsvlog.dto.response.content;

import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostResponse {
    private int id;
    private String title;
    private String message;
//    private String heroImageSource;
    private String createdBy;
    private int replyCount;
    private LocalDateTime createdDate;
}
