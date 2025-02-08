package com.v_e.tliasteachingmanagementsystem.Controller;

import com.v_e.tliasteachingmanagementsystem.Entity.Emp;
import com.v_e.tliasteachingmanagementsystem.Service.EmpService;
import com.v_e.tliasteachingmanagementsystem.Service.impl.EmpServiceImpl;
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
    public ResponseEntity<List<Emp>> getEmpPagination(int Size, int Offset) {
        List<Emp> res = empService.getEmpPagination(Size, Offset);
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

    @GetMapping("/name")
    public ResponseEntity<List<Emp>> getEmpByNameContaining(String name, int Index) {
        List<Emp> res = empService.getEmpByNameContaining(name, Index);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping("/gender")
    public ResponseEntity<List<Emp>> getEmpByGender(String gender, int Index) {
        List<Emp> res = empService.getEmpByGender(gender, Index);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping("/hireDate")
    public ResponseEntity<List<Emp>> getEmpByHireDateBetween(LocalDateTime empHireDate, LocalDateTime empOperatedDate, int Index) {
        List<Emp> res = empService.getEmpByHireDateBetween(empHireDate, empOperatedDate, Index);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }
}
