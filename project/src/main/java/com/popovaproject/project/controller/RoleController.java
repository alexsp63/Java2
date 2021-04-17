package com.popovaproject.project.controller;

import com.popovaproject.project.entity.Role;
import com.popovaproject.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(value="/api/role")
    private ResponseEntity<?> create(@RequestBody Role role){
        Role newRole = roleService.create(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/role")
    private ResponseEntity<List<Role>> readAll(){
        final List<Role> roleList = roleService.findAll();
        return roleList != null && !roleList.isEmpty()
                ? new ResponseEntity<>(roleList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "api/role/{id}")
    public ResponseEntity<Role> getOne(@PathVariable(name = "id") Role role) {
        final Role currentRole = role;
        return role != null
                ? new ResponseEntity<>(currentRole, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "api/role/{id}")
    public ResponseEntity<?> put(@PathVariable(name = "id") Role roleFromDB,
                                 @RequestBody Role role) {
        Role updatedRole = roleService.update(role, roleFromDB);
        if (updatedRole != null) {
            return new ResponseEntity<>(updatedRole, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "api/role/{id}")
    public ResponseEntity<List<Role>> delete(@PathVariable(name = "id") Role role) {
        if (roleService.delete(role)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
