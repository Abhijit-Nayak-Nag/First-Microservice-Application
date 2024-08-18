package com.student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServiceController {
	private static Map<String,List<Student>> schoolDB;
	static
	{
		schoolDB = new HashMap<String,List<Student>>();
		List<Student> studList = new ArrayList<>();
		Student stud = new Student("Raj","Class X");
		studList.add(stud);
		stud = new Student("Ramu","Class VIII");
		studList.add(stud);
		schoolDB.put("abcschool", studList);
		studList = new ArrayList<>();
		stud = new Student("Rutwik","Class IX");
		studList.add(stud);
		stud = new Student("Ramya","Class VI");
		studList.add(stud);
		schoolDB.put("xyzschool", studList);
	} 
	@RequestMapping("/getStudentDetailsForSchool/{schoolname}")
	public List<Student> getStudents(@PathVariable String schoolname)
	{
		List<Student> studList = schoolDB.get(schoolname);
		return studList;
	}
}
/*
APIs to access student-service
http://localhost:1111/getStudentDetailsForSchool/abcschool
http://localhost:1111/getStudentDetailsForSchool/xyzschool
 */
