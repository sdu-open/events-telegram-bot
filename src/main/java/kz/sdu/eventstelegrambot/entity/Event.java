package kz.sdu.eventstelegrambot.entity;

import kz.sdu.eventstelegrambot.enums.EventStatus;
import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Event")
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "general_title", nullable = false)
    private String generalTitle;
    @Lob
    @Column(name = "image")
    private Blob image;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStatus status;
    @Column(name = "enable")
    private Boolean enable;
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = EventContact.class)
    @JoinTable(name = "event_contacts_connection",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Set<EventContact> contacts;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "user_creator", nullable = false, updatable = false)
    private Integer userCreator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        return getId().equals(event.getId()) && getStatus() == event.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
