package entrega.data.data.org.example;

import entrega.data.data.bd.Conexion;
import entrega.data.data.bd.ManagerConexion;
import entrega.data.data.dto.Cliente;
import entrega.data.data.dto.Pedido;
import entrega.data.data.dto.Repartidor;
import entrega.data.data.excepciones.ExcepcionManager;
import entrega.data.data.mgr.*;

public class Main {
    public static void main(String[] args) throws ExcepcionManager {
        Cliente c = new Cliente();
        Repartidor r = new Repartidor();

        c.setNombre("Monteria");
        c.setIdcliente(213131);
        c.setDireccion("Calle 15");
        c.setTelefono("34457757990");

        ImgrCliente mgc = new MgrCliente();
        mgc.Save(c);



        r.setIdrepartidor(2828282);
        r.setNombre("Carlos");
        r.setTelefono("2393938373");
        r.setPlacamoto("TYU-768");

        ImgrRepartidor mgr = new MgrRepartidor();
        mgr.Save(r);

        Pedido p = new Pedido();
        p.setIdpedido(484);
        p.setProducto("Aerosol");
        p.setPrecio("20000");
        p.setCantidad("1");
        p.setIdrepartidor(2828282);
        p.setIdcliente(213131);

        ImgrPedido mgp = new MgrPedido();
        mgp.Save(p);
    }
}