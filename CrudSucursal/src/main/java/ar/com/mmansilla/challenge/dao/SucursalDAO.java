package ar.com.mmansilla.challenge.dao;

import ar.com.mmansilla.challenge.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalDAO extends JpaRepository<Sucursal, Integer>{
    
}
