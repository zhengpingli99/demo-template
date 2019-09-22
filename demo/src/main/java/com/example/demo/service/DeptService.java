package com.example.demo.service;

import com.example.demo.entity.Dept;

import java.util.List;

public interface DeptService {
    Dept findDept(Integer id);

    List<Dept> list();

    int save(Dept dept);
}
