package com.example.demo.contoller;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
public class DeptContoller {

    @Autowired
    private DeptService deptService;
    @RequestMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }
}
