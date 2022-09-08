import javax.swing.*;

public class Cliente extends JFrame{
    private String CUI;
    private String Nombre;
    private String Apellido;

    private Cuenta[] arregloCuenta;
    public Cliente(String CUI,String Nombre,String Apellido){

        this.CUI=CUI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.arregloCuenta = new Cuenta[5];

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

    public void agregarCuenta(Cuenta cuenta){
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


