package com.dembee.crudsample;

import com.dembee.crudsample.dao.StudentDao;
import com.dembee.crudsample.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudsampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudsampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			createStudent(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao) {
		//create the student object
		System.out.println("Creating new object====");
		Student tempStudent = new Student("Dembee", "Munkhuu", "batdemberel_sh@yahoo.com");
		//save the student object
		System.out.println("Saving th student====");
		studentDao.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
