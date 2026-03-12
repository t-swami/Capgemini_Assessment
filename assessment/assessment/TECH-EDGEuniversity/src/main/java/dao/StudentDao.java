package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Department;
import entity.Student;

@Component
public class StudentDao {

    @Autowired
    private EntityManagerFactory emf;



    public void addStudent(Student student) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public List<Student> viewStudentsByDepartment(int deptId) {

        EntityManager em = emf.createEntityManager();

        Department dept = em.find(Department.class, deptId);

        List<Student> students = dept.getStudents();

        em.close();
        return students;
    }

    public void updateStudent(int studentId, String newEmail) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student student = em.find(Student.class, studentId);
        student.setEmail(newEmail);

        em.getTransaction().commit();
        em.close();
    }

    // 7️⃣ Delete Student
    public void deleteStudent(int studentId) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student student = em.find(Student.class, studentId);
        em.remove(student);

        em.getTransaction().commit();
        em.close();
    }
}


