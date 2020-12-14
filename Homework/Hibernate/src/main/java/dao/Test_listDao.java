package dao;

import models.Subject;
import models.Test_list;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Test_listDao {

    public void save(Test_list test_list){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(test_list);
        tx1.commit();
        session.close();
    }

    public void update(Test_list test_list){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(test_list);
        tx1.commit();
        session.close();
    }

    public void delete(Test_list test_list) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(test_list);
        tx1.commit();
        session.close();
    }

    public Test_list findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Test_list.class, id);
    }

    public List<Test_list> findAll(){
        return (List<Test_list>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Test_list").list();
    }
}
