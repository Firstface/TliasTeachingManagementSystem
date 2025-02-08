package com.v_e.tliasteachingmanagementsystem.Controller;

import com.v_e.tliasteachingmanagementsystem.Entity.Dept;
import com.v_e.tliasteachingmanagementsystem.Service.DeptService;
import com.v_e.tliasteachingmanagementsystem.Service.impl.DeptServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if(res == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<Dept> saveDept(@RequestBody Dept dept){
        Dept res = deptService.saveDept(dept);
        return ResponseEntity.ok(res);
    }

    @PutMapping
    public ResponseEntity<Dept> updateDept(@RequestParam int Id,@RequestBody Dept dept){
        Dept res =  deptService.updateDept(Id,dept);
        if(res == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res);
    }

    @DeleteMapping
    public ResponseEntity<Dept> deleteDeptById(@RequestParam int id){
        Dept res =  deptService.deleteDeptById(id);
        if(res == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res);
    }
}
