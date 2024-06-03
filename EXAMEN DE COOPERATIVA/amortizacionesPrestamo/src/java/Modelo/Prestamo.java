package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Prestamo {

    private double monto;
    private int plazo;
    private double tasaMensual;

    public Prestamo(double monto, int plazo, double tasaMensual) {
        this.monto = monto;
        this.plazo = plazo;
        this.tasaMensual = tasaMensual / 100.0; // Convierte la tasa a decimal
    }

    public List<Amortizacion> calcularAmortizacion() {
        List<Amortizacion> amortizaciones = new ArrayList<>();
        double saldo = monto;
        double abono = monto / plazo;

        for (int i = 1; i <= plazo; i++) {
            double interes = saldo * tasaMensual;
            double pago = interes + abono;
            saldo -= abono;
            amortizaciones.add(new Amortizacion(i, saldo, interes, abono, pago));
        }
        return amortizaciones;
    }
}


