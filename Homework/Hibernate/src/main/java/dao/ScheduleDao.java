package dao;

import models.Role;
import models.Schedule;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ScheduleDao {

    public void save(Schedule schedule){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(schedule);
        tx1.commit();
        session.close();
    }

    public void update(Schedule schedule){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(schedule);
        tx1.commit();
        session.close();
    }

    public void delete(Schedule schedule) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(schedule);
        tx1.commit();
        session.close();
    }

    public Schedule findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Schedule.class, id);
    }

    public List<Schedule> findAll(){
        return (List<Schedule>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Schedule").list();
    }
}
