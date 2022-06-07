/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planillas_drec;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import static planillas_drec.frm_planilla_v2.campos_edicion;

/**
 *
 * @author aE
 */
public class frm_consulta_editar extends javax.swing.JFrame {

    /**
     * Creates new form frm_consulta_editar
     */
    frm_menu menu;
    frm_planilla_v2 planilla;
    frm_edicion edicion;
    public frm_consulta_editar() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        frm_Login us = new frm_Login();
        String a = us.user;
        redirigir_form(a);
    }
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/cap.png"));
        return retValue;
    }
    cConexion c = new cConexion();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_year = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combo_mes = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        btn_inicio_ = new javax.swing.JButton();
        btn_planilla = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        VISUALIZAR_ = new javax.swing.JButton();
        ELIMINAR_ = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_ap_paterno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_ap_materno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("CONSULTA EDITAR");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("_");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("AÑO    :");

        txt_year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_yearKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("MES    :");

        combo_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        btn_inicio_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/house.png"))); // NOI18N
        btn_inicio_.setText("INICIO                ");
        btn_inicio_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicio_ActionPerformed(evt);
            }
        });

        btn_planilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/book.png"))); // NOI18N
        btn_planilla.setText("PLANILLA          ");
        btn_planilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_planillaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("GERENCIA REGIONAL");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DE EDUCACIÓN CUSCO");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel9.setText("© GEREDU/CENTRO CÓMPUTO 2021");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_inicio_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_planilla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_inicio_, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_planilla, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        VISUALIZAR_.setBackground(new java.awt.Color(255, 102, 0));
        VISUALIZAR_.setText("VISUALIZAR");
        VISUALIZAR_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VISUALIZAR_ActionPerformed(evt);
            }
        });

        ELIMINAR_.setText("ELIMINAR");
        ELIMINAR_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINAR_ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setText("AP. PATERNO   :");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel11.setText("AP. MATERNO  :");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel12.setText("NOMBRES         :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_ap_materno, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(txt_ap_paterno)
                                    .addComponent(txt_nombres)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(combo_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_year, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ELIMINAR_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(VISUALIZAR_, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_ap_paterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_ap_materno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(VISUALIZAR_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ELIMINAR_)
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void redirigir_form(String user) throws SQLException{
        String privilegio = c.tipo_user(user);
        if(privilegio.equals("planillero")){
            ELIMINAR_.setEnabled(false);
        }
    }
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        c.desconectar();
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void txt_yearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_yearKeyTyped
        char validar = evt.getKeyChar();
        if(!Character.isDigit(validar) || txt_year.getText().length()>=4){
            evt.consume();
        }
    }//GEN-LAST:event_txt_yearKeyTyped

    private void btn_inicio_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicio_ActionPerformed
        try {
            menu = new frm_menu();
            menu.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo salió mal..."+ex);
        }         
    }//GEN-LAST:event_btn_inicio_ActionPerformed

    private void btn_planillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_planillaActionPerformed
        planilla = new frm_planilla_v2();
        planilla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_planillaActionPerformed

    private void VISUALIZAR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VISUALIZAR_ActionPerformed
        boolean flag = validar_campos();
        if(flag){
            String mes = combo_mes.getSelectedItem().toString();
            String año = txt_year.getText(); 
            String pat = txt_ap_paterno.getText().trim();
            String mat = txt_ap_materno.getText().trim();
            String name = txt_nombres.getText().trim();
            String arr[] = {mes,año,pat,mat,name};
            try {
                int contador = c.verificar_consulta(arr);
                if(contador > 0){
                    campos_edicion[0] = arr[0];
                    campos_edicion[1] = arr[1];
                    campos_edicion[2] = arr[2];
                    campos_edicion[3] = arr[3];
                    campos_edicion[4] = arr[4];
                    edicion = new frm_edicion();
                    edicion.setVisible(true);
                    this.dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, "¡No existe registro con tales datos!", "MENSAJE", JOptionPane.WARNING_MESSAGE);               
            } 
            catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Algo salió mal..."+e);
            }    
        }
        else
            JOptionPane.showMessageDialog(null, "Complete los campos adecuadamente...", "MENSAJE", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_VISUALIZAR_ActionPerformed

    private void ELIMINAR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINAR_ActionPerformed
        boolean flag = validar_campos();
        if(flag){
            String mes = combo_mes.getSelectedItem().toString();
            String año = txt_year.getText(); 
            String pat = txt_ap_paterno.getText().trim();
            String mat = txt_ap_materno.getText().trim();
            String name = txt_nombres.getText().trim();
            String arr[] = {mes,año,pat,mat,name};
            try {
                int contador = c.verificar_consulta(arr);
                if(contador > 0){
                    int desicion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?","Mensaje",JOptionPane.YES_NO_OPTION);
                    if(desicion==JOptionPane.YES_OPTION){
                        String id[] = c.consultar_id_s(arr);
                        boolean f1 = c.delete_registro("tBoletas", "id", id[0]);
                        boolean f2 = c.delete_registro("tHaberes", "id", id[1]);
                        boolean f3 = c.delete_registro("tDescuentos", "id", id[2]);
                        if(f1 && f2 && f3)
                            JOptionPane.showMessageDialog(null, "El registro se eliminó correctamente");
                    }        
                }
                else
                    JOptionPane.showMessageDialog(null, "¡No existe registro con tales datos!", "MENSAJE", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Algo salió mal..."+e);
            }     
        }
        else
            JOptionPane.showMessageDialog(null, "Complete los campos adecuadamente...", "MENSAJE", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_ELIMINAR_ActionPerformed
    int xx,yy;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jPanel1MouseDragged
    public boolean validar_campos(){
        boolean flag = false;
        if(txt_year.getText().length() == 4 && txt_ap_paterno.getText().length() > 0 && txt_ap_materno.getText().length() > 0 && txt_nombres.getText().length() > 0){
            flag = true;
        }        
        return flag;
    }
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
            java.util.logging.Logger.getLogger(frm_consulta_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_consulta_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_consulta_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_consulta_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frm_consulta_editar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frm_consulta_editar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ELIMINAR_;
    private javax.swing.JButton VISUALIZAR_;
    private javax.swing.JButton btn_inicio_;
    private javax.swing.JButton btn_planilla;
    private javax.swing.JComboBox combo_mes;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_ap_materno;
    private javax.swing.JTextField txt_ap_paterno;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_year;
    // End of variables declaration//GEN-END:variables
}
