package com.cms.chadsvlog.controller;

import com.cms.chadsvlog.dto.Response;
import com.cms.chadsvlog.dto.response.content.PostLists;
import com.cms.chadsvlog.service.ContentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("api/content")
public class ContentController {
    @Resource
    private ContentService contentService;

    @GetMapping("posts-list")
    @ResponseBody
    public Response<?> getPosts(){
        List<PostLists> response = contentService.getPostLists();
        return Response.success().withData(response).build();
    }
}
