package com.cms.chadsvlog.dao.mapper;

import com.cms.chadsvlog.dao.entities.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {
    List<Post> getPostsList();
    Post getPostById(int id);
}
