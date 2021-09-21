package ar.com.mmansilla.challenge.rest;

import ar.com.mmansilla.challenge.dao.PuntoDeRetiroDAO;
import ar.com.mmansilla.challenge.dao.SucursalDAO;
import ar.com.mmansilla.challenge.model.Nodo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fravega/nodo")
public class NodoRest {

    @Autowired
    private PuntoDeRetiroDAO puntoDeRetiroDAO;

    @Autowired
    private SucursalDAO sucursalDAO;

    @GetMapping("/cercano/{latitud}/{longitud}")
    public Nodo cercano(@PathVariable("latitud") double latitud,
                        @PathVariable("longitud") double longitud) {
        Nodo nodo = new Nodo(latitud, longitud);
        return nodoMasCercano(nodo);
    }

    @GetMapping("/listar")
    public List<Nodo> listar() {
        return listarNodos();
    }

    @GetMapping("/distancias/{latitud}/{longitud}")
    public Map<Double, Nodo> distancias(@PathVariable("latitud") double latitud,
                                        @PathVariable("longitud") double longitud) {
        Nodo nodo = new Nodo(latitud, longitud);
        return distanciaNodo(nodo);
    }

    private Nodo nodoMasCercano(Nodo nodo) {
        TreeMap<Double, Nodo> mapa = distanciaNodo(nodo);
        return mapa.firstEntry().getValue();
    }

    public TreeMap<Double, Nodo> distanciaNodo(Nodo nodo) {
        List<Nodo> listaNodos = listarNodos();
        TreeMap<Double, Nodo> mapa = new TreeMap<>();
        listaNodos.forEach(nodito -> mapa.put(distanciaHaversine(nodito, nodo), nodito));
        return mapa;
    }

    public List<Nodo> listarNodos() {
        List<Nodo> listaNodos = new ArrayList<>();
        sucursalDAO.findAll().forEach((suc) -> {
            listaNodos.add(new Nodo(suc.getId(), suc.getLatitud(), suc.getLongitud()));
        });
        puntoDeRetiroDAO.findAll().forEach((pdr) -> {
            listaNodos.add(new Nodo(pdr.getId(), pdr.getLatitud(), pdr.getLongitud()));
        });
        return listaNodos;
    }

    // retorna la distancia medida en kilometros
    static double distanciaHaversine(Nodo nodo1, Nodo nodo2) {
        double lat1 = nodo1.getLatitud();
        double lon1 = nodo1.getLongitud();
        double lat2 = nodo2.getLatitud();
        double lon2 = nodo2.getLongitud();

        // distancia entre latitudes y longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // en radianes
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // formula de Haversine
        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.pow(Math.sin(dLon / 2), 2)
                * Math.cos(lat1)
                * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return RADIO_TIERRA * c;
    }
    public static final int RADIO_TIERRA = 6371; // radio promedio en kms
}
