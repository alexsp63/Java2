package services;

import dao.GroupDao;
import models.Group;

import java.util.List;

public class GroupService {

    private GroupDao groupDao = new GroupDao();

    public GroupService(){}

    public void saveGroup(Group group){
        groupDao.save(group);
    }

    public Group findGroup(int id){
        return groupDao.findById(id);
    }

    public List<Group> findAll(){
        return groupDao.findAll();
    }
}
