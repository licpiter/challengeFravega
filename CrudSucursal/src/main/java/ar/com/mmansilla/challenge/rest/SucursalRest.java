package ar.com.mmansilla.challenge.rest;

import ar.com.mmansilla.challenge.model.Sucursal;
import ar.com.mmansilla.challenge.dao.SucursalDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/listar")
    public List<Sucursal> listar() {
        return sucursalDAO.findAll();
    }
    
    @GetMapping("/listar/{id}")
    public Optional<Sucursal> listar(@PathVariable("id") Integer id) {
        return sucursalDAO.findById(id);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        sucursalDAO.deleteById(id);
    }
    
    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Sucursal sucursal ) {
        sucursalDAO.save(sucursal);
    }
}
