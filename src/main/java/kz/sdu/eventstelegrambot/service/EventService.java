package kz.sdu.eventstelegrambot.service;

import kz.sdu.eventstelegrambot.dto.EventDto;

import java.util.List;

public interface EventService {

    EventDto show();

    List<EventDto> showAll();
}
