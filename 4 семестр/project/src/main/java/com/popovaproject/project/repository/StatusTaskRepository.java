package com.popovaproject.project.repository;

import com.popovaproject.project.entity.StatusTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTaskRepository extends JpaRepository<StatusTask, Long> {
}
