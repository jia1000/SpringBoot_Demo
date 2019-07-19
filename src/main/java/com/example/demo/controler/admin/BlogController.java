package com.example.demo.controler.admin;

import com.example.demo.dao.blog.TableTbBlogMapper;
import com.example.demo.entity.blog.TableTbBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private TableTbBlogMapper tableTbBlogMapper;

    @RequestMapping("/blogs")
    @ResponseBody
    @Transactional
    public String getBlogs() {
        Long id = 5L;
        TableTbBlog blog_item = tableTbBlogMapper.selectByPrimaryKey(id);
        String content = blog_item.getBlog_content();
        System.out.println("content: " + content);
        return "blog's content : " + content;
    }



}
