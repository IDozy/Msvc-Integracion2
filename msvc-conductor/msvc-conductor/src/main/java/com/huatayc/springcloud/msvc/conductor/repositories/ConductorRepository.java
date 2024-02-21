package com.huatayc.springcloud.msvc.conductor.repositories;

import com.huatayc.springcloud.msvc.conductor.models.entity.Conductor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConductorRepository  extends CrudRepository<Conductor,Long> {

    List<Conductor> findByCategoria(String categoria);
    Conductor findByBrevete(String brevete);
    List<Conductor> findByInfraccionado(Boolean infraccionado);

}


