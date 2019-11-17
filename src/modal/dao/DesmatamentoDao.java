package modal.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modal.bean.ConsultaDes;
import modal.bean.Desmatamento;

public class DesmatamentoDao {
    
    private final ImageIcon icone = new ImageIcon("images//logo-bmm.png");

    public void create(Desmatamento des) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO desmatamento (bioma_des, ano_des, sigla_estado, area_desmatada, ultima_modificacao, user_des) VALUES(?, ?, ?, ?, curdate(), ?)");
            stmt.setString(1, des.getBioma());
            stmt.setInt(2, des.getAno());
            stmt.setString(3, des.getEstado());
            stmt.setFloat(4, des.getAreaDesmatada());
            stmt.setString(5, des.getUsuario());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE, icone);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + e, "Erro", JOptionPane.INFORMATION_MESSAGE, icone);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Desmatamento> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Desmatamento> desmatamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT *, DATE_FORMAT(ultima_modificacao, '%d/%m/%Y') AS data FROM desmatamento");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Desmatamento desmatamento = new Desmatamento();

                desmatamento.setId(rs.getInt("id_des"));
                desmatamento.setBioma(rs.getString("bioma_des"));
                desmatamento.setAno(rs.getInt("ano_des"));
                desmatamento.setEstado(rs.getString("sigla_estado"));
                desmatamento.setAreaDesmatada(rs.getInt("area_desmatada"));
                desmatamento.setUltimaModificacao(rs.getString("data"));
                desmatamento.setUsuario(rs.getString("user_des"));
                desmatamentos.add(desmatamento);

            }
            
            Collections.sort(desmatamentos);

        } catch (SQLException ex) {
            Logger.getLogger(DesmatamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return desmatamentos;
    }

    public void update(Desmatamento des) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE desmatamento SET bioma_des = ?, ano_des = ?, sigla_estado = ?, area_desmatada = ?, user_des = ?, ultima_modificacao = curdate() WHERE id_des = ?");
            stmt.setString(1, des.getBioma());
            stmt.setInt(2, des.getAno());
            stmt.setString(3, des.getEstado());
            stmt.setFloat(4, des.getAreaDesmatada());
            stmt.setString(5, des.getUsuario());
            stmt.setInt(6, des.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Atualização", JOptionPane.INFORMATION_MESSAGE, icone);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + e, "Erro", JOptionPane.INFORMATION_MESSAGE, icone);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Desmatamento des) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM desmatamento WHERE id_des = ?");
            stmt.setInt(1, des.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Item excluído com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE, icone);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + e, "Erro", JOptionPane.INFORMATION_MESSAGE, icone);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public boolean verificaEstadoBioma(String bioma, String estado){
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean retorno = false;
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM bioma WHERE nome_bioma = ? AND sigla_estado = ?;");
            stmt.setString(1, bioma);
            stmt.setString(2, estado);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                retorno = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
        
        return retorno;
    }

    public List<ConsultaDes> consultaDes(String estado, String bioma, String de, String ate) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ConsultaDes> desmatamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT SUM(area_desmatada) area, ano_des FROM desmatamento WHERE sigla_estado = ? AND bioma_des = ? AND ano_des BETWEEN ? AND ? GROUP BY ano_des;");
            stmt.setString(1, estado);
            stmt.setString(2, bioma);
            stmt.setString(3, de);
            stmt.setString(4, ate);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ConsultaDes desmatamento = new ConsultaDes();

                desmatamento.setArea(rs.getInt("area"));
                desmatamento.setAno(rs.getInt("ano_des"));
                desmatamentos.add(desmatamento);

            }
            
            

        } catch (SQLException ex) {
            Logger.getLogger(DesmatamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return desmatamentos;
    }
    
    public List<ConsultaDes> consultaDes(String bioma, String de, String ate) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ConsultaDes> desmatamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT SUM(area_desmatada) area, ano_des FROM desmatamento WHERE bioma_des = ? AND ano_des BETWEEN ? AND ? GROUP BY ano_des;");
            stmt.setString(1, bioma);
            stmt.setString(2, de);
            stmt.setString(3, ate);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ConsultaDes desmatamento = new ConsultaDes();

                desmatamento.setArea(rs.getInt("area"));
                desmatamento.setAno(rs.getInt("ano_des"));
                desmatamentos.add(desmatamento);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DesmatamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return desmatamentos;
    }
}
