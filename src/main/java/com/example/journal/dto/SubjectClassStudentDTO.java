package com.example.journal.dto;

import java.util.List;

import com.example.journal.entities.Mark;
import com.example.journal.entities.Student;
import com.example.journal.entities.Subject;

public record SubjectClassStudentDTO(Student student, List<Mark> mark) {

}
