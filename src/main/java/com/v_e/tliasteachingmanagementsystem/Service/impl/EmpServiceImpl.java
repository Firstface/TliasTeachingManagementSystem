package com.v_e.tliasteachingmanagementsystem.Service.impl;

import com.v_e.tliasteachingmanagementsystem.Entity.DTO.Expr_Emp;
import com.v_e.tliasteachingmanagementsystem.Entity.Emp;
import com.v_e.tliasteachingmanagementsystem.Entity.Emp_Expr;
import com.v_e.tliasteachingmanagementsystem.Repository.EmpRepository;
import com.v_e.tliasteachingmanagementsystem.Service.EmpExprService;
import com.v_e.tliasteachingmanagementsystem.Service.EmpService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    private final EmpRepository empRepository;
    private final EmpExprService empExprService;
    private final Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);
    private final static int OFFSET = 10;

    public EmpServiceImpl(EmpRepository empRepository, EmpExprServiceImpl empExprService) {
        this.empRepository = empRepository;
        this.empExprService = empExprService;
    }



    @Override
    public Emp saveEmp(Emp emp) {
        try {
            logger.info("UpdateEmp -- Successfully save data");
            List<Expr_Emp> expr_emps = new ArrayList<>();
            for(Emp_Expr e : emp.getEmpExpr()){
                Expr_Emp expr_emp = new Expr_Emp();
                expr_emp.setEmpId(emp.getId());
                expr_emp.setExprName(e.getExprName());
                expr_emps.add(expr_emp);
            }
            empExprService.saveEmpExpr(expr_emps);
            return empRepository.save(emp);
        } catch (DataAccessException e) {
            logger.error("UpdateEmp -- DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("UpdateEmp -- Unexpected Exception : " + e.getMessage());
            return null;
        }
    }

    @Override
    public Emp updateEmp(int id, Emp emp) {
        try {
            Emp existingEmp = empRepository.findEmpById(id);
            if (existingEmp == null) {
                logger.warn("UpdateEmp -- Emp not found");
                return null;
            } else {
                existingEmp.setEmpName(emp.getEmpName() == null ? existingEmp.getEmpName() : emp.getEmpName());
                existingEmp.setEmpDept(emp.getEmpDept() == null ? existingEmp.getEmpDept() : emp.getEmpDept());
                existingEmp.setEmpOperatedDate(emp.getEmpOperatedDate() == null ? existingEmp.getEmpOperatedDate() : emp.getEmpOperatedDate());
                existingEmp.setEmpHireDate(emp.getEmpHireDate() == null ? existingEmp.getEmpHireDate() : emp.getEmpHireDate());
                existingEmp.setGender(emp.getGender() == null ? existingEmp.getGender() : emp.getGender());
                existingEmp.setImage(emp.getImage() == null ? existingEmp.getImage() : emp.getImage());
                logger.info("UpdateEmp -- Successfully update data");
                return empRepository.save(existingEmp);
            }
        } catch (DataAccessException e) {
            logger.error("UpdateEmp -- DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("UpdateEmp -- Unexpected Exception : " + e.getMessage());
            return null;
        }
    }

    @Override
    public Emp deleteEmp(int id) {
        try {
            Emp existingEmp = empRepository.findEmpById(id);
            if (existingEmp == null) {
                logger.warn("UpdateEmp -- Emp not found");
                return null;
            } else {
                empRepository.delete(existingEmp);
                logger.info("UpdateEmp -- Successfully delete data");
                return existingEmp;
            }
        } catch (DataAccessException e) {
            logger.error("UpdateEmp -- DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("UpdateEmp -- Unexpected Exception : " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emp> getEmpByFilter(String name, String gender, LocalDateTime empHireDate, LocalDateTime empOperatedDate, int Index) {
        try {
            List<Emp> existingEmp = empRepository.findAll().stream()
                    .filter(emp ->
                            (name == null || name.isEmpty() || emp.getEmpName().contains(name)) &&
                                    (gender == null || gender.isEmpty() || emp.getGender().equals(gender)) &&
                                    (empHireDate == null || emp.getEmpHireDate().isEqual(empHireDate) || emp.getEmpHireDate().isAfter(empHireDate)) &&
                                    (empOperatedDate == null ||
                                            (emp.getEmpOperatedDate().isAfter(empHireDate) && emp.getEmpOperatedDate().isBefore(empOperatedDate)) ||
                                            emp.getEmpOperatedDate().isEqual(empOperatedDate))
                    )
                    .skip((long) Index * OFFSET)
                    .limit(10)
                    .toList();
            if(existingEmp.isEmpty()){
                logger.warn("UpdateEmp -- Emp not found");
                return null;
            }else{
                logger.info("UpdateEmp -- Successfully get data");
                return existingEmp;
            }
        } catch (DataAccessException e) {
            logger.error("UpdateEmp -- DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("UpdateEmp -- Unexpected Exception : " + e.getMessage());
            return null;
        }
    }
}
