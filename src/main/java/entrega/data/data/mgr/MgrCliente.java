package entrega.data.data.mgr;

import entrega.data.data.bd.ManagerConexion;
import entrega.data.data.dao.ClienteDaoImplement;
import entrega.data.data.dao.IClienteDao;
import entrega.data.data.dto.Cliente;
import entrega.data.data.excepciones.ExcepcionDao;
import entrega.data.data.excepciones.ExcepcionManager;

import java.util.List;

public class MgrCliente implements ImgrCliente{

    IClienteDao c = new ClienteDaoImplement();

    @Override
    public void Save(Cliente cliente) throws ExcepcionManager {

        ManagerConexion managerConexion = ManagerConexion.getInstance();
        managerConexion.reconectar();

        try{
            Cliente cl = c.getById(cliente.getIdcliente());
            if(cl == null) {
                c.insert(cliente);
            }else {
                System.out.println("El cliente ya existe");
            }
            managerConexion.commit();
        }catch (Exception e){
            managerConexion.rollback();
        }finally {
            managerConexion.close();
        }

    }

    @Override
    public void Delete(Cliente cliente) throws ExcepcionManager {

        ManagerConexion managerConexion = ManagerConexion.getInstance();
        managerConexion.reconectar();

        try {
            Cliente cl = c.getById(cliente.getIdcliente());
            if (cl == null) {
                System.out.println("El cliente no existe");
            } else {
                c.delete(cliente);
            }
            managerConexion.commit();
        }catch (Exception e){
            managerConexion.rollback();
        }finally {

            managerConexion.close();
        }

    }

    @Override
    public List<Cliente> listado() throws ExcepcionManager {

        ManagerConexion managerConexion = ManagerConexion.getInstance();
        managerConexion.reconectar();

        try {
            return  c.listado();
        } catch (ExcepcionDao e) {
            managerConexion.commit();
            throw new ExcepcionManager(e);
        }catch (Exception e){
            managerConexion.rollback();
            throw new ExcepcionManager(e);
        }finally {
            managerConexion.close();
        }

    }
}
