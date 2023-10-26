package com.schedule.manager.front.group.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomGroupRepositoryImpl implements CustomGroupRepository{
    @Autowired
    EntityManager entityManager;

    @Override
    public void deleteGroupById(Long groupId) {
        entityManager.createQuery("update Group g set g.deleteYn = true where g.id = :groupId")
                .setParameter("groupId", groupId)
                .executeUpdate();
    }
}
