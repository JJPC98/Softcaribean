package entrega.data.data.dao;

import entrega.data.data.bd.ManagerConexion;
import entrega.data.data.dto.Pedido;
import entrega.data.data.dto.Repartidor;
import entrega.data.data.excepciones.ExcepcionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDaoImplement implements IRepartidorDao  {



    @Override
    public void insert(Repartidor r) throws ExcepcionDao {
        ManagerConexion con = ManagerConexion.getInstance();
        String insert = "insert into repartidor(idrepartidor, nombre, telefono, placamoto) values(?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(insert);
            pstm.setInt(1, r.getIdrepartidor());
            pstm.setString(2, r.getNombre());
            pstm.setString(3, r.getTelefono());
            pstm.setString(4, r.getPlacamoto());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void update(Repartidor r) throws ExcepcionDao {
        ManagerConexion con = ManagerConexion.getInstance();
        String UPDATE = "update repartidor set nombre, telefono, placamoto = ? where idrepartidor = ?";

        PreparedStatement pstm = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(UPDATE);
            pstm.setInt(4, r.getIdrepartidor());
            pstm.setString(3, r.getPlacamoto());
            pstm.setString(2, r.getTelefono());
            pstm.setString(1, r.getNombre());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(Repartidor r) throws ExcepcionDao {
        ManagerConexion con = ManagerConexion.getInstance();
        String DELETE = "delete from repartidor where idrepartidor = ?";

        PreparedStatement pstm = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(DELETE);
            pstm.setInt(1,r.getIdrepartidor());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Repartidor getById(int idrepartidor) throws ExcepcionDao {
        ManagerConexion con = ManagerConexion.getInstance();
        String SELECT = "select idrepartidor, nombre, telefono, placamoto from repartidor where idrepartidor = ?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Repartidor re = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(SELECT);
            pstm.setInt(1, idrepartidor);
            rs = pstm.executeQuery();
            while (rs.next()) {
                re = new Repartidor();
                re.setIdrepartidor(rs.getInt("idrepartidor"));
                re.setNombre(rs.getString("nombre"));
                re.setTelefono(rs.getString("telefono"));
                re.setPlacamoto(rs.getString("placamoto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return re;

    }

    @Override
    public List<Repartidor> listado() throws ExcepcionDao {

        ManagerConexion con = ManagerConexion.getInstance();

        String SELECTBYID = "select * from pedidos ";
        List<Repartidor> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Repartidor re = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(SELECTBYID);
            rs = pstm.executeQuery();

            while (rs.next()) {
                re = new Repartidor();
                re.setIdrepartidor(rs.getInt("idrepartidor"));
                re.setNombre(rs.getString("nombre"));
                re.setTelefono(rs.getString("telefono"));
                re.setPlacamoto(rs.getString("placamoto"));
                lista.add(re);
            }
        } catch (SQLException e) {
            throw new ExcepcionDao(e);
        }finally {
            try {
                rs.close();
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}
