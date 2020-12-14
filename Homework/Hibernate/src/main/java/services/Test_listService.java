package services;

import dao.Test_listDao;
import models.Test_list;

import java.util.List;

public class Test_listService {

    private Test_listDao test_listDao = new Test_listDao();

    public Test_listService(){}

    public void saveTest_list(Test_list test_list){
        test_listDao.save(test_list);
    }

    public Test_list findTest_list(int id){
        return test_listDao.findById(id);
    }

    public List<Test_list> findAll(){
        return test_listDao.findAll();
    }
}
