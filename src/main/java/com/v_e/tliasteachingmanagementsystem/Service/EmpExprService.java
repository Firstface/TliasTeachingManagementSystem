package com.v_e.tliasteachingmanagementsystem.Service;

import com.v_e.tliasteachingmanagementsystem.Entity.Emp_Expr;

import java.util.List;

public interface EmpExprService {
    List<Emp_Expr> saveEmpExpr(List<Emp_Expr> empExpr);
    List<Emp_Expr> updateEmpExpr(List<Emp_Expr> empExpr);
    List<Emp_Expr> getAllEmpExpr();
    Emp_Expr getEmpExprById(int id);
    void deleteEmpExpr(int id);
}
