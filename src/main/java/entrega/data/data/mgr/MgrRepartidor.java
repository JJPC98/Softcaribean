package entrega.data.data.mgr;


import entrega.data.data.bd.ManagerConexion;
import entrega.data.data.dao.IRepartidorDao;
import entrega.data.data.dao.RepartidorDaoImplement;
import entrega.data.data.dto.Repartidor;
import entrega.data.data.excepciones.ExcepcionDao;
import entrega.data.data.excepciones.ExcepcionManager;

import java.util.List;

public class MgrRepartidor implements ImgrRepartidor{

    IRepartidorDao r = new RepartidorDaoImplement();

    @Override
    public void Save(Repartidor repartidor) throws ExcepcionManager {
        ManagerConexion managerConexion = ManagerConexion.getInstance();
        managerConexion.reconectar();

        try{
            Repartidor re = r.getById(repartidor.getIdrepartidor());
            if(re == null) {
                r.insert(repartidor);
            }else {
                System.out.println("El repartidor ya existe");
            }
            managerConexion.commit();
        }catch (Exception e){
            managerConexion.rollback();
        }finally {
            managerConexion.close();
        }

    }

    @Override
    public void Delete(Repartidor repartidor) throws ExcepcionManager {
        ManagerConexion managerConexion = ManagerConexion.getInstance();
        try {
            Repartidor re = r.getById(repartidor.getIdrepartidor());
            if (re == null) {
                System.out.println("El repartidor no existe");
            } else {
                r.delete(repartidor);
            }
            managerConexion.commit();
        }catch (Exception e){
            managerConexion.rollback();
        }finally {

            managerConexion.close();
        }
    }

    @Override
    public List<Repartidor> listado() throws ExcepcionManager {

        ManagerConexion managerConexion = ManagerConexion.getInstance();
        managerConexion.reconectar();

        try {
            return  r.listado();
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

