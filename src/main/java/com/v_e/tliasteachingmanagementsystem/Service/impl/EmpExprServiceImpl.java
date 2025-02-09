package com.v_e.tliasteachingmanagementsystem.Service.impl;

import com.v_e.tliasteachingmanagementsystem.Entity.Emp_Expr;
import com.v_e.tliasteachingmanagementsystem.Repository.EmpExprRepository;
import com.v_e.tliasteachingmanagementsystem.Service.EmpExprService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmpExprServiceImpl implements EmpExprService {

    private final EmpExprRepository empExprRepository;
    private final Logger logger = LoggerFactory.getLogger(EmpExprServiceImpl.class);

    public EmpExprServiceImpl(EmpExprRepository empExprRepository) {
        this.empExprRepository = empExprRepository;
    }

    @Override
    public List<Emp_Expr> saveEmpExpr(List<Emp_Expr> empExpr) {
        try {
            if(empExpr.isEmpty()){
                logger.warn("EmpExpr is empty");
                return empExpr;
            }
            else{
                return empExprRepository.saveAll(empExpr);
            }
        } catch (DataAccessException e) {
            logger.error("DaraAccessException while saving EmpExpr", e);
            return empExpr;
        } catch (Exception e) {
            logger.error("Error while saving EmpExpr", e);
            return empExpr;
        }
    }

    @Override
    public List<Emp_Expr> updateEmpExpr(List<Emp_Expr> empExpr) {
        try{
            List<Emp_Expr> res = new ArrayList<>();
            for(Emp_Expr e : empExpr){
                Emp_Expr existingEmpExpr = empExprRepository.findById(e.getId()).orElse(null);
                if(existingEmpExpr == null){
                    logger.warn("EmpExpr not found");
                    return empExpr;
                }
                else{
                    existingEmpExpr.setId(e.getId() == 0 ? existingEmpExpr.getId() : e.getId());
                    existingEmpExpr.setExprName(e.getExprName() == null ? existingEmpExpr.getExprName() : e.getExprName());
                    existingEmpExpr.setExprStartDate(e.getExprStartDate() == null ? existingEmpExpr.getExprStartDate() : e.getExprStartDate());
                    existingEmpExpr.setExprEndDate(e.getExprEndDate() == null ? existingEmpExpr.getExprEndDate() : e.getExprEndDate());
                    res.add(existingEmpExpr);
                }
            }
            return empExprRepository.saveAll(res);
        } catch (DataAccessException e) {
            logger.error("DaraAccessException while updating EmpExpr", e);
            return empExpr;
        } catch (Exception e) {
            logger.error("Error while updating EmpExpr", e);
            return empExpr;
        }
    }


    @Override
    public List<Emp_Expr> getAllEmpExpr() {
        try {
            List<Emp_Expr> res = empExprRepository.findAll();
            if(res.isEmpty()){
                logger.warn("EmpExpr is empty");
            }
            return res;
        } catch (DataAccessException e) {
            logger.error("DaraAccessException while getting EmpExpr", e);
            return null;
        } catch (Exception e) {
            logger.error("Error while getting EmpExpr", e);
            return null;
        }
    }

    @Override
    public Emp_Expr getEmpExprById(int id) {
        try {
            Emp_Expr res = empExprRepository.findById(id).orElse(null);
            if(res == null){
                logger.warn("EmpExpr not found");
            }
            return res;
        } catch (DataAccessException e) {
            logger.error("DaraAccessException while getting EmpExpr", e);
            return null;
        } catch (Exception e) {
            logger.error("Error while getting EmpExpr", e);
            return null;
        }
    }

    @Override
    public void deleteEmpExpr(int id) {
        try {
            empExprRepository.deleteById(id);
        } catch (DataAccessException e) {
            logger.error("DaraAccessException while deleting EmpExpr", e);
        } catch (Exception e) {
            logger.error("Error while deleting EmpExpr", e);
        }
    }
}
