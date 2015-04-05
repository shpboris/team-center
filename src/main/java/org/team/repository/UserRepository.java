package org.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findOneByLogin(String login);
}
