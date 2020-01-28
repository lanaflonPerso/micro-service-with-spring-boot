package org.sid.scolariteservice;

import java.util.Date;

import org.sid.scolariteservice.entity.Laboratory;
import org.sid.scolariteservice.entity.Student;
import org.sid.scolariteservice.repository.LaboratoryRepository;
import org.sid.scolariteservice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ScolariteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScolariteServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(StudentRepository studentRepository,
			RepositoryRestConfiguration restConfiguration,
			LaboratoryRepository laboratoryRepository) {
		return args -> {
			restConfiguration.exposeIdsFor(Student.class);
			Laboratory l1 = laboratoryRepository.save(new Laboratory(null, "computer engineer", "066666666", null));
			Laboratory l2 =laboratoryRepository.save(new Laboratory(null, "network engineer", "07777777", null));
			studentRepository.save(new Student(null,"yasser","yass@gmail.com",new Date(),l1));
			studentRepository.save(new Student(null,"hamza","yass@gmail.com",new Date(),l2));
			studentRepository.save(new Student(null,"fatita","yass@gmail.com",new Date(),l1));
			studentRepository.save(new Student(null,"kenza","yass@gmail.com",new Date(),l2));
			
			studentRepository.findAll().forEach(System.out::println);
		};
	}

}
