/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planillas_drec;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author aE   (21-22)-06-2021   that's all, lo demas ya es relleno...
 *  
 *                                                      andreE
 */
public class frm_z extends javax.swing.JFrame {

    /**
     * Creates new form frm_z
     */
    frm_menu menu;
    public frm_z() {
        initComponents();
        setLocationRelativeTo(null);
        txt_ruta_haberes_.setEditable(false);
        txt_ruta_descuentos_.setEditable(false);
        txt_ruta_boletas_.setEditable(false);
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

        jPanel1 = new javax.swing.JPanel();
        btn_inicio_ = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        INSERT_ = new javax.swing.JButton();
        txt_ruta_descuentos_ = new javax.swing.JTextField();
        txt_ruta_boletas_ = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_ruta_haberes_ = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_select_route_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
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

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DIRECCI??N REGIONAL");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DE EDUCACI??N CUSCO");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("andreE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_inicio_, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_inicio_, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        INSERT_.setBackground(new java.awt.Color(51, 51, 51));
        INSERT_.setForeground(new java.awt.Color(204, 204, 204));
        INSERT_.setText("INSERT");
        INSERT_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERT_ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel12.setText("RUTA BOLETAS       :");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel11.setText("RUTA DESCUENTOS :");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setText("RUTA HABERES        :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("form_z");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        btn_select_route_.setText("|||");
        btn_select_route_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_select_route_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_ruta_boletas_))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_ruta_descuentos_))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_ruta_haberes_)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 367, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_select_route_)
                                .addGap(373, 373, 373))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(INSERT_)
                                .addGap(354, 354, 354))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addComponent(btn_select_route_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_ruta_haberes_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_ruta_descuentos_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_ruta_boletas_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(INSERT_)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inicio_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicio_ActionPerformed
        try {
            menu = new frm_menu();
            menu.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo sali?? mal..."+ex);
        }    
    }//GEN-LAST:event_btn_inicio_ActionPerformed
    int xx,yy;
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void btn_select_route_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_select_route_ActionPerformed
        
        JFileChooser archivo = new JFileChooser();
        try {
            archivo.setMultiSelectionEnabled(true);
            int ventana = archivo.showOpenDialog(null);
            if(ventana == JFileChooser.APPROVE_OPTION)
            {
                File[] file =archivo.getSelectedFiles();
                if(file.length == 3){
                    txt_ruta_haberes_.setText(String.valueOf(file[0]));
                    txt_ruta_descuentos_.setText(String.valueOf(file[1]));
                    txt_ruta_boletas_.setText(String.valueOf(file[2]));
                }     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione tres ficheros!\n"+e);
        }
    }//GEN-LAST:event_btn_select_route_ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        c.desconectar();
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked
    public boolean validar_campos(){
        boolean flag = false;
        if(txt_ruta_haberes_.getText().length() > 0 && txt_ruta_descuentos_.getText().length() > 0 && txt_ruta_boletas_.getText().length() > 0){
            flag = true;
        }        
        return flag;
    }
    
    private void INSERT_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERT_ActionPerformed
        boolean flag = validar_campos();
        if(flag){
            String ru_h = txt_ruta_haberes_.getText();
            String ru_d = txt_ruta_descuentos_.getText();
            String ru_b = txt_ruta_boletas_.getText();
            c.conexion();
            add_to_bd_haberes(ru_h,"tHaberes");
            add_to_bd_descuentos(ru_d,"tDescuentos");
            add_to_bd_boletas(ru_b,"tBoletas");
            JOptionPane.showMessageDialog(null, "muchos datos hermano\nnecesito vacaciones");
        }
    }//GEN-LAST:event_INSERT_ActionPerformed
    public void add_to_bd_haberes(String ruta, String tabla){
        try {
            FileReader fr = new FileReader(new File(ruta));
            BufferedReader br = new BufferedReader(fr);
            String dato;
            int len;
            String arreglo[];
            while((dato=br.readLine())!=null )
            {
                arreglo = dato.split(";");//botara un arreglo de 51(no todos los casos) campos haberes
                len = arreglo.length;
                limpiar_vacios_haberes(arreglo,len);
                c.insertar_txt(tabla, campos, valores);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo sali?? mal...\n"+e);
        }
    }
    public void add_to_bd_descuentos(String ruta, String tabla){
        try {
            FileReader fr = new FileReader(new File(ruta));
            BufferedReader br = new BufferedReader(fr);
            String dato;
            int len;
            String arreglo[];
            while((dato=br.readLine())!=null )
            {
                arreglo = dato.split(";");//botara un arreglo de 51(no todos los casos) campos haberes
                len = arreglo.length;
                limpiar_vacios_descuentos(arreglo,len);
                c.insertar_txt(tabla, campos, valores);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo sali?? mal...\n"+e);
        }
    }
    public void add_to_bd_boletas(String ruta, String tabla){
        try {
            FileReader fr = new FileReader(new File(ruta));
            BufferedReader br = new BufferedReader(fr);
            String dato;
            String arreglo[];
            while((dato=br.readLine())!=null )
            {
                arreglo = dato.split(";");//botara un arreglo de 51(no todos los casos) campos haberes
                c.insertar_txt_boletas(tabla, arreglo);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo sali?? mal...\n"+e);
        }
    }
    ArrayList<String> campos = new ArrayList();
    ArrayList<String> valores = new ArrayList();
    String campos_haberes[] = {"id","BASICO","PERSONAL","TP_HOMOL","TP_HOMOL_2","DIFERENCIAL","FAMILIAR",
                                "REF_MOV","ENCARGOS","CONTRATO","BON_DIR","DS_021","AGUINALDO","ESPECIAL",
                                "REUNIFICADA","IGV","CTS_RUR","DL_25671_19","PR_JU_CO","L_26504","DL_25897",
                                "DIREC","DU_90_96","DU_73_97","DU_11_99","DU_105_01",
                                "R01","R02","R03","R04","R05",
                                "R06","R07","R08","R09","R10",
                                "R11","R12","R13","R14","R15",
                                "R16","R17","R18","R19","R20",
                                "R21","R22","R23","R24","R25",};
    String campos_descuentos[] = {"id","L_20530","L_19990","SEG_SOCIAL","D_ADM","D_MAGIST","REMOPAL","CAP_YUPANQUI","JUDICIAL","L_25897_AFP","RET_AGUINALDO",
                                  "RESPONSAB","SESDIS","FONAVI","MULTAS","PESQUERIA","DERESE","S_SANT_D","C_IMPERI","SUBCAFAE","INTERBANK",
                                  "SITRADEC","A_F_PENS","ATACSE","TARDANZAS","CREDINKA","URPENS","C_MUNICIPAL",
                                "P01","P02","P03","P04","P05","P06","P07","P08","P09","P10","P11","P12","P13","P14","P15",
                                "P16","P17","P18","P19","P20","P21","P22","P23","P24","P25","L01","L02","L03","L04","L05",
                                "L06","L07","L08","L09","L10","L11","L12","L13","L14","L15","L16","L17","L18","L19","L20",
                                "L21","L22","L23","L24","L25",};
    
    public void limpiar_vacios_haberes(String a[],int len){
        campos.clear();
        valores.clear();
        for (int i = 0; i < len  ; i++) {
            if(!a[i].equals("")){
                campos.add(campos_haberes[i]);
                valores.add(a[i]);
            }
        }
    }
    public void limpiar_vacios_descuentos(String a[],int len){
        campos.clear();
        valores.clear();
        for (int i = 0; i < len  ; i++) {
            if(!a[i].equals("")){
                campos.add(campos_descuentos[i]);
                valores.add(a[i]);
            }
        }
    }
    /*
        
    */
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
            java.util.logging.Logger.getLogger(frm_z.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_z.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_z.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_z.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_z().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton INSERT_;
    private javax.swing.JButton btn_inicio_;
    private javax.swing.JButton btn_select_route_;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_ruta_boletas_;
    private javax.swing.JTextField txt_ruta_descuentos_;
    private javax.swing.JTextField txt_ruta_haberes_;
    // End of variables declaration//GEN-END:variables
}
                                                                                                                    //July forever