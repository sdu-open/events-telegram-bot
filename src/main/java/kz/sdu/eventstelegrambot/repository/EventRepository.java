package kz.sdu.eventstelegrambot.repository;

import kz.sdu.eventstelegrambot.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {


    List<Event> findEventsByEnable(Boolean enable);

    Event findTopByEnable(Boolean enable);
}