package com.v_e.tliasteachingmanagementsystem.Controller;

import com.v_e.tliasteachingmanagementsystem.Entity.Emp_Expr;
import com.v_e.tliasteachingmanagementsystem.Service.EmpExprService;
import com.v_e.tliasteachingmanagementsystem.Service.impl.EmpExprServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empExpr")
public class EmpExprController {

    private final EmpExprService empExprService;

    public EmpExprController(EmpExprServiceImpl empExprService) {
        this.empExprService = empExprService;
    }

    @GetMapping
    public List<Emp_Expr> getAllEmpExpr(){
        return empExprService.getAllEmpExpr();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emp_Expr> getEmpExprById(@PathVariable int id){
        Emp_Expr empExpr = empExprService.getEmpExprById(id);
        if(empExpr == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empExpr);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpExpr(@PathVariable int id){
        empExprService.deleteEmpExpr(id);
        return ResponseEntity.ok("EmpExpr deleted successfully");
    }

    @PostMapping
    public ResponseEntity<List<Emp_Expr>> saveEmpExpr(@RequestBody List<Emp_Expr> empExpr){
        List<Emp_Expr> savedEmpExpr = empExprService.saveEmpExpr(empExpr);
        if(savedEmpExpr.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(savedEmpExpr);
    }

    @PutMapping
    public ResponseEntity<List<Emp_Expr>> updateEmpExpr(@RequestBody List<Emp_Expr> empExpr){
        List<Emp_Expr> updatedEmpExpr = empExprService.updateEmpExpr(empExpr);
        if(updatedEmpExpr.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updatedEmpExpr);
    }
}
