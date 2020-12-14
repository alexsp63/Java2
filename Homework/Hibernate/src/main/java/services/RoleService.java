package services;

import dao.RoleDao;
import models.Role;

import java.util.List;

public class RoleService {

    private RoleDao roleDao = new RoleDao();

    public RoleService(){}

    public void saveRole(Role Role){
        roleDao.save(Role);
    }

    public Role findRole(int id){
        return roleDao.findById(id);
    }

    public List<Role> findAll(){
        return roleDao.findAll();
    }
}
