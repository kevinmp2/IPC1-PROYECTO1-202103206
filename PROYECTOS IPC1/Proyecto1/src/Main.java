public class Main {

    public static Cliente[] ArregloClientes = new Cliente[5];// Arreglo global para los clientes.
    public static int ID = 1;// Inializacion del ID de cada cliente.

    public static int IdTransacciones = 1;// Inializacion de las transacciones.

public static void main(String[] args){//  Ejecutara la interfaz Menuprincipal.
    Menuprincipal MenuP = new Menuprincipal();
    MenuP.setVisible(true);
    }

}
