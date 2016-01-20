package com.gxkj.projects.myshopx.dao;

import com.gxkj.projects.myshopx.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 2016/1/19.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    public List<User> doListTest(int age, String name);
}
