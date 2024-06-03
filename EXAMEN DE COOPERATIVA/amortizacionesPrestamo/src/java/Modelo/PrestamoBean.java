package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "prestamoBean")
@ViewScoped
public class PrestamoBean implements Serializable {

    private double monto;
    private int plazo;
    private double tasaMensual;
    private List<Amortizacion> amortizaciones ;

    public PrestamoBean() {
        amortizaciones = new ArrayList<>();
    }

    // Getters y setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getTasaMensual() {
        return tasaMensual;
    }

    public void setTasaMensual(double tasaMensual) {
        this.tasaMensual = tasaMensual;
    }

    public List<Amortizacion> getAmortizaciones() {
        return amortizaciones;
    }

    public void calcular() {
        amortizaciones.clear();
        double saldoInicial = monto;
        double saldo = saldoInicial;
        double abono = saldoInicial / plazo;
        double interes;
        double pago;

        for (int i = 1; i <= plazo; i++) {
            interes = saldo * (tasaMensual / 100);
            pago = abono + interes;

            amortizaciones.add(new Amortizacion(i, saldo, interes, abono, pago));

            if (i < plazo) {
                saldo -= abono;
            }
        }
    }
    
    
    public void reset(){
        monto = 0.0;
        plazo = 0;
        tasaMensual = 0.0;
        
        amortizaciones = null;
    }

}
