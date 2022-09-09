import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarCliente extends JFrame implements ActionListener {// Interfaz para la ventana de el registro de clientes.
    public JTextField CUI, Nombre, Apellido;
    public JButton Crear;
     public JLabel CUIL,NombreL,ApellidoL;

    public RegistrarCliente() {// Constructor RegistrarClientes
        this.setTitle("Crear Cliente");
        this.setBounds(200, 200, 500, 500);
        this.setLayout(null);

        CUIL = new JLabel("CUI");
        this.add(CUIL);
        CUIL.setBounds(260,80 , 200, 20);

        CUI = new JTextField();
        this.add(CUI);
        CUI.setBounds(180, 100, 200, 30);

        NombreL = new JLabel("Nombre");
        this.add(NombreL);
        NombreL.setBounds(250,125,200,30);

        Nombre = new JTextField();
        this.add(Nombre);
        Nombre.setBounds(180, 150, 200, 30);

        ApellidoL = new JLabel("Apellido");
        this.add(ApellidoL);
        ApellidoL.setBounds(250,175,200,30);

        Apellido = new JTextField();
        this.add(Apellido);
        Apellido.setBounds(180, 200, 200, 30);

        Crear = new JButton("Crear");
        this.add(Crear);
        Crear.addActionListener(this);
        Crear.setBounds(200, 300, 150, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {// Acciones que realizara la interfaz RegistrarCliente.
        if (e.getSource() == Crear) {
            String cui = CUI.getText();
            String nombre = Nombre.getText();
            String apellido = Apellido.getText();
            Boolean Existe = VerificarClinete(cui);
            if(Existe == true){// Verificara si los CUIS son repetidos
                JOptionPane.showMessageDialog(this, "Error CUI repetido");
            }else if(Existe == false){// Registrar a los clientes.
                if(Main.ArregloClientes[4]== null){
                    Cliente cliente = new Cliente(cui,nombre,apellido);
                    for (int i = 0; i < 5; i++) {// Creara los clientes.
                        if(Main.ArregloClientes[i] == null){
                            Main.ArregloClientes[i] = cliente;
                            JOptionPane.showMessageDialog(this, "Cliente creado exitosamente");
                            break;

                        }
                    }

                }
                else{
                    JOptionPane.showMessageDialog(this, "No es posible crear mas clientes");
                }


            }
        }
    }
    public Boolean VerificarClinete(String cui){// Verificara los clientes.
        for (int i = 0; i < 5; i++) {
            if(Main.ArregloClientes[i] != null && Main.ArregloClientes[i].getCUI().equals(cui)){
                return true;
            }
        }
        return false;
    }
}