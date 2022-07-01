package com.example.eschool.mappers;

import com.example.eschool.models.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.rmi.StubNotFoundException;
import java.util.List;

public interface StudentMapper {
    @Select(value = "SELECT * FROM students WHERE students.curatorId = #{curatorId}")
    List<Student> findAllFromCurator(int curatorId);

    @Select("DELETE FROM students WHERE id=#{id}")
    void deleteById(int id);

    @Select("SELECT * FROM students WHERE id=#{id}")
    Student findById(int id);

    @Select("SELECT * FROM students")
    List<Student> findAll();
    @Insert("INSERT INTO students (name, surname, curatorid, email) VALUES (#{name}, #{surname}, #{curatorId}, #{email})")
    void insert(Student student);
}
