package com.example.journal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.journal.dto.StudentRemarksDTO;
import com.example.journal.dto.SubjectClassStudentDTO;
import com.example.journal.dto.SubjectDTO;
import com.example.journal.dto.TeacherDTO;
import com.example.journal.entities.Mark;
import com.example.journal.entities.Teacher;
import com.example.journal.services.TeacherManager;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/teachers")
public class TeacherAPI {
	private TeacherManager teacherManager;

	private Authentication auth;
	
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
	public TeacherDTO getById(@RequestParam Long index) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		TeacherDTO teacher = teacherManager.findById(index);
		if(auth.getName().equals(teacher.email())) {
			return teacher;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	@GetMapping(value = "/{teacherId}")
	public TeacherDTO getId(@PathVariable("teacherId") Long  teacherId) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		TeacherDTO teacher = teacherManager.findById(teacherId);
		if(auth.getName().equals(teacher.email())) {
			return teacher;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	
	//List of taught subjects
	@GetMapping("/id/subjects")
	public List<SubjectDTO> getSubjectsById(@RequestParam Long teacherId){
		List<SubjectDTO> subjectList = teacherManager.findSubjects(teacherId);
		auth = SecurityContextHolder.getContext().getAuthentication();
		String email = teacherManager.findEmailById(teacherId);
		if(auth.getName().equals(email)) {
			return subjectList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
	}
	@GetMapping("/{teacherId}/subjects")
	public List<SubjectDTO> getSubjects(@PathVariable("teacherId") Long teacherId){
		List<SubjectDTO> subjectList = teacherManager.findSubjects(teacherId);
		auth = SecurityContextHolder.getContext().getAuthentication();
		String email = teacherManager.findEmailById(teacherId);
		if(auth.getName().equals(email)) {
			return subjectList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	
	// List of Classes filtered by subject
	@GetMapping("/id/subjects/subId")
	public List<SubjectDTO> getClassyearsBySubject(@RequestParam Long id, @RequestParam Long subId){
		List<SubjectDTO> subjectList = teacherManager.findClassyearBySubject(id,subId);
		auth = SecurityContextHolder.getContext().getAuthentication();
		String email = teacherManager.findEmailById(id);
		if(auth.getName().equals(email)) {
			return subjectList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	@GetMapping("/{teacherId}/subjects/{subjectId}")
	public List<SubjectDTO> getClassyears(@PathVariable("teacherId") Long teacherId,@PathVariable("subjectId") Long subjectId){
		List<SubjectDTO> subjectList = teacherManager.findClassyearBySubject(teacherId,subjectId);
		auth = SecurityContextHolder.getContext().getAuthentication();
		String email = teacherManager.findEmailById(teacherId);
		if(auth.getName().equals(email)) {
			return subjectList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}

	//Students in class + marks
	@GetMapping("/id/subjects/subId/classes/classId")
	public List<SubjectClassStudentDTO> getStudentsByClassyear(@RequestParam Long id, @RequestParam Long subId,@RequestParam Long classId){
		List<SubjectClassStudentDTO> subjectList = teacherManager.findStudentsByClassAndSubject(id, subId, classId);
		auth = SecurityContextHolder.getContext().getAuthentication();
		String email = teacherManager.findEmailById(id);
		if(auth.getName().equals(email)) {
			return subjectList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	@GetMapping("/{teacherId}/subjects/{subjectId}/classes/{classyearId}")
	public List<SubjectClassStudentDTO> getStudents(@PathVariable("teacherId") Long teacherId,@PathVariable("subjectId") Long subjectId,@PathVariable("classyearId") Long classyearId){

		List<SubjectClassStudentDTO> subjectList = teacherManager.findStudentsByClassAndSubject(teacherId, subjectId, classyearId);
		auth = SecurityContextHolder.getContext().getAuthentication();
		String email = teacherManager.findEmailById(teacherId);
		if(auth.getName().equals(email)) {
			return subjectList;
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
	
	// JSON to send from client
	//{
	//    "value": double,
	//    "weight": Long,
	//    "studentId": Long, // id of existing student, available from the same endpoint
	//    "type": string
	//}
	@PostMapping("/{teacherId}/subjects/{subjectId}/classes/{classyearId}")
	public void postMark(@RequestBody ObjectNode JSONNode, @PathVariable("teacherId") Long teacherId,@PathVariable("subjectId") Long subjectId) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		String email = teacherManager.findEmailById(teacherId);
		if(auth.getName().equals(email)) {
			Mark mk = new Mark(JSONNode.get("value").asDouble(), JSONNode.get("weight").asLong(), subjectId, JSONNode.get("studentId").asLong(), JSONNode.get("type").asText());
			teacherManager.addMark(mk);
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
	}
	
	// JSON to send from client
	//{
	//    "markId": Long, // id of existing mark, available from the same endpoint
	//}
	@DeleteMapping("/{teacherId}/subjects/{subjectId}/classes/{classyearId}")
	public void deleteMark(@RequestBody ObjectNode JSONNode, @PathVariable("teacherId") Long teacherId) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		String email = teacherManager.findEmailById(teacherId);
		if(auth.getName().equals(email)) {
			teacherManager.deleteMarkById(JSONNode.get("markId").asLong());
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
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
	public void putMark(@RequestBody ObjectNode JSONNode,@PathVariable("teacherId") Long teacherId) {
		auth = SecurityContextHolder.getContext().getAuthentication();
		String email = teacherManager.findEmailById(teacherId);
		if(auth.getName().equals(email)) {
			teacherManager.updateMark(JSONNode.get("markId").asLong(), JSONNode.get("value").asDouble(), JSONNode.get("weight").asLong(), JSONNode.get("type").asText(), JSONNode.get("studentId").asLong());
			
		}
		else
		{
			throw new  ResponseStatusException(HttpStatus.FORBIDDEN);
		}
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
