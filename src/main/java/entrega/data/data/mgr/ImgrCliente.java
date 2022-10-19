package entrega.data.data.mgr;

import entrega.data.data.dto.Cliente;
import entrega.data.data.excepciones.ExcepcionManager;

import java.util.List;

public interface ImgrCliente {

    public void Save(Cliente cliente) throws ExcepcionManager;;
    public void Delete(Cliente cliente) throws ExcepcionManager;;
    public List<Cliente> listado() throws ExcepcionManager;
}
