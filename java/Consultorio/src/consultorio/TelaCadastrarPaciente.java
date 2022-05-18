/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Pedro
 * - After Close TelaCadastrarPaciente, respostas não podem mais aparecer
 * - Finalizar Insert da tela
 */
public class TelaCadastrarPaciente extends javax.swing.JInternalFrame {

    private Banco banco;
    private Connection connect;
    private WindowAdapter adapter;
    
    private String nome;
    private long cpf;
    private String nascimento;
    private long filhos;
    private String estadoCivil;
    private String loginProf;
    private String escolaridade;
    private TelaCadastrarAnamnese telaCadAnamn;
    /**
     * Creates new form TelaCadastrarPaciente
     */
    public TelaCadastrarPaciente() 
    {
        this.addInternalFrameListener( new InternalFrameAdapter()
        {
            public void internalFrameClosing(InternalFrameEvent e) 
            {
                System.out.println("Listener After Closing Tela Cadastrar Anamnese");
                //telaCadAnamn = null;
                //telaCadAnamn.dispose();
            }
        } );
        initComponents();
        this.initDatabase();
    }
    
    /*
    * This method initializes database
    */
    public void initDatabase()
    {
        // Get Connection with database
        banco = new Banco();
        connect = banco.getConnection();
    }

    /*
    * This method populates the Class members
    */
    public void popularMembros()
    {
        setNome(txtNome.getText());
        setLoginProf(txtLogin.getText());
        setNascimento(txtNascimento.getText());
        setCpf( Long.parseLong(txtCpf.getText()) );
        setFilhos( Long.parseLong(txtFilhos.getText()) );
        setEstadoCivil((String)cmbEstadoCivil.getSelectedItem());
        setEscolaridade((String)cmbEscolaridade.getSelectedItem());
    }
    
    /*
    * This method populates Usuario table
    */
    public int cadastrar() throws SQLException
    {
        String queryStringPaciente = "insert into paciente values"+
                "("+
                    "(select max(p.id_paciente)+1 from paciente p)," +
                    "?,"            + // Nome
                    "?,"            + // CPF
                    "?,"            + // Nascimento
                    "?,"            + // Escolaridade
                    "?,"            + // Estado Civil
                    "?,"            + // Filhos
                    "?"             + // Login do Médico
                ")";
        
        String queryStringProfPac = "insert into Profissional_paciente" +
                "("+
                    "(select max(p.id_paciente)+1 from Profissional_paciente pp)," +
                    "?,"            + // id Usuario
                    "?,"            + // id Paciente
                ")";

        /*
        * Prepare Profissional_Paciente query
        */
        PreparedStatement queryPaciente = (PreparedStatement) connect.prepareStatement(queryStringPaciente);
        queryPaciente.setString(1, this.getNome());
        queryPaciente.setLong(2, this.getCpf());
        queryPaciente.setString(3, this.getNascimento());
        queryPaciente.setString(4, this.getEscolaridade());
        queryPaciente.setString(5, this.getEstadoCivil());
        queryPaciente.setLong(6, this.getFilhos());
        queryPaciente.setString(7, this.getLoginProf());
        
        /*
        * Prepare Profissional_Paciente query
        */
        long id_prof = -1;
        String queryStringSearch = "select id_usuario"
                + " from usuario where login = ? and tipo_de_usuario='Profissional' ";
        
        PreparedStatement querySearch = (PreparedStatement) connect.prepareStatement(queryStringSearch);
        querySearch.setString(1, this.getLoginProf());
        
        System.out.println(querySearch);
        ResultSet resultado = querySearch.executeQuery();

        
        if (resultado.next() == true)
        {
            id_prof = Long.parseLong(resultado.getString("ID_USUARIO"));
            PreparedStatement queryProfPac = (PreparedStatement) connect.prepareStatement(queryStringProfPac);
            queryProfPac.setLong(1, id_prof);
        
            System.out.println(queryPaciente);
            System.out.println(queryProfPac);
            queryPaciente.executeUpdate();
            queryProfPac.executeUpdate();
            return 0;
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbEscolaridade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        txtFilhos = new javax.swing.JFormattedTextField();
        btnCadasAnamne = new javax.swing.JToggleButton();

        setClosable(true);

        jLabel1.setText("Nome");

        txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel2.setText("CPF");

        jLabel3.setText("Data de Nascimento");

        txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel4.setText("Filhos");

        jLabel5.setText("Estado Civil");

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)", "Viúvo(a)", "Relacionamento estável" }));
        cmbEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoCivilActionPerformed(evt);
            }
        });

        jLabel6.setText("Escolaridade");

        cmbEscolaridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhuma", "Ensino Fundamental", "Ensino Médio", "Ensino Superior" }));

        jLabel7.setText("Médico Responsável (Login)");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        txtFilhos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        btnCadasAnamne.setText("Cadastrar Anamnese");
        btnCadasAnamne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadasAnamneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCadastrar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(txtNome)
                                .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnCadasAnamne, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbEscolaridade, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadasAnamne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoCivilActionPerformed

    }//GEN-LAST:event_cmbEstadoCivilActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        int ret = 0;
        this.popularMembros();
        try {
            ret = this.cadastrar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            ret = 1;
        }
        if (ret == 0 )
        {
            JOptionPane.showMessageDialog(null, "Paciente Inserido");
            telaCadAnamn.dispose();
        }
        else if (ret == 1)
        {
            JOptionPane.showMessageDialog(null, "Problema ao inserir Paciente");
        }
        else if(ret == -1)
        {
            JOptionPane.showMessageDialog(null, "Não há um Profissional com esse login");
        }
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadasAnamneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadasAnamneActionPerformed
        if (telaCadAnamn == null)
        {
            telaCadAnamn = new TelaCadastrarAnamnese();
            telaCadAnamn.setVisible(true);
        }
        else
        {
            telaCadAnamn.setVisible(true);
        }
        
    }//GEN-LAST:event_btnCadasAnamneActionPerformed

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public long getFilhos() {
        return filhos;
    }

    public void setFilhos(long filhos) {
        this.filhos = filhos;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getLoginProf() {
        return loginProf;
    }

    public void setLoginProf(String loginProf) {
        this.loginProf = loginProf;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCadasAnamne;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cmbEscolaridade;
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtFilhos;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
