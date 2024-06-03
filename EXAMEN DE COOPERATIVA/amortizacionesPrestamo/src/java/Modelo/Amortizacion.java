package Modelo;

import java.text.DecimalFormat;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "amortizacion")
@ViewScoped
public class Amortizacion {

    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private int periodo;
    private double saldo;
    private double interes;
    private double abono;
    private double pago;

    public Amortizacion(int periodo, double saldo, double interes, double abono, double pago) {
        this.periodo = periodo;
        this.saldo = Double.parseDouble(decimalFormat.format(saldo));
        this.interes = Double.parseDouble(decimalFormat.format(interes));
        this.abono = Double.parseDouble(decimalFormat.format(abono));
        this.pago = Double.parseDouble(decimalFormat.format(pago));
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }
}


