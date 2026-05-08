package com.cms.chadsvlog.service;

import com.cms.chadsvlog.dto.response.content.PostLists;

import java.util.List;

public interface ContentService {
    List<PostLists> getPostLists();
}
