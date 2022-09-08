import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menuprincipal extends JFrame implements ActionListener {
     public JButton RegistrarCliente,CrearCuenta,VisualizarInformacion,Deposito,Transferencia,Pagos,Historial;
     public Menuprincipal(){
         this.setTitle("Menu principal");
         this.setBounds(200,200,600,600);
         this.setLayout(null);

         RegistrarCliente = new JButton("Registrar Cliente");
         this.add(RegistrarCliente);
         RegistrarCliente.setBounds(180,100,200,30);
         RegistrarCliente.addActionListener(this);

         CrearCuenta = new JButton("Crear Cuenta");
         this.add(CrearCuenta);
         CrearCuenta.setBounds(180,150,200,30);
         CrearCuenta.addActionListener(this);

         VisualizarInformacion = new JButton("Visualizar Informacion De Clientes");
         this.add(VisualizarInformacion);
         VisualizarInformacion.setBounds(140,200,300,30);
         VisualizarInformacion.addActionListener(this);

         Deposito = new JButton("Deposito Monetario");
         this.add(Deposito);
         Deposito.setBounds(180,250,200,30);
         Deposito.addActionListener(this);

         Transferencia = new JButton("Realizar Transferencia");
         this.add(Transferencia);
         Transferencia.setBounds(180,300,200,30);
         Transferencia.addActionListener(this);

         Pagos = new JButton("Pago De Servicios");
         this.add(Pagos);
         Pagos.setBounds(180,350,200,30);
         Pagos.addActionListener(this);

         Historial = new JButton("Historial De Transacciones");
         this.add(Historial);
         Historial.setBounds(140,400,300,30);
         Historial.addActionListener(this);





     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==RegistrarCliente){
        RegistrarCliente CrearCliente = new RegistrarCliente();
        CrearCliente.setVisible(true);
        }
        if(e.getSource()==CrearCuenta){
            RegistrarCuenta Cuenta = new RegistrarCuenta();
            Cuenta.setVisible(true);
        }
        if(e.getSource() == VisualizarInformacion){
            VisualizarClientes visualizar = new VisualizarClientes();
             visualizar.setVisible(true);
        }
        if(e.getSource() == Deposito){
            Deposito2 DepositoUno = new Deposito2();
            DepositoUno.setVisible(true);
        }
        if(e.getSource() == Transferencia){
            Transferencia2 TransferenciaDos = new Transferencia2();
            TransferenciaDos.setVisible(true);
        }
        if(e.getSource() == Pagos){
            Servicios servicios = new Servicios();
            servicios.setVisible(true);
        }
        if(e.getSource() == Historial){
            Historial2 historial = new Historial2();
            historial.setVisible(true);
        }
    }
}
