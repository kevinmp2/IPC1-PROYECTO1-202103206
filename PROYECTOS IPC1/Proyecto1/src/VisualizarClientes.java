import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarClientes extends JFrame implements ActionListener {

    public JTextField CUI;
    public JButton Buscar;
    public JLabel CUIL;

    public JComboBox CuentasAsociadas;

    public VisualizarClientes(){
        this.setTitle("Ver Clientes");
        this.setBounds(200,200,600,600);
        this.setLayout(null);

        String[] ArregloTitulos = {"CUI", "Nombre", "Apellido"};
        int x = 0;
        for (int i = 0; i < Main.ArregloClientes.length; i++) {
            if(Main.ArregloClientes[i] != null){
                x++;
            }
        }
        Object[][] ArregloTablas = new Object[x][3];
        for (int i = 0; i < Main.ArregloClientes.length; i++) {
            if(Main.ArregloClientes[i] != null){
                ArregloTablas[i][0] = Main.ArregloClientes[i].getCUI();
                ArregloTablas[i][1] = Main.ArregloClientes[i].getNombre();
                ArregloTablas[i][2] = Main.ArregloClientes[i].getApellido();
            }
        }
        DefaultTableModel dtm = new DefaultTableModel(ArregloTablas, ArregloTitulos);
        final JTable table = new JTable(dtm);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(10,10,500,200);
        this.add(scrollPane);

        CUIL = new JLabel("CUI");
        this.add(CUIL);
        CUIL.setBounds(150,210,100,50);

        CUI = new JTextField();
        this.add(CUI);
        CUI.setBounds(25,250,300,25);

        CuentasAsociadas = new JComboBox();
        this.add(CuentasAsociadas);
        CuentasAsociadas.setBounds(100,450,300,25);

        Buscar = new JButton("Buscar Cuentas Asociadas");
        this.add(Buscar);
        Buscar.addActionListener(this);
        Buscar.setBounds(350,250,200,20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Buscar) {
            CuentasAsociadas.removeAllItems();
        String cui = CUI.getText();
            for (int i = 0; i < Main.ArregloClientes.length; i++) {
                if(Main.ArregloClientes[i] != null && cui .equals(Main.ArregloClientes[i].getCUI())){
                    for (int j = 0; j < Main.ArregloClientes[i].getArregloCuenta().length; j++) {
                        if(Main.ArregloClientes[i].getArregloCuenta()[j] != null){
                            CuentasAsociadas.addItem (String.valueOf(Main.ArregloClientes[i].getArregloCuenta()[j].getIdentificador()));
                        }
                    }
                }
            }

        }
    }
}
