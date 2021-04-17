package com.popovaproject.project.repository;

import com.popovaproject.project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
