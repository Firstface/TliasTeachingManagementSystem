package com.v_e.tliasteachingmanagementsystem.Repository;

import com.v_e.tliasteachingmanagementsystem.Entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
    Emp findEmpById(int id);
    @Query("SELECT e FROM Emp e order by e.Id limit ?1 offset ?2")
    List<Emp> findEmpPagination(int Size, int Offset);
    List<Emp> findEmpByEmpNameContaining(String name);
    List<Emp> findEmpByGender(String gender);
    List<Emp> findByEmpHireDateBetween(String empHireDate, String empHireDate2);

}
