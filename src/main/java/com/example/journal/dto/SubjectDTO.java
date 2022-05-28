package com.example.journal.dto;

import com.example.journal.entities.Classyear;
import com.example.journal.entities.Subject;
import com.example.journal.entities.Teacher;

public record SubjectDTO(Subject subject,Classyear classyear, Teacher teacher) {

}
