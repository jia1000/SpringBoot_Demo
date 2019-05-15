package com.example.demo.entity;

import javax.persistence.*;

/*
    使用JPA注解配置映射关系
    @Entity 告诉jpa这是一个实体类（和数据库表映射的类）
    @Table 指定和哪个数据表对应；如果省略name,默认表名是user
 */

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id ;
    private String name;
    private String address;
    private int age;
    private char sex;

    public Student() {
    }

    public Student(String name, String address, int age, char sex) {
        super();
        this.name = name;
        this.address = address;
        this.age = age;
        this.sex = sex;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
