package com.progress.progressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progress.progressservice.entity.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Integer>{

}
