package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public Department findByName(String name);

    public Department findByid(Integer id);



}
