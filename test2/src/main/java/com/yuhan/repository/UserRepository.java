package com.yuhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
