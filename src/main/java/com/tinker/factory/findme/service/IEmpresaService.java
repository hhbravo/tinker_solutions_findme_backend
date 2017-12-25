package com.tinker.factory.findme.service;

import com.tinker.factory.findme.canonico.Empresas;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmpresaService {

    List<Empresas> findAll();

    Empresas save(Empresas empresas);
}
