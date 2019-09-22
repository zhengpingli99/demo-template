package com.example.demo.service.impl;

import com.example.demo.entity.Dept;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"deptService"})
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept findDept(Integer id) {
        return deptMapper.findOne(id);
    }

    @Override
    @Cacheable(value = "deptcache")
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    @CachePut(value = "deptcache", key = "\"dept_\" + #dept.id")
    public int save(Dept dept) {
        return deptMapper.save(dept);
    }
}
