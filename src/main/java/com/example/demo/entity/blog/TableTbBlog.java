package com.example.demo.entity.blog;

import java.util.Date;

public class TableTbBlog {
    private Long blog_id;

    private String blog_title;

    private String blog_sub_url;

    private String blog_cover_image;

    private Integer blog_category_id;

    private String blog_category_name;

    private String blog_tags;

    private Byte blog_status;

    private Long blog_views;

    private Byte enable_comment;

    private Byte is_deleted;

    private Date create_time;

    private Date update_time;

    private String blog_content;

    public Long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Long blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title == null ? null : blog_title.trim();
    }

    public String getBlog_sub_url() {
        return blog_sub_url;
    }

    public void setBlog_sub_url(String blog_sub_url) {
        this.blog_sub_url = blog_sub_url == null ? null : blog_sub_url.trim();
    }

    public String getBlog_cover_image() {
        return blog_cover_image;
    }

    public void setBlog_cover_image(String blog_cover_image) {
        this.blog_cover_image = blog_cover_image == null ? null : blog_cover_image.trim();
    }

    public Integer getBlog_category_id() {
        return blog_category_id;
    }

    public void setBlog_category_id(Integer blog_category_id) {
        this.blog_category_id = blog_category_id;
    }

    public String getBlog_category_name() {
        return blog_category_name;
    }

    public void setBlog_category_name(String blog_category_name) {
        this.blog_category_name = blog_category_name == null ? null : blog_category_name.trim();
    }

    public String getBlog_tags() {
        return blog_tags;
    }

    public void setBlog_tags(String blog_tags) {
        this.blog_tags = blog_tags == null ? null : blog_tags.trim();
    }

    public Byte getBlog_status() {
        return blog_status;
    }

    public void setBlog_status(Byte blog_status) {
        this.blog_status = blog_status;
    }

    public Long getBlog_views() {
        return blog_views;
    }

    public void setBlog_views(Long blog_views) {
        this.blog_views = blog_views;
    }

    public Byte getEnable_comment() {
        return enable_comment;
    }

    public void setEnable_comment(Byte enable_comment) {
        this.enable_comment = enable_comment;
    }

    public Byte getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Byte is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content == null ? null : blog_content.trim();
    }
}