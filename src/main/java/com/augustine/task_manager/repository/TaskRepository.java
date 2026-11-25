package com.augustine.task_manager.repository;

import com.augustine.task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}