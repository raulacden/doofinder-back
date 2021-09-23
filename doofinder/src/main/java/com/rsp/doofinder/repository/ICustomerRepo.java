package com.rsp.doofinder.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsp.doofinder.entity.Customer;


@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Long> {

}
