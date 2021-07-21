package com.kop.daegudot.domain.recommendschedule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface RecommendScheduleRepository extends JpaRepository<RecommendSchedule, Long> {
    Optional<ArrayList<RecommendSchedule>> findByHashtagId(long id);
}
