public class Cuenta {

    private Object[][] transacciones;// Arreglo para guardar las acciones que realizen los clientes
    private int identificador;
    private double saldo;

    public Cuenta(int identificador, double saldo){// Constructor Cuenta.
      this.identificador = identificador;
      this.saldo = saldo;
      this.transacciones = new Object[20][6];// Arreglo para guardar las diferentes acciones



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
