package com.cms.chadsvlog.service;

import com.cms.chadsvlog.dto.request.content.GetPostRequest;
import com.cms.chadsvlog.dto.response.content.PostResponse;

import java.util.List;

public interface ContentService {
    List<PostResponse> getPostLists();
    PostResponse getPosts(GetPostRequest request);
}
