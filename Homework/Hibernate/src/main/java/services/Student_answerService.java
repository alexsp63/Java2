package services;

import dao.Student_answerDao;
import models.Student_answer;
import models.Test_list;

import java.util.List;

public class Student_answerService {
    private Student_answerDao student_answerDao = new Student_answerDao();

    public Student_answerService(){}

    public void saveStudent_answer(Student_answer student_answer){
        student_answerDao.save(student_answer);
    }

    public Student_answer findStudent_answer(int id){
        return student_answerDao.findById(id);
    }

    public List<Test_list> getTestsByStudentId(int id) {
        return student_answerDao.getTestsByStudentId(id);
    }

    public List<Student_answer> findAll(){
        return student_answerDao.findAll();
    }
}
