package com.example.demo.dao.blog;

import com.example.demo.entity.blog.TableTbBlog;
import com.example.demo.entity.blog.Table_dw_ai_task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper   // 需要手动添加该注解
public interface Table_dw_ai_taskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Table_dw_ai_task record);

    int insertSelective(Table_dw_ai_task record);

    Table_dw_ai_task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Table_dw_ai_task record);

    int updateByPrimaryKeyWithBLOBs(Table_dw_ai_task record);

    int updateByPrimaryKey(Table_dw_ai_task record);

    @Select("SELECT * from dw_ai_task")
    List<Table_dw_ai_task> getLists();
}