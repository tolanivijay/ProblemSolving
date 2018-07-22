package com.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.model.Student;

public class EmpMapper implements FieldSetMapper<Student>{

	public Student mapFieldSet(FieldSet fieldSet) throws BindException {
		Student stud = new Student();
		stud.setName(fieldSet.readString(0));
		stud.setAge(fieldSet.readInt(1));
		stud.setSalary(fieldSet.readInt(2));
		return stud;
	}

}
