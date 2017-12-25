package com.tinker.factory.findme.resource;

import com.tinker.factory.findme.canonico.Empresas;
import com.tinker.factory.findme.service.IEmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/public")
public class PublicResource {
    private final Logger LOG = LoggerFactory.getLogger(PublicResource.class);

    @Autowired
    private IEmpresaService empresaService;

    @RequestMapping(value = "/empresas/all", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Empresas> getAllEmpresas() {

        return (List<Empresas>) empresaService.findAll();
    }
}
