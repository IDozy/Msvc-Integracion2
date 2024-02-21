package com.huatayc.springcloud.msvc.conductor.services;

import com.huatayc.springcloud.msvc.conductor.models.entity.Conductor;

import java.util.List;
import java.util.Optional;

public interface ConductorService {
    List<Conductor> listar();
    Optional<Conductor> porId(Long id);
    Conductor guardar(Conductor conductor);
    void eliminar(Long id);


    List<Conductor> listarPorCategoria(String categoria);
    Conductor PorBrevete(String brevete);

    void eliminarInfraccion(Boolean infraccionado);

    Boolean Datos();

}
