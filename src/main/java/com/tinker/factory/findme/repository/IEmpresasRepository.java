package com.tinker.factory.findme.repository;

import com.tinker.factory.findme.canonico.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmpresasRepository extends CrudRepository<Empresas, Integer>, JpaRepository<Empresas, Integer> {

}
