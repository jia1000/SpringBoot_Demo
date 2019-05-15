package com.example.demo.controler;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /// ------------ student 表的操作----------------------------------------------
    // 保存数据
    @PostMapping(value = "/save")
    public Map<String, Object> save(@RequestBody Student student) {
        studentRepository.save(student);

        Map<String, Object> params = new HashMap<>();
        params.put("code", "success");
        return  params;
    }

    // 1、 添加
    // 测试url ：  http://127.0.0.1:8080/student/add/lisi
    @RequestMapping("/add/{student_name}")
    @ResponseBody
    public String addStudent(@PathVariable String student_name) {
        Student student = new Student(student_name, "north 15", 28, 'm');
        studentRepository.save(student);
        return "student name : " + student_name;
    }

    // 2、 查询，根据id
    // 测试url ：http://127.0.0.1:8080/student/get/2
    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public Student queryStudent(@PathVariable(value="id") Integer id) {
        // 后面还有添加get()函数，之前，一直没注意该接口
        Student student = studentRepository.findById(id).get();
        return  student;
    }

    // 3、 删除，根据id
    // 测试url ：http://127.0.0.1:8080/student/delete/1
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable(value="id") Integer id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return "delete student name : " + student.getName();
    }
}
