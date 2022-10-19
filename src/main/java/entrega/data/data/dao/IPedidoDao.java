package entrega.data.data.dao;


import entrega.data.data.dto.Cliente;
import entrega.data.data.dto.Pedido;
import entrega.data.data.excepciones.ExcepcionDao;

import java.util.List;

public interface IPedidoDao {

    public void insert(Pedido p) throws ExcepcionDao;
    public void update(Pedido p) throws ExcepcionDao;
    public void delete(Pedido p) throws ExcepcionDao;
    public Pedido getById(int idpedido) throws ExcepcionDao;
    public List<Pedido> listado() throws ExcepcionDao;

}
