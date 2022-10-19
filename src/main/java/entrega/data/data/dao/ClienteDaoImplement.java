package entrega.data.data.dao;

import entrega.data.data.bd.ManagerConexion;
import entrega.data.data.dto.Cliente;
import entrega.data.data.excepciones.ExcepcionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImplement implements IClienteDao{



    @Override
    public void insert(Cliente c) throws ExcepcionDao {
        ManagerConexion con = ManagerConexion.getInstance();
        String insert = "insert into clientes(idclientes, nombre, direccion, telefono) values(?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(insert);
            pstm.setInt(1,c.getIdcliente());
            pstm.setString(2,c.getNombre());
            pstm.setString(3,c.getDireccion());
            pstm.setString(4,c.getTelefono());
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
    public void update(Cliente c) throws ExcepcionDao{
        ManagerConexion con = ManagerConexion.getInstance();
        String UPDATE = "update clientes set nombre, direccion, telefono = ? where idclientes = ?";

        PreparedStatement pstm = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(UPDATE);
            pstm.setInt(4,c.getIdcliente());
            pstm.setString(3, c.getTelefono());
            pstm.setString(2, c.getDireccion());
            pstm.setString(1, c.getNombre());
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
    public void delete(Cliente c) throws ExcepcionDao{
        ManagerConexion con = ManagerConexion.getInstance();
        String DELETE = "delete from clientes where idclientes = ?";

        PreparedStatement pstm = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(DELETE);
            pstm.setInt(1,c.getIdcliente());
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
    public Cliente getById(int idcliente) throws ExcepcionDao{
        ManagerConexion con = ManagerConexion.getInstance();
        String SELECT = "select idclientes, nombre, direccion, telefono from clientes where idclientes = ?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Cliente cl = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(SELECT);
            pstm.setInt(1, idcliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cl = new Cliente();
                cl.setIdcliente(rs.getInt("idclientes"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setTelefono(rs.getString("telefono"));
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

        return cl;
    }

    @Override
    public List<Cliente> listado() throws ExcepcionDao {

        ManagerConexion con = ManagerConexion.getInstance();

        String SELECTBYID = "select * from clientes ";
        List<Cliente> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente cl = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(SELECTBYID);
            rs = pstm.executeQuery();

            while (rs.next()) {
                cl = new Cliente();
                cl.setIdcliente(rs.getInt("idclientes"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setTelefono(rs.getString("telefono"));

                lista.add(cl);
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

