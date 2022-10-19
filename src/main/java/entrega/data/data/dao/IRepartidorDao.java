package entrega.data.data.dao;

import entrega.data.data.dto.Pedido;
import entrega.data.data.dto.Repartidor;
import entrega.data.data.excepciones.ExcepcionDao;

import java.util.List;

public interface IRepartidorDao {

    public void insert(Repartidor r) throws ExcepcionDao;
    public void update(Repartidor r) throws ExcepcionDao;
    public void delete(Repartidor r) throws ExcepcionDao;
    public Repartidor getById(int idrepartidor) throws ExcepcionDao;
    public List<Repartidor> listado() throws ExcepcionDao;
}
