package com.cms.chadsvlog.service.impl;

import com.cms.chadsvlog.dao.entities.Post;
import com.cms.chadsvlog.dao.mapper.ContentMapper;
import com.cms.chadsvlog.dto.response.content.PostLists;
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
    public List<PostLists> getPostLists() {
        List<Post> posts = contentMapper.getPosts();
        List<PostLists> postLists = new ArrayList<>();
        for(Post post: posts ){
            PostLists list = new PostLists();
            BeanUtils.copyProperties(post,list);
            postLists.add(list);
        }
        return postLists;
    }
}
