package com.example.demo.dao.blog;

import com.example.demo.entity.blog.TableTbBlog;
import org.apache.ibatis.annotations.Mapper;

@Mapper   // 需要手动添加该注解
public interface TableTbBlogMapper {
    int deleteByPrimaryKey(Long blog_id);

    int insert(TableTbBlog record);

    int insertSelective(TableTbBlog record);

    TableTbBlog selectByPrimaryKey(Long blog_id);

    int updateByPrimaryKeySelective(TableTbBlog record);

    int updateByPrimaryKeyWithBLOBs(TableTbBlog record);

    int updateByPrimaryKey(TableTbBlog record);
}