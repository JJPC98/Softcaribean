package entrega.data.data.mgr;

import entrega.data.data.dto.Cliente;
import entrega.data.data.dto.Pedido;
import entrega.data.data.excepciones.ExcepcionManager;

import java.util.List;

public interface ImgrPedido {

    public void Save(Pedido pedido) throws ExcepcionManager;
    public void Delete(Pedido pedido) throws ExcepcionManager;
    public List<Pedido> listado() throws ExcepcionManager;
}
