package kz.sdu.eventstelegrambot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "TelegramUser")
@Table(name = "telegram_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelegramUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NaturalId
    @Column(name = "chat_id", nullable = false, unique = true, updatable = false)
    private Integer chatId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelegramUser that)) return false;
        return getChatId().equals(that.getChatId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatId());
    }
}
