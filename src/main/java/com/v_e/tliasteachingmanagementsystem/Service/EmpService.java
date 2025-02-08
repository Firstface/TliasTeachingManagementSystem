package com.v_e.tliasteachingmanagementsystem.Service;


import com.v_e.tliasteachingmanagementsystem.Entity.Emp;

import java.time.LocalDateTime;
import java.util.List;

public interface EmpService {

    Emp saveEmp(Emp emp);
    Emp updateEmp(int id, Emp emp);
    Emp deleteEmp(int id);
    List<Emp> getEmpByFilter(String name, String gender, LocalDateTime empHireDate, LocalDateTime empOperatedDate,int Index);
}
