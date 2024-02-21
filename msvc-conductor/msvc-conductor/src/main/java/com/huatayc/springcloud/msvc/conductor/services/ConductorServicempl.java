package com.huatayc.springcloud.msvc.conductor.services;

import com.huatayc.springcloud.msvc.conductor.models.entity.Conductor;
import com.huatayc.springcloud.msvc.conductor.repositories.ConductorRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ConductorServicempl implements ConductorService {

    @Autowired
    private ConductorRepository repository;

    @Override
    @Transactional
    public List<Conductor> listar() {
        return (List<Conductor>) repository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Conductor> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Conductor guardar(Conductor conductor) {
        return repository.save(conductor);
    }

    @Override
    public void eliminar(Long id) { repository.deleteById(id); }


    @Override
    public Boolean Datos() {
        List<Conductor> conductores = (List<Conductor>)repository.findAll();
         return  conductores.isEmpty();
    }


    @Override
    public List<Conductor> listarPorCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    public Conductor PorBrevete(String brevete) {
        return repository.findByBrevete(brevete);
    }

    @Override
    public void eliminarInfraccion(Boolean infraccion) {
        List<Conductor> conductores = repository.findByInfraccionado(infraccion);
        conductores.forEach(conductor -> repository.delete(conductor));
    }
}
