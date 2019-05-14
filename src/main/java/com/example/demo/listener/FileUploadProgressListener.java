package com.example.demo.listener;

import com.example.demo.entity.Progress;
import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

// 2、实现ProgressListener接口

@Component
public class FileUploadProgressListener implements ProgressListener {

    private HttpSession session;

    public void setSession(HttpSession session){
        this.session = session;
        Progress status = new Progress();
        session.setAttribute("status", status);
    }

    @Override
    public void update(long read, long length, int items) {
        System.out.println("update-------------------------------");
        Progress status = (Progress) session.getAttribute("status");
        status.setRead(read);
        status.setLength(length);
        status.setItems(items);
        System.out.println(status + "listener");
    }
}
