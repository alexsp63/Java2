package com.popovapi193kr.popova.repository;

import com.popovapi193kr.popova.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
