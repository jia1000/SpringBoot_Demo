package com.example.demo.controler;

import com.example.demo.entity.Progress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("thymeleaf")
public class UploadfileController {

    @RequestMapping("show_upload")
    public String showUpLoadFile() {
        return "test_upload_file";
    }

    @RequestMapping(value = "/up",method = RequestMethod.POST)
    public @ResponseBody String up(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("/") + "upload/";
            String fileName = file.getName();
            File target = new File(path + fileName);
            file.transferTo(target);
        }
        return "upload success";
    }


    @GetMapping(value = "/size")
    public @ResponseBody
    Progress getProgress(HttpServletRequest request){
        HttpSession session = request.getSession();
        Progress progress = (Progress) session.getAttribute("status");
        System.out.println(progress + "controller");
        return progress;
    }
}
