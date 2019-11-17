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
import modal.bean.Usuario;

public class UsuarioDao {
    
    private final ImageIcon icone = new ImageIcon("images//logo-bmm.png");
    
    public boolean verificaLogin(String login, String senha) {
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean verifica = false;
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE login_user = ? AND senha_user = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                verifica = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
        
        return verifica;
    }
    
    public String verificaUsuario(String login, String senha) {
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String acesso = "";
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM tipo_usuario INNER JOIN usuario ON (tipo_usuario.cod_t_user = usuario.cod_t_user) WHERE usuario.login_user = ? AND usuario.senha_user = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                acesso = rs.getString("nome_t_user");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
        
        return acesso;
    }
    
    public String verificaUsuario(String login) {
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String usuario = "";
        
        try {
            stmt = conexao.prepareStatement("SELECT nome_user FROM usuario WHERE login_user = ?;");
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                usuario = rs.getString("nome_user");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
        
        return usuario;
    }
    
    public void create(Usuario u) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario (nome_user, login_user, senha_user, ultima_modificacao, cod_t_user) VALUES(?, ?, ?, curdate(), ?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCodT());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE, icone);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + e, "Erro", JOptionPane.INFORMATION_MESSAGE, icone);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Usuario> read() {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT u.id_user, u.nome_user, u.login_user, u.senha_user, tu.cod_t_user, tu.nome_t_user, DATE_FORMAT(ultima_modificacao, '%d/%m/%Y') as data FROM usuario AS u INNER JOIN tipo_usuario AS tu ON (u.cod_t_user = tu.cod_t_user)");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("u.id_user"));
                usuario.setNome(rs.getString("u.nome_user"));
                usuario.setLogin(rs.getString("u.login_user"));
                usuario.setSenha(rs.getString("u.senha_user"));
                usuario.setUltimaModificacao(rs.getString("data"));
                usuario.setCodT(rs.getString("tu.cod_t_user"));
                usuario.setNomeT(rs.getString("tu.nome_t_user"));
                usuarios.add(usuario);
                
            }
            
            Collections.sort(usuarios);
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return usuarios;
    }
    
    public void update(Usuario u) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuario SET nome_user = ?, login_user = ?, senha_user = ?, ultima_modificacao = curdate(), cod_t_user = ? WHERE id_user = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCodT());
            stmt.setInt(5, u.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Atualização", JOptionPane.INFORMATION_MESSAGE, icone);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + e, "Erro", JOptionPane.INFORMATION_MESSAGE, icone);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void delete(Usuario u) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id_user = ?");
            stmt.setInt(1, u.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Item excluído com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE, icone);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + e, "Erro", JOptionPane.INFORMATION_MESSAGE, icone);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
}
