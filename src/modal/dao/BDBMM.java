package modal.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class BDBMM {
    
    public void addItem(String busca, String coluna1, String coluna2, JComboBox caixa) {

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement(busca);
            rs = stmt.executeQuery();

            while (rs.next()) {

                caixa.addItem(rs.getString(coluna1) + " - " + rs.getString(coluna2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
    }
    
    public void addItem(String busca, String coluna, JComboBox caixa) {

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement(busca);
            rs = stmt.executeQuery();

            while (rs.next()) {

                caixa.addItem(rs.getString(coluna));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
    }
    
    public void addItem(String busca, String coluna, JComboBox caixa, int id) {

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement(busca);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                caixa.addItem(rs.getString(coluna));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
    }
    
    public void addItem(String busca, String coluna1, String coluna2, JComboBox caixa, int id) {

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement(busca);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                caixa.addItem(rs.getString(coluna1) + " - " + rs.getString(coluna2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
    }
}
