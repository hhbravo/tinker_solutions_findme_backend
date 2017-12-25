package com.tinker.factory.findme.service.impl;

import com.tinker.factory.findme.canonico.Empresas;
import com.tinker.factory.findme.repository.IEmpresasRepository;
import com.tinker.factory.findme.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private IEmpresasRepository empresasRepository;

    @Override
    public List<Empresas> findAll() {
        return empresasRepository.findAll();
    }

    @Override
    public Empresas save(Empresas empresas) {
        return empresasRepository.save(empresas);
    }


}
