package com.v_e.tliasteachingmanagementsystem;

import com.v_e.tliasteachingmanagementsystem.Service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DeptServiceTest {

    @Autowired
    private DeptService deptService;


    @Test
    public void testGetDeptByTimeDesc() {
        System.out.println(deptService.getDeptByTimeDesc());
    }
}
