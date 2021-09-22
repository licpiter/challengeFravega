package ar.com.mmansilla.challenge.rest;

import ar.com.mmansilla.challenge.dao.PuntoDeRetiroDAO;
import ar.com.mmansilla.challenge.dao.SucursalDAO;
import ar.com.mmansilla.challenge.model.Nodo;
import ar.com.mmansilla.challenge.model.Sucursal;
import ar.com.mmansilla.challenge.model.PuntoDeRetiro;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class NodoRestTest {
    
    @Mock
    private SucursalDAO sucursalDAO;
    @Mock
    private PuntoDeRetiroDAO pdrDAO;
    
    @InjectMocks
    private NodoRest nodoRest;
    @InjectMocks
    private SucursalRest sucursalRest;
    @InjectMocks
    private PuntoDeRetiroRest pdrRest;
    
    private Sucursal suc75;
    private Sucursal suc80;
    private PuntoDeRetiro pdr1;
    private PuntoDeRetiro pdr5;
    private Nodo nodoEn6;
    private Nodo nodoEn76;
    private Nodo nodoEn75;
    
    public NodoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        nodoEn6 = new Nodo(6.00, 6.00);
        nodoEn76 = new Nodo(76.00, 76.00);
        nodoEn75 = new Nodo(75.00, 75.00);
        
        suc75 = new Sucursal(75.00, 75.00, "75", "");
        suc80 = new Sucursal(80.00, 80.00, "80", "");
        sucursalRest.guardar(suc75);
        sucursalRest.guardar(suc80);

        pdr1 = new PuntoDeRetiro(1.00, 1.00, 100);
        pdr5 = new PuntoDeRetiro(5.00, 5.00, 100);
        pdrRest.guardar(pdr1);
        pdrRest.guardar(pdr5);
        
        Mockito.when(sucursalDAO.findAll()).thenReturn(List.of(suc75, suc80));
        Mockito.when(pdrDAO.findAll()).thenReturn(List.of(pdr1, pdr5));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCercano() {
        System.out.println("Test cercano");
        // el nodo mas cerca de "nodoEn6" sería "pdr5"
        Nodo resultadoCercanoNodo1 = nodoRest.cercano(nodoEn6.getLatitud(), nodoEn6.getLongitud());
        Assertions.assertEquals(resultadoCercanoNodo1.getId(), pdr5.getId());

        // el nodo mas cerca de "nodoEn76" sería "suc75"
        Nodo resultadoCercanoNodo2 = nodoRest.cercano(nodoEn76.getLatitud(), nodoEn76.getLongitud());
        Assertions.assertEquals(resultadoCercanoNodo2.getId(), suc75.getId());
    }

    @Test
    public void testCercano_param() {
        System.out.println("Test cercano_param");
        // el nodo mas cerca de "nodoEn6" sería "pdr5"
        Nodo resultadoCercanoNodo1 = nodoRest.cercano_param(nodoEn6.getLatitud(), nodoEn6.getLongitud());
        Assertions.assertEquals(resultadoCercanoNodo1.getId(), pdr5.getId());

        // el nodo mas cerca de "nodoEn76" sería "suc75"
        Nodo resultadoCercanoNodo2 = nodoRest.cercano_param(nodoEn76.getLatitud(), nodoEn76.getLongitud());
        Assertions.assertEquals(resultadoCercanoNodo2.getId(), suc75.getId());
    }

    @Test
    public void testListar() {
        System.out.println("Test listar");
        List<Nodo> listaNodos = nodoRest.listar();
        
        // Como se cargaron 4 nodos (2 sucursales + 2 puntos de retiro)
        // se verifica que listar me devuelva 4
        Assertions.assertEquals(4, listaNodos.size());
    }

    @Test
    public void testDistancias() {
        System.out.println("Test Distancias");
        
        // obtengo un mapa con la distancias de cada nodo respento del nodoEn75
        Map<Double, Nodo> resultDistancias = nodoRest.distancias(nodoEn75.getLatitud(), nodoEn75.getLongitud());
        
        //como uno de los nodos cargados está tambien en la coordenada (75.0, 75.0) ==> debe existir un nodo con distancia = 0.0
        boolean existeNodoConDistanciaCero = resultDistancias.keySet().stream().anyMatch(distancia -> distancia == 0.0);
        Assertions.assertEquals(existeNodoConDistanciaCero, true);
    }

}
