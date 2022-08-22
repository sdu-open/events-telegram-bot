package kz.sdu.eventstelegrambot.repository;

import kz.sdu.eventstelegrambot.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, Integer> {
}