package com.noteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noteapp.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long>{

}
