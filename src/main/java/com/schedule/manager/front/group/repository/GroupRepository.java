package com.schedule.manager.front.group.repository;

import com.schedule.manager.front.group.entity.Group;
import com.schedule.manager.front.user.entity.User;
import com.schedule.manager.front.user.repository.CustomUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>, CustomGroupRepository {
    @Override
    Optional<Group> findById(Long groupId);
}
