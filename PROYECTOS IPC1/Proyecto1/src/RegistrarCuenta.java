import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarCuenta extends JFrame implements ActionListener {
    public JComboBox clientes;
    public JButton Crear;

    public RegistrarCuenta() {
        this.setTitle("Crear Cliente");
        this.setBounds(200, 200, 500, 500);
        this.setLayout(null);

        clientes = new JComboBox();
        this.add(clientes);
        clientes.setBounds(180, 100, 200, 30);

        for (int i = 0; i < Main.ArregloClientes.length; i++) {
           if(Main.ArregloClientes[i] != null) {
               clientes.addItem(Main.ArregloClientes[i].getCUI());
           }
        }

        Crear = new JButton("Crear");
        this.add(Crear);
        Crear.addActionListener(this);
        Crear.setBounds(200, 300, 150, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Crear){
            Cuenta cuenta = new Cuenta(Main.ID, 0);
            Main.ID++;

            String Cui = (String) clientes.getSelectedItem();
            for (int i = 0; i < Main.ArregloClientes.length; i++) {
                if(Main.ArregloClientes[i] != null && Cui .equals(Main.ArregloClientes[i].getCUI())){
                 Main.ArregloClientes[i].agregarCuenta(cuenta);
                }
            }

        }
    }

}