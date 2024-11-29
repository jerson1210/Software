package com.software.RouteFlex.services;

import com.software.RouteFlex.models.AsignarRuta;

import java.util.List;

public interface IAsignarRutaService {

    //Crear
    AsignarRuta crearAsignarRuta(AsignarRuta asignarRuta);

    //Listar
    List<AsignarRuta> listarAsignaciones();

    //Eliminar
    void eliminarAsignacion(Long idAsignarRuta);
}
