package dao;

import models.Student_answer;
import models.Subject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class SubjectDao {

    public void save(Subject subject){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(subject);
        tx1.commit();
        session.close();
    }

    public void update(Subject subject){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(subject);
        tx1.commit();
        session.close();
    }

    public void delete(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(subject);
        tx1.commit();
        session.close();
    }

    public Subject findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Subject.class, id);
    }

    public List<Subject> findAll(){
        return (List<Subject>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Subject").list();
    }
}
