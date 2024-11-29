package com.software.RouteFlex.repositories;

import com.software.RouteFlex.models.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface RutaRepository extends JpaRepository<Ruta, Long> {

}
