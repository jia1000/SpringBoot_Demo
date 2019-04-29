package com.example.demo.controler;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class JunitControllerTest {

    @BeforeClass
    @Test
    public void setJName() {
        System.out.println("单元测试开始之前，执行初始化.....");
    }

    @Test
    public void getJname() {
    }
}