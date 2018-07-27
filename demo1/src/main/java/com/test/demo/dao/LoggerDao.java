package com.test.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.entity.LoggerEntity;

@Repository
public interface LoggerDao extends JpaRepository<LoggerEntity,Long>{

}
