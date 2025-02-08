package com.v_e.tliasteachingmanagementsystem.Service.impl;

import com.v_e.tliasteachingmanagementsystem.Entity.Dept;
import com.v_e.tliasteachingmanagementsystem.Repository.DeptRepository;
import com.v_e.tliasteachingmanagementsystem.Service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
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
}
