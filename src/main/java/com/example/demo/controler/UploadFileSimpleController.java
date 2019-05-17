package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// 简单文件上传 ： 3、Contrller类的建立
@Controller
@RequestMapping("/upload")
public class UploadFileSimpleController {

    @GetMapping("/index")
    public String showUpload() {
        return "upload_file_simple";
    }

    // @RequestMapping("/single_file")  对应 html 中的 action="/upload/single_file"
    // @RequestParam("file111")         对应 html 中的 name="file111"
    @RequestMapping("/single_file")
    public String singleUploadFile(@RequestParam("file111")MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws Exception{
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "upload_file_simple_status";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("E://temp//" + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + ";");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "upload_file_simple_status";
    }
}
