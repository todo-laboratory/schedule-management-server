package com.schedule.manager.front.schedule.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomSchRepositoryImpl implements CustomSchRepository{
    @Autowired
    EntityManager entityManager;

    @Override
    public void deleteSchById(Long schId) {
        entityManager.createQuery("update Schedule s set s.deleteYn = true where s.id = :schId")
                .setParameter("schId", schId)
                .executeUpdate();
    }
}
