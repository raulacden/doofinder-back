package com.rsp.doofinder.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsp.doofinder.entity.Author;


@Repository
public interface IAuthorRepo extends JpaRepository<Author, Long> {

}
