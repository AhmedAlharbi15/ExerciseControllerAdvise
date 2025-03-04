package com.example.capstone2.Repository;

import com.example.capstone2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserID(Integer id);

    User findUserByName(String name);



}