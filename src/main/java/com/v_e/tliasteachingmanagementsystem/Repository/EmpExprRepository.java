package com.v_e.tliasteachingmanagementsystem.Repository;

import com.v_e.tliasteachingmanagementsystem.Entity.Emp_Expr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpExprRepository extends JpaRepository<Emp_Expr, Integer> {
}
