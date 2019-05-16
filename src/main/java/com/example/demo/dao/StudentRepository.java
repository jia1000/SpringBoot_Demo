package com.example.demo.dao;


import com.example.demo.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 继承JpaRepository来完成对数据库表的操作
 *
 *  @Query           ：查询方法上面使用注解，
 *  @Modifying      ：涉及到删除和修改，需要加上它.
 *  @Transactional  ：是对事物的支持
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Transactional
    @Query(value = "select * from Student where name = ?1",nativeQuery=true)
    public Student findByName(String name);
//    public Student findByid(Integer id);

    @Transactional
    @Modifying
    @Query("delete from Student where id = ?1")
    public void deleteByStudentId(Integer id);

    @Transactional
    @Query(value="select stu from Student stu where stu.name = ?1")
    public Page<Student> findByNameWithPage(String name, Pageable pageable);
}
