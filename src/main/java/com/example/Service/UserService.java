package com.example.Service;

import com.example.Model.Address;
import com.example.Model.Student;
import com.example.Repository.AddressRepository;
import com.example.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserService {



    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    public void createStudent(Student student){

        Student student1=new Student();
        student1.setName(student.getName());

        Address address = new Address();
        if (student.getAddress() != null) {
            address.setCity(student.getAddress().getCity()); // Get city from the incoming student
            address.setState(student.getAddress().getState()); // Get state from the incoming student

            addressRepository.save(address);
        }
        student1.setAddress(address);

        studentRepository.save(student1);

    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(int stdId){
        return studentRepository.findById(stdId);
    }








}
