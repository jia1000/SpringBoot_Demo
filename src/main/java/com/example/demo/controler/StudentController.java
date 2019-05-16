package com.example.demo.controler;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    // 2-1、 查询，根据id
    // 测试url ：http://127.0.0.1:8080/student/get_by_id/2
    @GetMapping(value = "/get_by_id/{id}")
    @ResponseBody
    public Student queryStudentById(@PathVariable(value="id") Integer id) {
        // 后面还有添加get()函数，之前，一直没注意该接口
        Student student = studentRepository.findById(id).get();
        return  student;
    }

    // 2-2、 查询，根据name
    // 测试url ：http://127.0.0.1:8080/student/get_by_name/lisi
    @GetMapping(value = "/get_by_name/{name}")
    @ResponseBody
    public Student queryStudentByName(@PathVariable(value="name") String name) {
        // 后面还有添加get()函数，之前，一直没注意该接口
        Student student = studentRepository.findByName(name);
        return  student;
    }

    // 2-3、 查询全部
    // 测试url ：http://127.0.0.1:8080/student/get_all
    @RequestMapping("/get_all")
    @ResponseBody
    public List<Student> queryAllStudent() {
        // 后面还有添加get()函数，之前，一直没注意该接口
        List<Student> students = studentRepository.findAll();
        return  students;
    }

    // 2-4、 查询-使用分页Page
    // 测试url ：
    @RequestMapping("/get_by_name_with_page/{name}")
    @ResponseBody
    public Page<Student> queryStudentByNameWithPage(@PathVariable(value = "name") String name) throws Exception {
        // 页码，是从0开始计的
        int page = 0;
        int size = 5;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Student> stus = studentRepository.findByNameWithPage(name, pageable);
        return  stus;
    }

    // 3、 删除，根据id
    // 测试url ：http://127.0.0.1:8080/student/delete/1
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable(value="id") Integer id) {
        Student student = studentRepository.findById(id).get();
//        studentRepository.deleteById(id);
        studentRepository.deleteByStudentId(id);
        return "delete student name : " + student.getName();
    }


}
