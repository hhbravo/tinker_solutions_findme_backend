package com.tinker.factory.findme.resource;

import com.tinker.factory.findme.canonico.Empresas;
import com.tinker.factory.findme.service.IEmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class EmpresasResource {
    private final Logger LOG = LoggerFactory.getLogger(EmpresasResource.class);

    @Autowired
    private IEmpresaService empresaService;


    @RequestMapping(value = "/empresa/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Empresas getAllEmpresas(Empresas empresas) {
        return empresaService.save(empresas);
    }
}
