package dao;

import models.Test;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public void save(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public User findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public List<User> findAll(){
        return (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM User").list();
    }

    public List<User> getTeachers() {
        List<User> users = findAll();
        ArrayList<User> teachers = new ArrayList<User>();
        for (User u: users) {
            if (u.getRole().getRow_id() == 2) {
                teachers.add(u);
            }
        }
        return teachers;
    }

    public List<User> getStudents() {
        List<User> users = findAll();
        ArrayList<User> students = new ArrayList<User>();
        for (User u: users) {
            if (u.getRole().getRow_id() == 1) {
                students.add(u);
            }
        }
        return students;
    }
}
