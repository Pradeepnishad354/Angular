package com.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.FileDB;

public interface  FileDBRepository extends JpaRepository<FileDB,String> {

	Optional<FileDB> findById(String id);

}
