package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.DepartmentDao;
import entity.Department;

@Component
	public class DepartmentService {

	    @Autowired
	    private DepartmentDao departmentDAO;

	    public void addDepartment(Department dept) {
	        departmentDAO.addDepartment(dept);
	    }

	    public Department getDepartmentById(int deptId) {
	        return departmentDAO.getDepartmentById(deptId);
	    }

	    public void deleteDepartment(int deptId) {
	        departmentDAO.deleteDepartment(deptId);
	    }
	}


