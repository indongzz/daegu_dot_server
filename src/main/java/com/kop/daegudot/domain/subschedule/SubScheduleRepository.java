package com.kop.daegudot.domain.subschedule;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SubScheduleRepository extends JpaRepository<SubSchedule, Long> {
    SubSchedule findByMainScheduleId(long id);
}
