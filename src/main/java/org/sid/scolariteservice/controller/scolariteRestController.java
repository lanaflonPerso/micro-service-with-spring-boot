package org.sid.scolariteservice.controller;

import org.sid.scolariteservice.entity.Laboratory;
import org.sid.scolariteservice.entity.Student;
import org.sid.scolariteservice.repository.LaboratoryRepository;
import org.sid.scolariteservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class scolariteRestController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	LaboratoryRepository LaboratoryRepository;

	@GetMapping("/students")
	public List<Student> students(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student getOne(@PathVariable(name="id") Long id){
		return studentRepository.findById(id).get();
	}
	
	@PostMapping("/students")
	public Student save(@RequestBody Student student){
		if(student.getLaboratory().getId() == null) {
			Laboratory laboratory= LaboratoryRepository.save(student.getLaboratory());
			student.setLaboratory(laboratory);
		}
		return studentRepository.save(student);
	}
	
	@PutMapping("/students/{id}")
	public Student update(@PathVariable(name="id") Long id, @RequestBody Student student){
		student.setId(id);
		return studentRepository.findById(id).get();
	}
	
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable(name="id") Long id){
		 studentRepository.deleteById(id);
	}
}
