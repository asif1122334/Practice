package com.example.demo.service;

import java.util.Optional;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.StudentWrapper;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	
	
	public StudentWrapper saveStudent(StudentWrapper inputStudent) {
		Student student=new Student();
	//	student.setId(inputStudent.getId());
		student.setName(inputStudent.getName());
		student=repository.save(student);
		
		inputStudent.setId(student.getId());
		inputStudent.setName(student.getName());
		
		return inputStudent;
	}
	
	public StudentWrapper getStudentById(int id) throws RecordNotFoundException {
		StudentWrapper studentwrapperoutput=null;
		Optional<Student> studentoptionaldata=repository.findById(id);
		
		if(studentoptionaldata.isPresent()) {
			studentwrapperoutput =new StudentWrapper();
			Student student=studentoptionaldata.get();
			studentwrapperoutput.setId(student.getId());
			studentwrapperoutput.setName(student.getName());
			
		}else{
			throw new RecordNotFoundException("Student record not found");
			
		}
		return studentwrapperoutput;
		
		
	}
	
	
	public StudentWrapper updateStudentDetail(StudentWrapper inputStudent) throws RecordNotFoundException{
		Optional<Student> studentOptionalData=repository.findById(inputStudent.getId());
		if(studentOptionalData.isPresent()) {
			Student student=studentOptionalData.get();
			
			student.setName(inputStudent.getName());
			repository.save(student);
			
			StudentWrapper studentwrapper=new StudentWrapper();
			
			studentwrapper.setId(student.getId());
			
			studentwrapper.setName(student.getName());
		
			return studentwrapper;
		}else {
			throw new RecordNotFoundException("Student record not found");
		}
	}
		public void deleteById(int id) throws RecordNotFoundException{
			Optional<Student> studentOptionalData=repository.findById(id);
			
			if(studentOptionalData.isPresent()) {
				Student student=studentOptionalData.get();
				
				repository.delete(student);
				
			}else {
				throw new RecordNotFoundException("Student record not found");		 
		}
		
	}
}

