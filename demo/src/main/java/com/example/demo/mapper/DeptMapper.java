package com.example.demo.mapper;

import com.example.demo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface DeptMapper {

    Dept findOne(Integer id);

    List<Dept> list();

    int save(Dept dept);
}
