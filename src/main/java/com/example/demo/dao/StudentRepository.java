package com.example.demo.dao;


import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 继承JpaRepository来完成对数据库表的操作
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    public Student findByName(String name);
//    public Student findByid(Integer id);
}
