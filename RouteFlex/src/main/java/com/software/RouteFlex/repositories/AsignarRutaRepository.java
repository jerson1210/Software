package com.software.RouteFlex.repositories;

import com.software.RouteFlex.models.AsignarRuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignarRutaRepository extends JpaRepository<AsignarRuta, Long> {

}
