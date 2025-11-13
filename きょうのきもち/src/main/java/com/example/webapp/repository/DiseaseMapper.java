package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.webapp.entity.Choice;
import com.example.webapp.entity.Disease;

@Mapper
public interface DiseaseMapper {
	List<Disease> findAllDiseases();
    Integer findIdByName(@Param("name") String name);
    void insertDisease(@Param("name") String name);
    void insertChoice(Choice choice);
}
