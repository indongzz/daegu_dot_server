package com.kop.daegudot.domain.subschedule;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface SubScheduleRepository extends JpaRepository<SubSchedule, Long> {
    ArrayList<SubSchedule> findByMainScheduleId(long id);
}
