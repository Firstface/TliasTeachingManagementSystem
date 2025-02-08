package com.v_e.tliasteachingmanagementsystem.Controller;

import com.v_e.tliasteachingmanagementsystem.Entity.Emp;
import com.v_e.tliasteachingmanagementsystem.Service.EmpService;
import com.v_e.tliasteachingmanagementsystem.Service.impl.EmpServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    public EmpController(EmpServiceImpl empService) {
        this.empService = empService;
    }

    @GetMapping
    public ResponseEntity<List<Emp>> getEmpByFilter(
            @RequestParam(required = false) String name
            , @RequestParam(required = false) String gender
            , @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime empHireDate
            , @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime empOperatedDate
            , @RequestParam(defaultValue = "0",required = false) int Index)
    {
        List<Emp> res = empService.getEmpByFilter(name, gender, empHireDate, empOperatedDate, Index);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }


    @PostMapping
    public ResponseEntity<Emp> saveEmp(Emp emp) {
        Emp res = empService.saveEmp(emp);
        if (res == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @PutMapping
    public ResponseEntity<Emp> updateEmp(int id, Emp emp) {
        Emp res = empService.updateEmp(id, emp);
        if (res == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @DeleteMapping
    public ResponseEntity<Emp> deleteEmp(int id) {
        Emp res = empService.deleteEmp(id);
        if (res == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

}
