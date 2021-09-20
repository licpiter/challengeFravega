package ar.com.mmansilla.challenge.rest;

import ar.com.mmansilla.challenge.dao.PuntoDeRetiroDAO;
import ar.com.mmansilla.challenge.model.PuntoDeRetiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fravega/puntoderetiro")
public class PuntoDeRetiroRest {
    
    @Autowired
    private PuntoDeRetiroDAO puntoDeRetiroDAO;
    
    @PostMapping("/guardar")
    public void guardar(@RequestBody PuntoDeRetiro puntoDeRetiro){
        puntoDeRetiroDAO.save(puntoDeRetiro);
    }
}
