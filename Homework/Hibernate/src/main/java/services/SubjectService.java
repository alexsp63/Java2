package services;

import dao.SubjectDao;
import models.Subject;

import java.util.List;

public class SubjectService {

    private SubjectDao subjectDao = new SubjectDao();

    public SubjectService(){}

    public void saveSubject(Subject subject){
        subjectDao.save(subject);
    }

    public Subject findSubject(int id){
        return subjectDao.findById(id);
    }

    public List<Subject> findAll(){
        return subjectDao.findAll();
    }
}
