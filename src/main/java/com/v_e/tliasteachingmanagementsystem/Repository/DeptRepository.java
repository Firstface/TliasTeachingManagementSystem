package com.v_e.tliasteachingmanagementsystem.Repository;

import com.v_e.tliasteachingmanagementsystem.Entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptRepository extends JpaRepository<Dept,Integer> {
    List<Dept> findAllByOrderByUpdatedAtDesc();
    Dept deleteDeptById(int id);
    Dept findDeptById(int id);

}
