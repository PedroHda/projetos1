/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Pedro
 */
public class TelaCadastrarAnamnese extends javax.swing.JFrame {

    private Banco banco;
    private Connection connect;
    
    private long numPerguntas = 0;
    private int panY = 0;
    
    JPanel jpan;
    JLabel labels[];
    JTextField fields[];
    JScrollPane scroll;
    /**
     * Creates new form TelaCadastrarAnamnese
     */
    public TelaCadastrarAnamnese() {
        //initComponents();
        
        /*
        * Initializing frame
        */
        this.setSize(900,550);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        //this.setResizable(true);
        
        /*
        * Initializing panel
        */
        jpan = new JPanel();
        jpan.setBounds(40,0,600,300);
        jpan.setLayout(null);
        jpan.setBackground(Color.GRAY);
        
        initDatabase();
        
        try {
            buscarPerguntas();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastrarAnamnese.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        labels = new JLabel[(int)getNumPerguntas()];
        fields = new JTextField[(int)getNumPerguntas()];
        
        try {
            System.out.println("Inicializando...");
            inicializar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastrarAnamnese.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        * Initializing scroll
        */
        scroll = new JScrollPane();
        scroll.setBounds(50,0,700,400);
        scroll.setViewportView(jpan);
        //scroll.setLayout(null);
        scroll.setBackground(Color.yellow);
        /*
        * Add Panel
        */
        this.add(scroll);
        
        /*
        * Resize Panel
        */
        //this.setSize(800, 500);
        
        //scroll.validate();
        //scroll.repaint();
        //jpan.validate();
        //jpan.repaint();
        //this.validate();
        //this.repaint();
        
        System.out.println("Scroll visible:"+scroll.isVisible());
        System.out.println("Panel visible:"+jpan.isVisible());
    }

    public void inicializar() throws SQLException
    {
        String queryString =    "select pergunta"
                                +   " from perguntas";
        
        PreparedStatement query = (PreparedStatement) connect.prepareStatement(queryString);
        
        System.out.println(query);
        ResultSet resultado = query.executeQuery();

        /*
        * If there is more than 1 question the screen will be shown
        */
        int nPerguntas = (int) getNumPerguntas();
        if ( nPerguntas != 0)
        {
            jpan.setLayout(null);
            System.out.println("Buscando perguntas...");
            int cnt = 0;
            int y = 0;
            
            while (resultado.next() == true)
            {
                /*
                * get pergunta
                */
                String pergunta = resultado.getString("pergunta");
                
                /*
                * Building JLabel
                */
                labels[cnt] = new JLabel(pergunta);   
                labels[cnt].setBounds(0,y,500,20);
                y+=20;
                
                /*
                * Building JTextField
                */
                fields[cnt] = new JTextField();
                fields[cnt].setBounds(0, y, 500, 20);
                y+=20;
                
                /*
                * Adding label and field
                */
                jpan.add(labels[cnt]);
                jpan.add(fields[cnt]);
                ++cnt;
            }
            this.setPanY(y);
            jpan.validate();
            jpan.repaint();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nenhuma Pergunta cadastrada");
            this.dispose();
        }
        
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
    * This method returns the number of questions
    */
    void buscarPerguntas() throws SQLException
    {
        /*
        * Query de select count
        */
        String queryString = "select count(pergunta_id) as numPerguntas"
                + " from perguntas";
        
        PreparedStatement query = (PreparedStatement) connect.prepareStatement(queryString);
        
        //Log da query executada
        System.out.println(query);
        ResultSet resultado = query.executeQuery();
        
        resultado.next();
        long tempNum = resultado.getLong("numPerguntas");
        setNumPerguntas( tempNum );
        
        System.out.println("Num de perguntas:"+getNumPerguntas());
        
        resultado.close();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaCadastrarAnamnese.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarAnamnese.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarAnamnese.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarAnamnese.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrarAnamnese().setVisible(true);
            }
        });
    }

    public long getNumPerguntas() {
        return numPerguntas;
    }

    public void setNumPerguntas(long numPerguntas) {
        this.numPerguntas = numPerguntas;
    }

    public int getPanY() {
        return panY;
    }

    public void setPanY(int panY) {
        this.panY = panY;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
