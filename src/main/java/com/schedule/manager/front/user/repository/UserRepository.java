package com.schedule.manager.front.user.repository;

import com.schedule.manager.front.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {
    @Override
    Optional<User> findById(Long userId);

    void deleteById(Long userId);

}
