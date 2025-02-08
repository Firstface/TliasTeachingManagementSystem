package com.v_e.tliasteachingmanagementsystem.Service;


import com.v_e.tliasteachingmanagementsystem.Entity.Emp;

import java.time.LocalDateTime;
import java.util.List;

public interface EmpService {
    List<Emp> getEmpPagination(int Size, int Offset);
    Emp saveEmp(Emp emp);
    Emp updateEmp(int id, Emp emp);
    Emp deleteEmp(int id);
    List<Emp> getEmpByNameContaining(String name,int Index);
    List<Emp> getEmpByGender(String gender,int Index);
    List<Emp> getEmpByHireDateBetween(LocalDateTime empHireDate, LocalDateTime empOperatedDate,int Index);
}
