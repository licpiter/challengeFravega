package ar.com.mmansilla.challenge.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="sucursal")
public class Sucursal extends Nodo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String direccion;
    private String horario_atencion;

    public Sucursal() {
        super();
        this.direccion = "SIN DATOS";
        this.horario_atencion = "SIN DATOS";
    }
    
    public Sucursal(String direccion, String horario_atencion) {
        super();
        this.direccion = direccion;
        this.horario_atencion = horario_atencion;
    }
    
    public Sucursal(double latitud, double longitud, String direccion, String horario_atencion) {
        super(latitud, longitud);
        this.direccion = direccion;
        this.horario_atencion = horario_atencion;
    }

    public Sucursal(double latitud, double longitud) {
        super(latitud, longitud);
        this.direccion = "SIN DATOS";
        this.horario_atencion = "SIN DATOS";
    }
    
}
