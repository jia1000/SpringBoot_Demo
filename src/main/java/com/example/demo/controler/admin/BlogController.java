package com.example.demo.controler.admin;

import com.example.demo.dao.blog.TableTbBlogMapper;
import com.example.demo.entity.blog.TableTbBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private TableTbBlogMapper tableTbBlogMapper;

    // 解决中文乱码
    @RequestMapping(value="/getblog/{id}", produces = "application/json; charset=utf-8")
    @ResponseBody
    @Transactional
    public String getBlog(@PathVariable Long id) {
        TableTbBlog blog_item = tableTbBlogMapper.selectByPrimaryKey(id);
        String content = blog_item.getBlog_content();
        System.out.println("content: ");
        return "blog's content : " + content;
    }



}
