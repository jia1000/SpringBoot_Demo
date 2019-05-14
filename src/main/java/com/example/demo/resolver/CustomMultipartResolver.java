package com.example.demo.resolver;

import com.example.demo.listener.FileUploadProgressListener;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// 3、继承CommonsMultipartResolver类并重写parseRequest方法

public class CustomMultipartResolver extends CommonsMultipartResolver {
    @Autowired
    private FileUploadProgressListener listener;

    public void setListener(FileUploadProgressListener listener) {
        this.listener = listener;
    }

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        String encoding = determineEncoding(request);
        System.out.println(encoding);
        FileUpload fileUpload = prepareFileUpload(encoding);
        fileUpload.setFileSizeMax(1024000);
        fileUpload.setSizeMax(1024000);
        //向文件上傳進度監視器設置session用於存儲上傳進度
        listener.setSession(request.getSession());
        //將文件上傳進度監視器加入到fileUpload中
        fileUpload.setProgressListener(listener);
        try {
            List<FileItem> fileItems = ((ServletFileUpload)fileUpload).parseRequest(request);
            return parseFileItems(fileItems, encoding);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return null;
    }
}
