package ar.com.mmansilla.challenge.rest;

import ar.com.mmansilla.challenge.model.Sucursal;
import ar.com.mmansilla.challenge.dao.SucursalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fravega/sucursal")
public class SucursalRest {
    
    @Autowired
    private SucursalDAO sucursalDAO;
    
    // Metodos HTTP : solicitudes al server
    // GET, POST, PUT, DELETE 
    // -> Estado 200 : OK // 500 : ERROR DEL DAO // 404 : ALGO MAL (RUTAS)
    
    // POST ==> localhost:8080/fravega/sucursal/guardar
    @PostMapping("/guardar")
    public void guardar(@RequestBody Sucursal sucursal) {
        sucursalDAO.save(sucursal);
    }
    
    
}
