import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;

public class Deposito2 extends JFrame implements ActionListener {

    public JTextField Cuenta;

    public JComboBox CuentaL;
    public JButton Aceptar;

    public JLabel Monto,Cuental;

    public Deposito2(){
        this.setTitle("Depositar a Cuenta");
        this.setBounds(200,200,600,600);
        this.setLayout(null);

        Cuental = new JLabel("Cuenta");
        this.add(Cuental);
        Cuental.setBounds(250,60,100,20);

        CuentaL = new JComboBox();
        for (int i = 0; i <Main.ArregloClientes.length; i++) {
            if(Main.ArregloClientes[i] != null){
                for (int j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                if(Main.ArregloClientes[i].getArregloCuenta()[j] != null){
                    CuentaL.addItem(Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador());
                }
            }

            }

        }
        this.add(CuentaL);
        CuentaL.setBounds(175,80,200,20);

        Monto = new JLabel("Monto");
        this.add(Monto);
        Monto.setBounds(250,150,100,20);

        Cuenta = new JTextField();
        this.add(Cuenta);
        Cuenta.setBounds(125,170,300,25);

        Aceptar = new JButton("Aceptar");
        this.add(Aceptar);
        Aceptar.addActionListener(this);
        Aceptar.setBounds(175,250,200,20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Aceptar){

            int identificador = (int) CuentaL.getSelectedItem();
            double saldo = Double.parseDouble(Cuenta.getText());
            if(saldo > 0){
                for (int i = 0; i <Main.ArregloClientes.length; i++) {
                    if(Main.ArregloClientes[i] != null){
                        for (int j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                            if(Main.ArregloClientes[i].getArregloCuenta()[j] != null){
                                if(Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador() == identificador){
                                    double saldoAnterior = Main.ArregloClientes[i].getArregloCuenta()[j].getSaldo();
                                    Main.ArregloClientes[i].getArregloCuenta()[j].setSaldo(saldo + saldoAnterior);
                                    JOptionPane.showMessageDialog(this, "deposito realizado exitosamente");
                                    for (int k = 0; k < Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones().length; k++) {
                                        if(Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][0] == null ) {
                                            Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][0] = Main.IdTransacciones;
                                            Main.IdTransacciones++;
                                            Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][1] = LocalDateTime.now();
                                            Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][2] = "deposito";
                                            Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][3] = 0.0;
                                            Main.ArregloClientes[i].getArregloCuenta()[j].getTransacciones()[k][4] = saldo;
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
            else{
                JOptionPane.showMessageDialog(this, "Monto debe ser mayor a cero");
            }

        }

    }
}