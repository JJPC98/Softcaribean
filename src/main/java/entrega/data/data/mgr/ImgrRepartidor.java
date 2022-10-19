package entrega.data.data.mgr;


import entrega.data.data.dto.Repartidor;
import entrega.data.data.excepciones.ExcepcionManager;

import java.util.List;

public interface ImgrRepartidor {
    public void Save(Repartidor repartidor) throws ExcepcionManager;
    public void Delete(Repartidor repartidor) throws ExcepcionManager;
    public List<Repartidor> listado() throws ExcepcionManager;
}
