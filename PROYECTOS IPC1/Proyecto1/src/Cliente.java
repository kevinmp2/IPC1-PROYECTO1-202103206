import javax.swing.*;

public class Cliente extends JFrame{// Interfaz para la ventana de los clientes.
    private String CUI;
    private String Nombre;
    private String Apellido;

    private Cuenta[] arregloCuenta;// Arreglo para las cuentas de los clientes.
    public Cliente(String CUI,String Nombre,String Apellido){// Constructor para el objeto cliente.

        this.CUI=CUI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.arregloCuenta = new Cuenta[5];// Arreglo de las cinco cuentas por cada cliente.

    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void agregarCuenta(Cuenta cuenta){ // Agrega la cuenta de los clientes.
        for (int i = 0; i < this.arregloCuenta.length; i++) {
            if(this.arregloCuenta[i] == null ){
                this.arregloCuenta[i] = cuenta;
                JOptionPane.showMessageDialog(this, "Cuenta creado exitosamente");
                return;
            }

        }
        JOptionPane.showMessageDialog(this, "No se pueden registra mas de cinco cuentas por cliente");
    }

    public Cuenta[] getArregloCuenta() {
        return arregloCuenta;
    }

    public void setArregloCuenta(Cuenta[] arregloCuenta) {
        this.arregloCuenta = arregloCuenta;
    }
}


