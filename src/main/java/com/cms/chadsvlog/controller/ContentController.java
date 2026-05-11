package com.cms.chadsvlog.controller;

import com.cms.chadsvlog.dto.Response;
import com.cms.chadsvlog.dto.request.content.GetPostRequest;
import com.cms.chadsvlog.dto.response.content.PostResponse;
import com.cms.chadsvlog.service.ContentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("api/content")
public class ContentController {
    @Resource
    private ContentService contentService;

    @GetMapping("get-posts-list")
    @ResponseBody
    public Response<?> getPostsList(){
        List<PostResponse> response = contentService.getPostLists();
        return Response.success().withData(response).build();
    }
    @GetMapping("get-post")
    @ResponseBody
    public Response<?> getPost(GetPostRequest request) {
        PostResponse post = contentService.getPosts(request);
        if(Objects.isNull(post)){
            return Response.failed().withMessage("No post found").build();
        }
        return Response.success().withData(post).build();
    }
}
