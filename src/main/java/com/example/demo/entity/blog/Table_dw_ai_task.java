package com.example.demo.entity.blog;

import java.util.Date;

public class Table_dw_ai_task {
    private Integer id;

    private String patient_id;

    private String study_uid;

    private String series_uid;

    private String task_type;

    private String input_dir;

    private Integer task_status;

    private Byte gpu;

    private Byte retry;

    private Byte rebuild_retry;

    private Date start_time;

    private Date end_time;

    private String process_host;

    private String ai_version;

    private Boolean is_delete;

    private Date create_time;

    private Date update_time;

    private String result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id == null ? null : patient_id.trim();
    }

    public String getStudy_uid() {
        return study_uid;
    }

    public void setStudy_uid(String study_uid) {
        this.study_uid = study_uid == null ? null : study_uid.trim();
    }

    public String getSeries_uid() {
        return series_uid;
    }

    public void setSeries_uid(String series_uid) {
        this.series_uid = series_uid == null ? null : series_uid.trim();
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type == null ? null : task_type.trim();
    }

    public String getInput_dir() {
        return input_dir;
    }

    public void setInput_dir(String input_dir) {
        this.input_dir = input_dir == null ? null : input_dir.trim();
    }

    public Integer getTask_status() {
        return task_status;
    }

    public void setTask_status(Integer task_status) {
        this.task_status = task_status;
    }

    public Byte getGpu() {
        return gpu;
    }

    public void setGpu(Byte gpu) {
        this.gpu = gpu;
    }

    public Byte getRetry() {
        return retry;
    }

    public void setRetry(Byte retry) {
        this.retry = retry;
    }

    public Byte getRebuild_retry() {
        return rebuild_retry;
    }

    public void setRebuild_retry(Byte rebuild_retry) {
        this.rebuild_retry = rebuild_retry;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getProcess_host() {
        return process_host;
    }

    public void setProcess_host(String process_host) {
        this.process_host = process_host == null ? null : process_host.trim();
    }

    public String getAi_version() {
        return ai_version;
    }

    public void setAi_version(String ai_version) {
        this.ai_version = ai_version == null ? null : ai_version.trim();
    }

    public Boolean getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Boolean is_delete) {
        this.is_delete = is_delete;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}