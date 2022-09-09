import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Historial2 extends JFrame implements ActionListener {// Interfaz Historial2

    public JLabel IdCuenta,CUI,Nombre,Apellido;

    public JTextField Id,Cui,nombre,apellido;

    public JButton Mostrar;

    public Historial2(){// Constructor Historial2.
        this.setTitle("Historial de transacciones");
        this.setBounds(200,200,900,500);
        this.setLayout(null);

        IdCuenta = new JLabel("Id Cuenta");
        this.add(IdCuenta);
        IdCuenta.setBounds(50,30,100,20);

        Id = new JTextField();
        this.add(Id);
        Id.setBounds(25,50,105,20);

        Mostrar = new JButton("Mostrar transacciones");
        this.add(Mostrar);
        Mostrar.addActionListener(this);
        Mostrar.setBounds(155,40,200,30);

        CUI = new JLabel("CUI");
        this.add(CUI);
        CUI.setBounds(70,100,100,20);

        Cui = new JTextField();
        this.add(Cui);
        Cui.setBounds(25,120,105,20);

        Nombre = new JLabel("Nombre");
        this.add(Nombre);
        Nombre.setBounds(200,100,100,20);

        nombre = new JTextField();
        this.add(nombre);
        nombre.setBounds(175,120,105,20);

        Apellido = new JLabel("Apellido");
        this.add(Apellido);
        Apellido.setBounds(350,100,100,20);

        apellido = new JTextField();
        this.add(apellido);
        apellido.setBounds(325,120,105,20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int Idcuenta = Integer.parseInt(Id.getText());// añade el id de cada cuenta.
        for (int i = 0; i <Main.ArregloClientes.length; i++) {
            if(Main.ArregloClientes[i] != null){// verifica si el espacio esta vacio.
                for (int j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                    if(Main.ArregloClientes[i].getArregloCuenta()[j] != null && Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador() == Idcuenta){
                        Cui.setText(Main.ArregloClientes[i].getCUI());
                        nombre.setText(Main.ArregloClientes[i].getNombre());
                        apellido.setText(Main.ArregloClientes[i].getApellido());
                        String[] ArregloTitulos = {"Id", "Fecha", "Detalle","Debito","Credito","Saldo disponible"};// identificaciones de la columnas del historial.
                        DefaultTableModel dtm = new DefaultTableModel(Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones(), ArregloTitulos);// Muestra la tabla con los datos de las cuentas
                        final JTable table = new JTable(dtm);                                                                                            // y las acciones realizadas.

                        JScrollPane scrollPane = new JScrollPane(table);

                        scrollPane.setBounds(50,150,1000,300);
                        this.add(scrollPane);
                    }
                }
            }
        }
    }
}
