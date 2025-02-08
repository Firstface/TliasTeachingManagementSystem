package com.v_e.tliasteachingmanagementsystem.Service.impl;

import com.v_e.tliasteachingmanagementsystem.Entity.Emp;
import com.v_e.tliasteachingmanagementsystem.Repository.EmpRepository;
import com.v_e.tliasteachingmanagementsystem.Service.EmpService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    private final EmpRepository empRepository;
    private final Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);

    public EmpServiceImpl(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public List<Emp> getEmpPagination(int Size, int Offset) {
        try {
            List<Emp> res = empRepository.findEmpPagination(Size, Offset);
            if (res.isEmpty()) {
                logger.warn("There is no more data");
                return null;
            } else {
                logger.info("Successfully get data");
                return res;
            }
        } catch (DataAccessException e) {
            logger.error("DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("Unexpected Exception : " + e.getMessage());
            return null;
        }
    }

    @Override
    public Emp saveEmp(Emp emp) {
        try {
            logger.info("Successfully save data");
            return empRepository.save(emp);
        } catch (DataAccessException e) {
            logger.error("DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("Unexpected Exception : " + e.getMessage());
            return null;
        }
    }

    @Override
    public Emp updateEmp(int id, Emp emp) {
        try {
            Emp existingEmp = empRepository.findEmpById(id);
            if (existingEmp == null) {
                logger.warn("Emp not found");
                return null;
            } else {
                existingEmp.setEmpName(emp.getEmpName() == null ? existingEmp.getEmpName() : emp.getEmpName());
                existingEmp.setEmpDept(emp.getEmpDept() == null ? existingEmp.getEmpDept() : emp.getEmpDept());
                existingEmp.setEmpOperatedDate(emp.getEmpOperatedDate() == null ? existingEmp.getEmpOperatedDate() : emp.getEmpOperatedDate());
                existingEmp.setEmpHireDate(emp.getEmpHireDate() == null ? existingEmp.getEmpHireDate() : emp.getEmpHireDate());
                existingEmp.setGender(emp.getGender() == null ? existingEmp.getGender() : emp.getGender());
                existingEmp.setImage(emp.getImage() == null ? existingEmp.getImage() : emp.getImage());
                logger.info("Successfully update data");
                return empRepository.save(existingEmp);
            }
        } catch (DataAccessException e) {
            logger.error("DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("Unexpected Exception : " + e.getMessage());
            return null;
        }
    }

    @Override
    public Emp deleteEmp(int id) {
        try {
            Emp existingEmp = empRepository.findEmpById(id);
            if (existingEmp == null) {
                logger.warn("Emp not found");
                return null;
            } else {
                empRepository.delete(existingEmp);
                logger.info("Successfully delete data");
                return existingEmp;
            }
        } catch (DataAccessException e) {
            logger.error("DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("Unexpected Exception : " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emp> getEmpByNameContaining(String name) {
        try {
            List<Emp> existingEmp = empRepository.findEmpByEmpNameContaining(name);
            if (existingEmp == null) {
                logger.warn("Emp not found");
                return null;
            } else {
                logger.info("Successfully get data");
                return existingEmp;
            }
        } catch (DataAccessException e) {
        return null;
        } catch (Exception e) {
            logger.error("Unexpected Exception : " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emp> getEmpByGender(String gender) {
        try {
            List<Emp> existingEmp = empRepository.findEmpByGender(gender);
            if (existingEmp == null) {
                logger.warn("Emp not found");
                return null;
            } else {
                logger.info("Successfully get data");
                return existingEmp;
            }
        } catch (DataAccessException e) {
            logger.error("DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("Unexpected Exception : " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emp> getEmpByHireDateBetween(LocalDateTime empHireDate,LocalDateTime empOperatedDate) {
        try {
            String empHireDateString = empHireDate.toString();
            String empOperatedDateString = empOperatedDate.toString();
            List<Emp> existingEmp = empRepository.findByEmpHireDateBetween(empHireDateString, empOperatedDateString);
            if (existingEmp == null) {
                logger.warn("Emp not found");
                return null;
            } else {
                logger.info("Successfully get data");
                return existingEmp;
            }
        } catch (DataAccessException e) {
            logger.error("DataAccessException : " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("Unexpected Exception : " + e.getMessage());
            return null;
        }
    }
}
