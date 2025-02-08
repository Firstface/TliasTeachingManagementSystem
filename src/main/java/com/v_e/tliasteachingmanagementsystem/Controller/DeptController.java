package com.v_e.tliasteachingmanagementsystem.Controller;

import com.v_e.tliasteachingmanagementsystem.Entity.Dept;
import com.v_e.tliasteachingmanagementsystem.Service.DeptService;
import com.v_e.tliasteachingmanagementsystem.Service.impl.DeptServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptServiceImpl deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public ResponseEntity<List<Dept>> getDeptByTimeDesc(){
        List<Dept> res =  deptService.getDeptByTimeDesc();
        return ResponseEntity.ok(res);
    }
}
