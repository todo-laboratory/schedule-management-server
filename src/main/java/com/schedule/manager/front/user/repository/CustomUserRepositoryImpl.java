package com.schedule.manager.front.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomUserRepositoryImpl implements CustomUserRepository{

    @Autowired
    EntityManager entityManager;

    @Override
    public void deleteUserById(Long userId) {
        entityManager.createQuery("update User u set u.deleteYn = true where u.id = :userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }
}
