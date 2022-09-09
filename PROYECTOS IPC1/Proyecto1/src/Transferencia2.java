import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
public class Transferencia2 extends JFrame implements ActionListener {// Interfaz Transderencia2
    public JLabel CuentaOrigenL, CuentaDestinoL,MontoL;
    public JComboBox CuentaOrigen, CuentaDestino;

    public JTextField Monto;

    public JButton Aceptar;
    public Transferencia2(){// Construcctor Transfernecia2
        this.setTitle("Transferencia entre cuentas");
        this.setBounds(200,200,600,600);
        this.setLayout(null);

        CuentaOrigenL = new JLabel("Cuenta Origen");
        this.add(CuentaOrigenL);
        CuentaOrigenL.setBounds(230,100,100,20);

        CuentaOrigen = new JComboBox();// llenado del Jcombobox con las diferentes cuentas de los clientes.
        for (int i = 0; i <Main.ArregloClientes.length; i++) {
            if(Main.ArregloClientes[i] != null){
                for (int j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                    if(Main.ArregloClientes[i].getArregloCuenta()[j] != null){
                        CuentaOrigen.addItem(Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador());
                    }
                }

            }

        }
        this.add(CuentaOrigen);
        CuentaOrigen.setBounds(125,120,300,20);

        CuentaDestinoL = new JLabel("Cuenta Destino");
        this.add(CuentaDestinoL);
        CuentaDestinoL.setBounds(230,210,100,20);

        CuentaDestino = new JComboBox<>();

        for (int i = 0; i <Main.ArregloClientes.length; i++) {// Llenado del Jcombobox con las diferentes cuentas de los diferentes clientes.
            if(Main.ArregloClientes[i] != null){
                for (int j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                    if(Main.ArregloClientes[i].getArregloCuenta()[j] != null){
                        CuentaDestino.addItem(Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador());
                    }
                }

            }

        }
        this.add(CuentaDestino);
        CuentaDestino.setBounds(125,230,300,20);

        MontoL = new JLabel("Monto");
        this.add(MontoL);
        MontoL.setBounds(250,320,100,20);

        Monto = new JTextField();
        this.add(Monto);
        Monto.setBounds(125,340,300,25);

        Aceptar = new JButton("Aceptar");
        this.add(Aceptar);
        Aceptar.addActionListener(this);
        Aceptar.setBounds(175,390,200,20);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Aceptar){// Realiza la accion de las traferencias.
            int origen= (int) CuentaOrigen.getSelectedItem();
            int destino = (int) CuentaDestino.getSelectedItem();

            boolean estado = false;

            double monto = Double.parseDouble(Monto.getText());
            if(monto > 0){// verifica que el saldo sea mayor a cero.
                for (int i = 0; i <Main.ArregloClientes.length; i++) {
                    if(Main.ArregloClientes[i] != null){
                        for (int j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                            if(Main.ArregloClientes[i].getArregloCuenta()[j] != null){

                                if(Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador() == origen){
                                    double saldoAnterior = Main.ArregloClientes[i].getArregloCuenta()[j].getSaldo();
                                    if(monto <= saldoAnterior ){
                                        Main.ArregloClientes[i].getArregloCuenta()[j].setSaldo(saldoAnterior - monto);// Realiza la transferencia de una cuenta a otra.
                                        estado = true;
                                        for (int k = 0; k < Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones().length; k++) {// Añade los datos o acciones realizadas al historial.
                                            if(Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][0] == null ){
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][0] = Main.IdTransacciones;
                                                Main.IdTransacciones++;
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][1] = LocalDateTime.now();
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][2] = "Transferencia";
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][3] = monto;
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
                if(estado == true){
                    for (int i = 0; i <Main.ArregloClientes.length; i++) {// Verifica la transaccion de la cuenta destino.
                        if(Main.ArregloClientes[i] != null){
                            for (int  j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                                if(Main.ArregloClientes[i].getArregloCuenta()[j] != null){
                                    if(Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador() == destino){
                                        double saldoAnterior = Main.ArregloClientes[i].getArregloCuenta()[j].getSaldo();
                                        Main.ArregloClientes[i].getArregloCuenta()[j].setSaldo(monto + saldoAnterior);
                                        JOptionPane.showMessageDialog(this, "Transferencia realizado exitosamente");
                                        for (int k = 0; k < Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones().length; k++) {// Añade los datos al historial
                                            if(Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][0] == null ){
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][0] = Main.IdTransacciones;
                                                Main.IdTransacciones++;
                                                LocalDateTime datetime = LocalDateTime.now();
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][1] = datetime;
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][2] = "Transferencia";
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][3] = 0.0;
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][4] = monto;
                                                Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][5] = Main.ArregloClientes[i].getArregloCuenta()[j].getSaldo();
                                                break;
                                            }

                                        }
                                    }
                                }

                            }
                        }

                    }
                }



            }

        }

    }
}
