package com.software.RouteFlex.controllers;

import com.software.RouteFlex.models.PaqueteEnvio;
import com.software.RouteFlex.models.Ruta;
import com.software.RouteFlex.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ruta")
public class RutaController {

    @Autowired
    private RutaService rutaService;


    // Endpoint para crear una nueva ruta
    @PostMapping("/crear")
    public ResponseEntity<Ruta> crearRuta(@RequestBody List<PaqueteEnvio> paqueteEnvio) {
        try {
            Ruta rutaCreada = rutaService.crearRuta(paqueteEnvio);
            return new ResponseEntity<>(rutaCreada, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
