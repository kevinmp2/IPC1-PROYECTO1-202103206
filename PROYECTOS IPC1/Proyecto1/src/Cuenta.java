public class Cuenta {

    private Object[][] transacciones;
    private int identificador;
    private double saldo;

    public Cuenta(int identificador, double saldo){
      this.identificador = identificador;
      this.saldo = saldo;
      this.transacciones = new Object[20][6];



    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Object[][] getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Object[][] transacciones) {
        this.transacciones = transacciones;
    }
}
