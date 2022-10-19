package entrega.data.data.dao;

import entrega.data.data.dto.Moto;
import entrega.data.data.excepciones.ExcepcionDao;

import java.util.List;

public interface IMotoDao {
    public void insert(Moto m) throws ExcepcionDao;
    public void update(Moto m) throws ExcepcionDao;
    public void delete(Moto m) throws ExcepcionDao;
    public Moto getById(int idrepartidor) throws ExcepcionDao;
    public List<Moto> listado() throws ExcepcionDao;
}
