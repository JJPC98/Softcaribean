package entrega.data.data.mgr;

import entrega.data.data.bd.ManagerConexion;
import entrega.data.data.dao.PedidoDaoImplement;
import entrega.data.data.dao.IPedidoDao;
import entrega.data.data.dto.Cliente;
import entrega.data.data.dto.Pedido;
import entrega.data.data.excepciones.ExcepcionDao;
import entrega.data.data.excepciones.ExcepcionManager;

import java.util.List;

public class MgrPedido implements ImgrPedido{

    IPedidoDao p = new PedidoDaoImplement();

    @Override
    public void Save(Pedido pedido) throws ExcepcionManager {
        ManagerConexion managerConexion = ManagerConexion.getInstance();
        managerConexion.reconectar();

        try{
            Pedido pe = p.getById(pedido.getIdpedido());
            if(pe == null) {
                p.insert(pedido);
            }else {
                System.out.println("El pedido ya existe");
            }
            managerConexion.commit();
        }catch (Exception e){
            managerConexion.rollback();
        }finally {
            managerConexion.close();
        }

    }

    @Override
    public void Delete(Pedido pedido) throws ExcepcionManager {
        ManagerConexion managerConexion = ManagerConexion.getInstance();
        try {
            Pedido pe = p.getById(pedido.getIdpedido());
            if (pe == null) {
                System.out.println("El pedido no existe");
            } else {
                p.delete(pedido);
            }
            managerConexion.commit();
        }catch (Exception e){
            managerConexion.rollback();
        }finally {

            managerConexion.close();
        }
    }

    @Override
    public List<Pedido> listado() throws ExcepcionManager {

        ManagerConexion managerConexion = ManagerConexion.getInstance();
        managerConexion.reconectar();

        try {
            return  p.listado();
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
