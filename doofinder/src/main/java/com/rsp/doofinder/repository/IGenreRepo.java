package com.rsp.doofinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsp.doofinder.entity.Genre;

public interface IGenreRepo extends JpaRepository<Genre, Long> {

}
