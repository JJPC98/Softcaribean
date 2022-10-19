package entrega.data.data.dao;

import entrega.data.data.dto.Cliente;
import entrega.data.data.dto.Pedido;
import entrega.data.data.bd.ManagerConexion;
import entrega.data.data.excepciones.ExcepcionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDaoImplement implements IPedidoDao{



    @Override
    public void insert(Pedido p) throws ExcepcionDao {
        ManagerConexion con = ManagerConexion.getInstance();
        String insert = "insert into pedidos(idpedidos, producto, cantidad, precio, idcliente, idrepartidor) values(?,?,?,?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(insert);
            pstm.setInt(1, p.getIdpedido());;
            pstm.setString(2, p.getProducto());
            pstm.setString(3, p.getCantidad());
            pstm.setString(4, p.getPrecio());
            pstm.setInt(5, p.getIdcliente());
            pstm.setInt(6, p.getIdrepartidor());
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
    public void update(Pedido p) throws ExcepcionDao {
        ManagerConexion con = ManagerConexion.getInstance();
        String UPDATE = "update pedidos set producto, cantidad, precio = ? where idpedidos = ?";

        PreparedStatement pstm = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(UPDATE);
            pstm.setInt(4, p.getIdpedido());
            pstm.setString(3, p.getPrecio());
            pstm.setString(2, p.getCantidad());
            pstm.setString(1, p.getProducto());
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
    public void delete(Pedido p) throws ExcepcionDao {
        ManagerConexion con = ManagerConexion.getInstance();
        String DELETE = "delete from pedidos where idpedidos = ?";

        PreparedStatement pstm = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(DELETE);
            pstm.setInt(1,p.getIdpedido());
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
    public Pedido getById(int idpedido) throws ExcepcionDao {
        ManagerConexion con = ManagerConexion.getInstance();
        String SELECT = "select idpedidos, producto, cantidad, precio, idcliente, idrepartidor from pedidos where idpedidos = ?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Pedido pe = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(SELECT);
            pstm.setInt(1, idpedido);
            rs = pstm.executeQuery();
            while (rs.next()) {
                pe = new Pedido();
                pe.setIdpedido(rs.getInt("idpedidos"));
                pe.setProducto(rs.getString("producto"));
                pe.setCantidad(rs.getString("cantidad"));
                pe.setPrecio(rs.getString("precio"));
                pe.setIdcliente(rs.getInt("idcliente"));
                pe.setIdrepartidor(rs.getInt("idrepartidor"));
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

        return pe;

    }


    @Override
    public List<Pedido> listado() throws ExcepcionDao {

        ManagerConexion con = ManagerConexion.getInstance();

        String SELECTBYID = "select * from pedidos ";
        List<Pedido> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Pedido pe = null;
        try {
            pstm = con.getConexion().getConection().prepareStatement(SELECTBYID);
            rs = pstm.executeQuery();

            while (rs.next()) {
                pe = new Pedido();
                pe.setIdpedido(rs.getInt("idpedidos"));
                pe.setProducto(rs.getString("producto"));
                pe.setCantidad(rs.getString("cantidad"));
                pe.setPrecio(rs.getString("precio"));
                pe.setIdcliente(rs.getInt("idcliente"));
                pe.setIdrepartidor(rs.getInt("idrepartidor"));
                lista.add(pe);
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
