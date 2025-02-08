package com.v_e.tliasteachingmanagementsystem.Repository;

import com.v_e.tliasteachingmanagementsystem.Entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
    Emp findEmpById(int id);

}
