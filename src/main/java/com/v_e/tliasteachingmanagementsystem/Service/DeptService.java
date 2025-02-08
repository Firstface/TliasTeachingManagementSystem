package com.v_e.tliasteachingmanagementsystem.Service;

import com.v_e.tliasteachingmanagementsystem.Entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> getDeptByTimeDesc();
    Dept deleteDeptById(int id);
    Dept saveDept(Dept dept);
    Dept updateDept(int Id,Dept dept);
}
