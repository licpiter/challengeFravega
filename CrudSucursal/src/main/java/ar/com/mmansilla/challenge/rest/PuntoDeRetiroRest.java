package ar.com.mmansilla.challenge.rest;

import ar.com.mmansilla.challenge.dao.PuntoDeRetiroDAO;
import ar.com.mmansilla.challenge.model.PuntoDeRetiro;
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
@RequestMapping("fravega/puntoderetiro")
public class PuntoDeRetiroRest {
    
    @Autowired
    private PuntoDeRetiroDAO puntoDeRetiroDAO;
    
    @PostMapping("/guardar")
    public void guardar(@RequestBody PuntoDeRetiro puntoDeRetiro){
        puntoDeRetiroDAO.save(puntoDeRetiro);
    }
    
    @GetMapping("/listar")
    public List<PuntoDeRetiro> listar() {
        return puntoDeRetiroDAO.findAll();
    }
    
    @GetMapping("/listar/{id}")
    public Optional<PuntoDeRetiro> listar(@PathVariable("id") Integer id) {
        return puntoDeRetiroDAO.findById(id);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        puntoDeRetiroDAO.deleteById(id);
    }
    
    @PutMapping("/actualizar")
    public void actualizar(@RequestBody PuntoDeRetiro puntoDeRetiro) {
        puntoDeRetiroDAO.save(puntoDeRetiro);
    }
}
