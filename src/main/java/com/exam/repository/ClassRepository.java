package com.exam.repository;

import com.exam.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository
        extends JpaRepository<ClassEntity, Long> {

    List<ClassEntity> findAll();
    List<ClassEntity> findAllByOrderByDisplayOrderAsc();

}