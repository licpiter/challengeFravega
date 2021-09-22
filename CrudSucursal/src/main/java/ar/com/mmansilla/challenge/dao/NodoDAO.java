package ar.com.mmansilla.challenge.dao;

import ar.com.mmansilla.challenge.model.Nodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodoDAO extends JpaRepository<Nodo, Integer>{
    
}
