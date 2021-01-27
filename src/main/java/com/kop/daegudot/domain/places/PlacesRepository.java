package com.kop.daegudot.domain.places;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PlacesRepository extends JpaRepository<Places, Long> {
    ArrayList<Places> findAll();
}
