package ar.com.mmansilla.challenge.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="sucursal")
public class Sucursal extends Nodo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String direccion;
    private String horario_atencion;

    public Sucursal() {
        super(TipoNodo.SUCURSAL);
        this.direccion = "SIN DATOS";
        this.horario_atencion = "SIN DATOS";
    }
    
    public Sucursal(String direccion, String horario_atencion) {
        super(TipoNodo.SUCURSAL);
        this.direccion = direccion;
        this.horario_atencion = horario_atencion;
    }
    
    public Sucursal(String direccion, String horario_atencion, double latitud, double longitud) {
        super(TipoNodo.SUCURSAL, latitud, longitud);
        this.direccion = direccion;
        this.horario_atencion = horario_atencion;
    }

    
}
