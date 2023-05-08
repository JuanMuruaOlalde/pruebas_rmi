package es.susosise.RealizarTareas.Cliente;

import es.susosise.RealizarTareas.Servidor.Trabajador;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    private Trabajador stubTrabajador;

    public Cliente() {
        try {
            Registry registroDeServicios = LocateRegistry.getRegistry();
            stubTrabajador = (Trabajador) registroDeServicios.lookup("EjecutadorDeTareas");
        } catch (Exception e) {
            System.err.println("Fallo al iniciar el CLIENTE: " + e.toString());
            e.printStackTrace();
        }
    }

    public BigDecimal getPi(int conCuantosDecimales) throws RemoteException {
        ProcedimientoParaCalcularPi calcularPi = new ProcedimientoParaCalcularPi(conCuantosDecimales);
        return stubTrabajador.realizarTarea(calcularPi);
    }

    public DoblePrimo getDosPrimos() throws RemoteException {
        ProcedimientoParaObtenerPrimos obtenerDosPrimos = new ProcedimientoParaObtenerPrimos();
        return stubTrabajador.realizarTarea(obtenerDosPrimos);
    }

    public String concatenar(String texto1, String texto2, String texto3) throws RemoteException {
        ProcedimientoParaUnirTextos unirTextos = new ProcedimientoParaUnirTextos(texto1, texto2, texto3);
        return stubTrabajador.realizarTarea(unirTextos);
    }

}
