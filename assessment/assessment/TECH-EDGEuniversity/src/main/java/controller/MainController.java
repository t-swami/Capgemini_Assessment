package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyConfig;
import entity.Department;
import entity.Student;
import service.DepartmentService;
import service.StudentService;

@Component
public class MainController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        MainController controller =
                context.getBean(MainController.class);

        Department dept = new Department();
        dept.setDeptName("Computer Science");
        controller.departmentService.addDepartment(dept);

        Student student = new Student();
        student.setName("Pavan");
        student.setEmail("pavan@gmail.com");
        controller.studentService.assignStudentToDepartment(
                dept.getDeptId(), student);

        List<Student> students =
                controller.studentService
                        .viewStudentsByDepartment(dept.getDeptId());

        for (Student s : students) {
            System.out.println(
                    s.getStudentId() + " "
                    + s.getName() + " "
                    + s.getEmail());
        }

        controller.studentService
                .updateStudent(student.getStudentId(), "updated@gmail.com");

        controller.departmentService
                .getDepartmentById(dept.getDeptId());

        controller.departmentService
                .getDepartmentById(dept.getDeptId());



//
//        Department d1 = controller.departmentService
//                .getDepartmentById(dept.getDeptId());
//
//
//        Department d2 = controller.departmentService
//                .getDepartmentById(dept.getDeptId());

    }
}