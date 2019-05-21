package com.example.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

// 全局捕获异常
@ControllerAdvice   // 是Controller的一个辅助类，最常用的是作为全局异常的切面类，可以指定扫描范围，
public class GlobalExceptionHandler {

    // 只限于文件上传的异常处理
    //https://jira.spring.io/browse/SPR-14651
    //4.3.5 supports RedirectAttributes redirectAttributes
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/upload_file_simple_status";
    }


    @ExceptionHandler(RuntimeException.class)   // 表示捕获异常
    @ResponseBody
    public Map<String, Object> exceptionHandler() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", "500");
        map.put("errorMsg", "System_error - only for test.");

        return map;
    }
}
