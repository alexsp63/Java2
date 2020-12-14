package dao;

import models.Schedule;
import models.Student_answer;
import models.Test_list;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class Student_answerDao {

    public void save(Student_answer student_answer){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student_answer);
        tx1.commit();
        session.close();
    }

    public void update(Student_answer student_answer){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student_answer);
        tx1.commit();
        session.close();
    }

    public void delete(Student_answer student_answer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student_answer);
        tx1.commit();
        session.close();
    }

    public Student_answer findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student_answer.class, id);
    }

    public List<Student_answer> findAll(){
        return (List<Student_answer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Student_answer").list();
    }

    public List<Test_list> getTestsByStudentId(int id){
        List<Student_answer> studentAnswers = findAll();
        ArrayList<Test_list> tests = new ArrayList<>();
        for (Student_answer s: studentAnswers) {
            if(s.getUser().getRow_id() == id) {
                tests.add(s.getTest());
            }
        }
        return tests;
    }
}
