package entrega.data.data.dao;

import entrega.data.data.dto.Cliente;
import entrega.data.data.excepciones.ExcepcionDao;

import java.util.List;

public interface IClienteDao {

    public void insert(Cliente c) throws ExcepcionDao;
    public void update(Cliente c) throws ExcepcionDao;
    public void delete(Cliente c) throws ExcepcionDao;
    public Cliente getById(int idcliente) throws ExcepcionDao;

    public List<Cliente> listado() throws ExcepcionDao;
}
