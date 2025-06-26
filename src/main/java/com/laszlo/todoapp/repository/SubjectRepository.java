package com.laszlo.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laszlo.todoapp.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}