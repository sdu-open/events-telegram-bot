package kz.sdu.eventstelegrambot.repository;

import kz.sdu.eventstelegrambot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}