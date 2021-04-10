package com.popovaproject.project.repository;

import com.popovaproject.project.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
