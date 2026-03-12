package com.lpu.student.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.student.entity.Student;
import com.lpu.student.repository.StudentRepository;

@Service
public class StudentFileService {

    @Autowired
    private StudentRepository sturepo;


    public String uploadFiles(int id, MultipartFile image, MultipartFile file) throws IOException {

        Student stu = sturepo.findById(id).orElseThrow();

        stu.setProfileImage(image.getBytes());
        stu.setAssignmentfile(file.getBytes());

        sturepo.save(stu);

        return "Files uploaded successfully";
    }


    public byte[] downloadImage(int id) {

        Student stu = sturepo.findById(id).orElseThrow();
        return stu.getProfileImage();
    }

    
    public byte[] downloadFile(int id) {

        Student stu = sturepo.findById(id).orElseThrow();
        return stu.getAssignmentfile();
    }
}
