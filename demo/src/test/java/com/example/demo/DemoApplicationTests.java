package com.example.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.demo.common.KafkaProducer;
import com.example.demo.entity.Dept;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.security.acl.Group;
import java.sql.Connection;
import java.text.NumberFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests extends AbstractJUnit4SpringContextTests {
    @Resource
    DataSource dataSource;
    @Resource
    DeptService deptService;

    public void contextLoads() throws  Exception {
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

    }

    /**
     * 测试插入功能
     */

    public void insData(){
        Dept dept =new Dept();
        dept.setId(1000004);
        dept.setDepartmentName("这都是什么啊");
        deptService.save(dept);
    }

    public void getNumberFormat(){
        int i = 1;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        // 设置最大整数位数
        nf.setMaximumIntegerDigits(4);
        // 设置最小整数位数
        nf.setMinimumIntegerDigits(4);
        System.err.println(nf.format(i));
    }
    @Autowired
    private KafkaProducer kafkaProducer;
    @Test
    public  void getProducer(){
      this.kafkaProducer.send();
    }

}
