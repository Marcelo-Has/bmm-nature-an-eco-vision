package view;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameEvent;
import modal.bean.Usuario;
import modal.dao.UsuarioDao;

public class TelaCadUsuarioInicio extends javax.swing.JInternalFrame {

    public static TelaCadUsuarioInicio instancia = null;

    public TelaCadUsuarioInicio() {
        initComponents();
        instancia = this;
        trataFechamento();
    }

    private void trataFechamento() {
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }

            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                instancia = null;
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
            }
        });
    }

    public void centralizaTela() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pInfUsuario = new javax.swing.JPanel();
        lbCadNomeUInicio = new javax.swing.JLabel();
        lbCadLoginUInicio = new javax.swing.JLabel();
        lbCadSenhaUInicio = new javax.swing.JLabel();
        lbCadCodUInicio = new javax.swing.JLabel();
        txtCadNomeUInicio = new javax.swing.JTextField();
        txtCadLoginUInicio = new javax.swing.JTextField();
        txtCadSenhaUInicio = new javax.swing.JPasswordField();
        txtCadCodUInicio = new javax.swing.JTextField();
        btnCadConfirmaInicio = new javax.swing.JButton();
        btnCadCancelaInicio = new javax.swing.JButton();
        lbUpNomeU1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastrar Usuário");

        pInfUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N

        lbCadNomeUInicio.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCadNomeUInicio.setText("Nome:");

        lbCadLoginUInicio.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCadLoginUInicio.setText("Login:");

        lbCadSenhaUInicio.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCadSenhaUInicio.setText("Senha:");

        lbCadCodUInicio.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCadCodUInicio.setText("Código de Usuário:");

        javax.swing.GroupLayout pInfUsuarioLayout = new javax.swing.GroupLayout(pInfUsuario);
        pInfUsuario.setLayout(pInfUsuarioLayout);
        pInfUsuarioLayout.setHorizontalGroup(
            pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInfUsuarioLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pInfUsuarioLayout.createSequentialGroup()
                        .addGroup(pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCadCodUInicio)
                            .addComponent(lbCadSenhaUInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCadCodUInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadSenhaUInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pInfUsuarioLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCadLoginUInicio)
                            .addComponent(lbCadNomeUInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCadLoginUInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadNomeUInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pInfUsuarioLayout.setVerticalGroup(
            pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pInfUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCadNomeUInicio)
                    .addComponent(txtCadNomeUInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCadLoginUInicio)
                    .addComponent(txtCadLoginUInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCadSenhaUInicio)
                    .addComponent(txtCadSenhaUInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pInfUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCadCodUInicio)
                    .addComponent(txtCadCodUInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCadConfirmaInicio.setText("Confirmar");
        btnCadConfirmaInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadConfirmaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaCadastro(evt);
            }
        });

        btnCadCancelaInicio.setText("Cancelar");
        btnCadCancelaInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadCancelaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaCadastro(evt);
            }
        });

        lbUpNomeU1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbUpNomeU1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUpNomeU1.setText("<html><center>Caso não tenha o código de usuário,<br/>coloque \"bmm-comum2019\".</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbUpNomeU1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadConfirmaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(btnCadCancelaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pInfUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(lbUpNomeU1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadConfirmaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadCancelaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pInfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 144, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmaCadastro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaCadastro

        Usuario u = new Usuario();
        UsuarioDao daoU = new UsuarioDao();

        u.setNome(txtCadNomeUInicio.getText());
        u.setLogin(txtCadLoginUInicio.getText());
        u.setSenha(String.valueOf(txtCadSenhaUInicio.getPassword()));
        u.setCodT(txtCadCodUInicio.getText());
        daoU.create(u);

        try {
            setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUpDesmatamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmaCadastro

    private void cancelaCadastro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaCadastro
        try {
            setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaUpDesmatamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelaCadastro


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadCancelaInicio;
    private javax.swing.JButton btnCadConfirmaInicio;
    private javax.swing.JLabel lbCadCodUInicio;
    private javax.swing.JLabel lbCadLoginUInicio;
    private javax.swing.JLabel lbCadNomeUInicio;
    private javax.swing.JLabel lbCadSenhaUInicio;
    private javax.swing.JLabel lbUpNomeU1;
    private javax.swing.JPanel pInfUsuario;
    private javax.swing.JTextField txtCadCodUInicio;
    private javax.swing.JTextField txtCadLoginUInicio;
    private javax.swing.JTextField txtCadNomeUInicio;
    private javax.swing.JPasswordField txtCadSenhaUInicio;
    // End of variables declaration//GEN-END:variables
}