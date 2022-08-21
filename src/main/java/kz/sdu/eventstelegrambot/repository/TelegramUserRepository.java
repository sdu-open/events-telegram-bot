package kz.sdu.eventstelegrambot.repository;

import kz.sdu.eventstelegrambot.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, Integer> {
}