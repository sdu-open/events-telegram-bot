package kz.sdu.eventstelegrambot.repository;

import kz.sdu.eventstelegrambot.entity.EduStudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EduStudentInfoRepository extends JpaRepository<EduStudentInfo, Integer> {
}