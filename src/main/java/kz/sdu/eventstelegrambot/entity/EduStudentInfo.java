package kz.sdu.eventstelegrambot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "student_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EduStudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NaturalId
    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EduStudentInfo that)) return false;
        return getStudentId().equals(that.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }
}
