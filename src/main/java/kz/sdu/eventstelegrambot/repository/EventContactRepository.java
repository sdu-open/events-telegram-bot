package kz.sdu.eventstelegrambot.repository;

import kz.sdu.eventstelegrambot.entity.EventContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventContactRepository extends JpaRepository<EventContact, Integer> {
}