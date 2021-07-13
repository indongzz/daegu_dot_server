package com.kop.daegudot.domain.subschedule;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface SubScheduleRepository extends JpaRepository<SubSchedule, Long> {
    Optional<ArrayList<SubSchedule>> findByMainScheduleId(long id);
}
