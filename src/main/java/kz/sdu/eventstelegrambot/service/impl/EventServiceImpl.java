package kz.sdu.eventstelegrambot.service.impl;

import kz.sdu.eventstelegrambot.dto.EventContactDto;
import kz.sdu.eventstelegrambot.dto.EventDto;
import kz.sdu.eventstelegrambot.entity.Event;
import kz.sdu.eventstelegrambot.repository.EventRepository;
import kz.sdu.eventstelegrambot.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventDto show() {
        Event event = repository.findTopByEnable(true);
        return convertToDto(event);
    }

    @Override
    public List<EventDto> showAll() {
        List<Event> events = repository.findEventsByEnable(true);

        return events.stream().map(this::convertToDto).toList();
    }

    private EventDto convertToDto(Event event) {
        var contacts = event.getContacts().stream()
                .map(contact -> EventContactDto.builder()
                        .id(contact.getId())
                        .name(contact.getName())
                        .phoneNumber(contact.getPhoneNumber())
                        .email(contact.getEmail())
                        .build())
                .collect(Collectors.toSet());

        return EventDto.builder()
                .id(event.getId())
                .generalTitle(event.getGeneralTitle())
                .title(event.getTitle())
                .description(event.getDescription())
                .image(event.getImage())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .contacts(contacts)
                .build();
    }
}
