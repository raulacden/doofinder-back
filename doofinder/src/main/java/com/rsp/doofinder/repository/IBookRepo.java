package com.rsp.doofinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsp.doofinder.entity.Book;

public interface IBookRepo extends JpaRepository<Book, Long> {

}
