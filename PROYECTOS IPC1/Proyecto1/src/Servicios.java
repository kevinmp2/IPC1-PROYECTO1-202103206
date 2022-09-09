import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;

public class Servicios extends JFrame implements ActionListener {// Interfaz Servicios.

    public JLabel CuentaDebitar,TipoDeServicio,MontoS;

    public JComboBox Debitar, TipoServicio;

    public JTextField Monto;

    public JButton Aceptar;

    public Servicios(){// Constructor Servicios
        this.setTitle("Pago de servicios");
        this.setBounds(200,200,600,600);
        this.setLayout(null);

        CuentaDebitar = new JLabel("Cuenta a debitar");
        this.add(CuentaDebitar);
        CuentaDebitar.setBounds(230,100,100,20);

        Debitar = new JComboBox();// Jcombobox llenado con los clientes.
        for (int i = 0; i <Main.ArregloClientes.length; i++) {
            if(Main.ArregloClientes[i] != null){// verifica si el espacio del arreglo esta vacio para poder agregar algun cliente
                for (int j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                    if(Main.ArregloClientes[i].getArregloCuenta()[j] != null){
                        Debitar.addItem(Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador());
                    }
                }
            }
        }
        this.add(Debitar);
        Debitar.setBounds(125,120,300,20);

        TipoDeServicio = new JLabel("Tipo de servicio");
        this.add(TipoDeServicio);
        TipoDeServicio.setBounds(230,200,100,20);

        TipoServicio = new JComboBox();
        TipoServicio.addItem("Luz electrica");// Llenado del Jcombobox con los diferencias servicios.
        TipoServicio.addItem("Agua");
        TipoServicio.addItem("Servicio telefonico");
        this.add(TipoServicio);
        TipoServicio.setBounds(125,220,300,20);

        MontoS = new JLabel("Monto");
        this.add(MontoS);
        MontoS.setBounds(260,280,100,20);

        Monto = new JTextField();
        this.add(Monto);
        Monto.setBounds(125,300,300,20);

        Aceptar = new JButton("Aceptar");
        this.add(Aceptar);
        Aceptar.addActionListener(this);
        Aceptar.setBounds(180,340,200,20);

    }
    @Override
    public void actionPerformed(ActionEvent e) {// Realizar la accion de los pagos de los diferentes servicios.
        if(e.getSource() == Aceptar){

            int identificador = (int) Debitar.getSelectedItem();// Identificador de la cuenta de los clientes.
            double saldo = Double.parseDouble(Monto.getText());// Saldo de la cuenta
            if(saldo > 0){
                for (int i = 0; i <Main.ArregloClientes.length; i++) {// Realiza la accion de los pagos de cada cuenta.
                    if(Main.ArregloClientes[i] != null){
                        for (int j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                            if(Main.ArregloClientes[i].getArregloCuenta()[j] != null){
                                if(Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador() == identificador){
                                    double saldoAnterior = Main.ArregloClientes[i].getArregloCuenta()[j].getSaldo();
                                    if(saldoAnterior >= saldo){
                                        Main.ArregloClientes[i].getArregloCuenta()[j].setSaldo(saldoAnterior - saldo);
                                        JOptionPane.showMessageDialog(this, "Pago realizado exitosamente");
                                        for (int k = 0; k < Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones().length; k++) {// Agrega los resultados a la tabla historial
                                            if(Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][0] == null ){
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][0] = Main.IdTransacciones;
                                                Main.IdTransacciones++;
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][1] = LocalDateTime.now();
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][2] = "Pago de servicio " + TipoServicio.getSelectedItem();
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][3] = saldo;
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][4] = 0.0;
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][5] = Main.ArregloClientes[i].getArregloCuenta()[j].getSaldo();
                                                break;
                                            }

                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(this, "Fondos insuficientes");
                                    }
                                }

                            }

                        }
                    }

                }

            }
            else{
                JOptionPane.showMessageDialog(this, "Monto debe ser mayor a cero");
            }


        }

    }
}
