package com.v_e.tliasteachingmanagementsystem.Service.impl;

import com.v_e.tliasteachingmanagementsystem.Entity.Dept;
import com.v_e.tliasteachingmanagementsystem.Repository.DeptRepository;
import com.v_e.tliasteachingmanagementsystem.Service.DeptService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    private final DeptRepository deptRepository;
    private static final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);

    public DeptServiceImpl(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Override
    public List<Dept> getDeptByTimeDesc() {
        try{
            List<Dept> res = deptRepository.findAllByOrderByUpdatedAtDesc();
            if (res == null || res.isEmpty()) {
                logger.info("No departments found.");
                return Collections.emptyList();
            }
            return res;
        } catch (DataAccessException e) {
            logger.error("Error occurred while fetching departments: ", e);
            return Collections.emptyList();
        } catch (Exception e) {
            logger.error("Unexpected error occurred: ", e);
            return Collections.emptyList();
        }
    }

    @Override
    public Dept deleteDeptById(int id) {
        try{
            Dept res = deptRepository.deleteDeptById(id);
            if (res == null) {
                logger.info("No department found with ID: {}", id);
                return null;
            }
            return res;
        } catch (DataAccessException e) {
            logger.error("Error occurred while deleting department with ID: {}", id, e);
            return null;
        } catch (Exception e) {
            logger.error("Unexpected error occurred: ", e);
            return null;
        }
    }

    @Override
    public Dept saveDept(Dept dept) {
        try {
            return deptRepository.save(dept);
        } catch (DataAccessException e) {
            logger.error("Error occurred while saving department: ", e);
            return null;
        } catch (Exception e) {
            logger.error("Unexpected error occurred: ", e);
            return null;
        }
    }

    @Override
    public Dept updateDept(int Id,Dept dept) {
        try {
            Dept existingDept = deptRepository.findDeptById(Id);
            if (existingDept == null) {
                logger.info("No department found with ID: {}", Id);
                return null;
            }
            existingDept.setDeptName(dept.getDeptName());
            existingDept.setDeptNum(dept.getDeptNum());
            return deptRepository.save(existingDept);
        } catch (DataAccessException e) {
            logger.error("Error occurred while updating department: ", e);
            return null;
        } catch (Exception e) {
            logger.error("Unexpected error occurred: ", e);
            return null;
        }
    }


}
