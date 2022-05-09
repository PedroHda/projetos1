/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import com.mysql.jdbc.Connection;

/**
 *
 * @author Pedro
 */
public class mainTela extends javax.swing.JFrame {
    private Banco b;
    private Connection con;
    /**
     * Creates new form mainTela
     */
    public mainTela() {
        initComponents();
        b = new Banco();
        con = b.getConnection();
        
        // The net beans wasn't allowing change the initComponents(), so I did that
        initAgain();
    }

    private void initAgain()
    {
        this.setExtendedState(this.MAXIMIZED_BOTH);
        //setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuUser = new javax.swing.JMenu();
        itemCadastrarUser = new javax.swing.JMenuItem();
        itemBuscar = new javax.swing.JMenuItem();
        menuPaciente = new javax.swing.JMenu();
        itemCadastrarPaciente = new javax.swing.JMenuItem();
        itemBuscarPaciente = new javax.swing.JMenuItem();
        menuAgenda = new javax.swing.JMenu();
        menuTimeline = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Software de Agendamento");
        setResizable(false);

        menuUser.setLabel("Usuario");

        itemCadastrarUser.setLabel("Cadastrar");
        itemCadastrarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarUserActionPerformed(evt);
            }
        });
        menuUser.add(itemCadastrarUser);

        itemBuscar.setLabel("Buscar");
        itemBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarActionPerformed(evt);
            }
        });
        menuUser.add(itemBuscar);

        jMenuBar1.add(menuUser);

        menuPaciente.setLabel("Paciente");

        itemCadastrarPaciente.setText("Cadastrar");
        itemCadastrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarPacienteActionPerformed(evt);
            }
        });
        menuPaciente.add(itemCadastrarPaciente);

        itemBuscarPaciente.setText("Buscar");
        itemBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarPacienteActionPerformed(evt);
            }
        });
        menuPaciente.add(itemBuscarPaciente);

        jMenuBar1.add(menuPaciente);

        menuAgenda.setLabel("Agendamento");
        jMenuBar1.add(menuAgenda);

        menuTimeline.setLabel("Timeline");
        jMenuBar1.add(menuTimeline);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCadastrarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarUserActionPerformed
        TelaUsuario telaUser = new TelaUsuario();
        this.getContentPane().add(telaUser);
        telaUser.setVisible(true);
    }//GEN-LAST:event_itemCadastrarUserActionPerformed

    private void itemBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarActionPerformed
        BuscaUsuario telaUserBusca = new BuscaUsuario();
        this.getContentPane().add(telaUserBusca);
        telaUserBusca.setVisible(true);
    }//GEN-LAST:event_itemBuscarActionPerformed

    private void itemCadastrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarPacienteActionPerformed
        TelaCadastrarPaciente cadastrarPaciente = new TelaCadastrarPaciente();
        this.getContentPane().add(cadastrarPaciente);
        cadastrarPaciente.setVisible(true);
    }//GEN-LAST:event_itemCadastrarPacienteActionPerformed

    private void itemBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemBuscarPacienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemBuscar;
    private javax.swing.JMenuItem itemBuscarPaciente;
    private javax.swing.JMenuItem itemCadastrarPaciente;
    private javax.swing.JMenuItem itemCadastrarUser;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAgenda;
    private javax.swing.JMenu menuPaciente;
    private javax.swing.JMenu menuTimeline;
    private javax.swing.JMenu menuUser;
    // End of variables declaration//GEN-END:variables
}
