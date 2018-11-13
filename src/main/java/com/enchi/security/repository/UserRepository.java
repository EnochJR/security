package com.enchi.security.repository;

import com.enchi.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByLoginName(String loginName);
}
