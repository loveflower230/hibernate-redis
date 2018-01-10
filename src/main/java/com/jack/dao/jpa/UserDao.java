package com.jack.dao.jpa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jack.domain.User;


@Qualifier("userDao")
public interface UserDao extends JpaRepository<User, Integer> {

}
