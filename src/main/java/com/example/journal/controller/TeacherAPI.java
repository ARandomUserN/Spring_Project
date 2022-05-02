package com.example.journal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.journal.dto.SubjectClassStudentDTO;
import com.example.journal.dto.SubjectDTO;
import com.example.journal.entities.Mark;
import com.example.journal.entities.Teacher;
import com.example.journal.services.TeacherManager;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/teachers")
public class TeacherAPI {
	private TeacherManager teacherManager;
	
	@Autowired
	public TeacherAPI(TeacherManager teacherManager)
	{
		this.teacherManager = teacherManager;
	}
	
	@GetMapping("/all")
	public Iterable<Teacher> getAll()
	{
		return teacherManager.findAll();
	}
	
	@GetMapping("/id")
	public Optional<Teacher> getById(@RequestParam Long index) {
		return teacherManager.findById(index);
	}
	@GetMapping(value = "/{teacherId}")
	public Optional<Teacher> getId(@PathVariable("teacherId") Long  teacherId) {
		return teacherManager.findById(teacherId);
	}
	
	//List of taught subjects
	@GetMapping("/id/subjects")
	public List<SubjectDTO> getSubjectsById(@RequestParam Long teacherId){
		return teacherManager.findSubjects(teacherId);
	}
	@GetMapping("/{teacherId}/subjects")
	public List<SubjectDTO> getSubjects(@PathVariable("teacherId") Long teacherId){
		return teacherManager.findSubjects(teacherId);
	}
	
	// List of Classes filtered by subject
	@GetMapping("/id/subjects/subId")
	public List<SubjectDTO> getClassyearsBySubject(@RequestParam Long id, @RequestParam Long subId){
		return teacherManager.findClassyearBySubject(id,subId);
	}
	@GetMapping("/{teacherId}/subjects/{subjectId}")
	public List<SubjectDTO> getClassyears(@PathVariable("teacherId") Long teacherId,@PathVariable("subjectId") Long subjectId){
		return teacherManager.findClassyearBySubject(teacherId,subjectId);
	}

	//Students in class + marks
	@GetMapping("/id/subjects/subId/classes/classId")
	public List<SubjectClassStudentDTO> getStudentsByClassyear(@RequestParam Long id, @RequestParam Long subId,@RequestParam Long classId){
		return teacherManager.findStudentsByClassAndSubject(id, subId, classId);
	}
	@GetMapping("/{teacherId}/subjects/{subjectId}/classes/{classyearId}")
	public List<SubjectClassStudentDTO> getStudents(@PathVariable("teacherId") Long teacherId,@PathVariable("subjectId") Long subjectId,@PathVariable("classyearId") Long classyearId){
		return teacherManager.findStudentsByClassAndSubject(teacherId, subjectId, classyearId);
	}
	
	// JSON to send from client
	//{
	//    "value": double,
	//    "weight": Long,
	//    "studentId": Long, // id of existing student, available from the same endpoint
	//    "type": string
	//}
	@PostMapping("/{teacherId}/subjects/{subjectId}/classes/{classyearId}")
	public void postMark(@RequestBody ObjectNode JSONNode, @PathVariable("subjectId") Long subjectId) {
		Mark mk = new Mark(JSONNode.get("value").asDouble(), JSONNode.get("weight").asLong(), subjectId, JSONNode.get("studentId").asLong(), JSONNode.get("type").asText());
		teacherManager.addMark(mk);
	}
	
	// JSON to send from client
	//{
	//    "markId": Long, // id of existing mark, available from the same endpoint
	//}
	@DeleteMapping("/{teacherId}/subjects/{subjectId}/classes/{classyearId}")
	public void deleteMark(@RequestBody ObjectNode JSONNode) {
		teacherManager.deleteMarkById(JSONNode.get("markId").asLong());
	}
	
	
	// JSON to send from client
	//{
	//    "markId": Long, // id of existing mark, available from the same endpoint
	//    "value": double,
	//    "weight": Long,
	//    "studentId": Long, // id of existing student, available from the same endpoint
	//    "type": string
	//}
	@PutMapping("/{teacherId}/subjects/{subjectId}/classes/{classyearId}")
	public void putMark(@RequestBody ObjectNode JSONNode) {
		teacherManager.updateMark(JSONNode.get("markId").asLong(), JSONNode.get("value").asDouble(), JSONNode.get("weight").asLong(), JSONNode.get("type").asText(), JSONNode.get("studentId").asLong());
	}
	
	@PostMapping("/save")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherManager.save(teacher);
	}

	@PutMapping("/upd")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		return teacherManager.save(teacher);
	}

	@DeleteMapping("/del")
	public void deleteTeacher(@RequestParam Long index) {
		teacherManager.deleteById(index);
	}
	
	
}
