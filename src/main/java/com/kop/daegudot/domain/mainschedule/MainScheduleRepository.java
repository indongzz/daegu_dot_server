package com.kop.daegudot.domain.mainschedule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface MainScheduleRepository extends JpaRepository<MainSchedule, Long> {
    ArrayList<MainSchedule> findByUserId(long userId);
}
