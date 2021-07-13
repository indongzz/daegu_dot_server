package com.kop.daegudot.domain.mainschedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface MainScheduleRepository extends JpaRepository<MainSchedule, Long> {
    Optional<ArrayList<MainSchedule>> findByUserId(long userId);
}
