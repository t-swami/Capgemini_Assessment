package dao;

import javax.persistence.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Department;

@Cacheable
@Component
public class DepartmentDao {

    @Autowired
    private EntityManagerFactory emf;

    public void addDepartment(Department dept) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(dept);

        em.getTransaction().commit();
        em.close();
    }

    public Department getDepartmentById(int deptId) {

        EntityManager em = emf.createEntityManager();
        Department dept = em.find(Department.class, deptId);
        em.close();

        return dept;
    }

    //  Delete
    public void deleteDepartment(int deptId) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department dept = em.find(Department.class, deptId);
        em.remove(dept);

        em.getTransaction().commit();
        em.close();
    }
}

