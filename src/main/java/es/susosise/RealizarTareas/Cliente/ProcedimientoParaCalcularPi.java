package es.susosise.RealizarTareas.Cliente;

import java.math.BigDecimal;

import es.susosise.RealizarTareas.Servidor.TareaRemota;

public class ProcedimientoParaCalcularPi implements TareaRemota<BigDecimal> {
    private int cuantosDecimales;

    public ProcedimientoParaCalcularPi(int cuantosDecimales) {
        this.cuantosDecimales = cuantosDecimales;
    }

    @Override
    public BigDecimal ejecutar() {
        BigDecimal resultado;
        //TODO _pendiente_ de obtener resultado con los decimales requeridos
        return resultado;
    }
    
}
