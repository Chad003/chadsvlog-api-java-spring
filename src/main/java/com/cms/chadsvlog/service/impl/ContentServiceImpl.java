package com.cms.chadsvlog.service.impl;

import com.cms.chadsvlog.dao.entities.Post;
import com.cms.chadsvlog.dao.mapper.ContentMapper;
import com.cms.chadsvlog.dto.request.content.GetPostRequest;
import com.cms.chadsvlog.dto.response.content.PostResponse;
import com.cms.chadsvlog.service.ContentService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ContentServiceImpl implements ContentService {
    @Resource
    ContentMapper contentMapper;
    @Override
    public List<PostResponse> getPostLists() {
        List<Post> posts = contentMapper.getPostsList();
        List<PostResponse> postLists = new ArrayList<>();
        for(Post post: posts ){
            PostResponse list = new PostResponse();
            BeanUtils.copyProperties(post,list);
            postLists.add(list);
        }
        return postLists;
    }

    @Override
    public PostResponse getPosts(GetPostRequest request) {
        Post post = contentMapper.getPostById(request.getId());
        if(Objects.nonNull(post)){
            PostResponse response = new PostResponse();
            BeanUtils.copyProperties(post,response);
            return response;
        }
        return null;
    }
}
