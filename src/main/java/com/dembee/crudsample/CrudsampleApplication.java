package com.dembee.crudsample;

import com.dembee.crudsample.dao.StudentDao;
import com.dembee.crudsample.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudsampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudsampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			//createStudent(studentDao);
			createMultipleStudent(studentDao);
			//readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudents(studentDao);
		};
	}

	private void createMultipleStudent(StudentDao studentDao) {
	}

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDao.deleteAll();
		System.out.println("Delete row count" + numRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 1;
		System.out.println("Deleting student id" + studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDao.findById(studentId);
		//change first name "galsan"
		System.out.println("updating student...");
		myStudent.setFirstName("boroldoi");
		//update student
		studentDao.update(myStudent);
		//display the updated
		System.out.println("updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		//get a list of students
		List<Student> theStudents = studentDao.findByLastName("Dembee");

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		//get a list of students
		List<Student> theStudents = studentDao.findAll();
		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {
		//create a student object
		System.out.println("Creating new object====");
		Student tempStudent = new Student("ijilee", "tumee", "tumeee_sh@yahoo.com");

		//save the student
		System.out.println("Saving th student====");
		studentDao.save(tempStudent);
		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated Id: " + theId);
		//retrieve student based on the id: primary key
		Student myStudent = studentDao.findById(theId);
		//display student
		System.out.println("Found the student " + myStudent);
	}

	private void createStudent(StudentDao studentDao) {
		//create the student object
		System.out.println("Creating new object====");
		Student tempStudent = new Student("GEGEE", "DEMBEE", "GEGEE_sh@yahoo.com");
		//save the student object
		System.out.println("Saving th student====");
		studentDao.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
