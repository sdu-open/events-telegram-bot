package kz.sdu.eventstelegrambot.repository;

import kz.sdu.eventstelegrambot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
