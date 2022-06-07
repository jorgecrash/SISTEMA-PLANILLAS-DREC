/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planillas_drec;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aE   17/06/2021   08.08.2021
 */
public class cConexion {
    //atributos
    private String aClase  = "com.mysql.cj.jdbc.Driver";;
    private String aServidor = "jdbc:mysql://127.0.0.1/";//192.168.1.155//127.0.0.1
    private String aNombreBD = "db_drec?useTimezone=true&serverTimezone=UTC";
    private String aUsuario = "user01";//user01
    private String aPassword = "geredu_cc2021";//"duhast";//geredu_cc2021
    
    //métodos
    public static Connection cn = null;
    public  Connection conexion(){
        try {
            Class.forName(aClase);
            String url = aServidor+aNombreBD ;
            cn = DriverManager.getConnection(url,aUsuario,aPassword);
        } 
        catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR A LA BD\n"+e);
        }
        return cn;
    }
     public void desconectar(){
         //Connection cn = null;
         cn = null;
         //System.out.println("se desconecto...");
     }
    /*EN CASO ENCUENTRE RETORNA 1 CASO CONTARIO 0*/
    public int buscar(String clave) throws SQLException
    {
        String sql = "SELECT count(usuario) from tUsuario where usuario = '"+clave+"'";
        int n = 0;
        Statement stm;
        stm=cn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
        {
            n=rs.getInt(1);
        }
        stm.close();
        return n;
    }
    /*30.07.2021 =J */
    public boolean get_user_pass(String us, String pass) throws SQLException{
        boolean flag = false;
        String sql="SELECT * from tUsuario where usuario='"+us+"' && contraseña='"+pass+"'";
        //String user;
        Statement stm;
        stm=cn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
        {
            flag = true;
            //user=rs.getString(1);
            //System.out.println("user: "+user);
        }
        stm.close();
        return flag;
    }
    public String tipo_user(String user) throws SQLException{
        String tipo = "";
        String sql = "select A.tipo_Privilegio from tPrivilegios A inner join tUsuario B "
                + "on A.id_Privilegio = B.id_Privilegio where B.usuario = '"+user+"'";
        Statement stm = cn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
        {
           tipo = rs.getString(1);
        }
        stm.close();  
        return tipo;
    }
    public boolean insertar(String nameTabla, String a[])//insertar tabla boletas
    {
        boolean flag = false;
        int len = a.length;
        PreparedStatement ps;
        String valores = "";
        for (int i = 0; i < len; i++) {
            if(i<len-1)
                valores+="?,";
            else
                valores+="?";
        }
        String insertar_esto = "insert into "+nameTabla+" values ("+valores+")";
        try {
            ps = cn.prepareCall(insertar_esto);
            for (int i = 0; i < len; i++) 
            {
                if(i==0 || i==14 || i==15){
                    ps.setInt(i+1, Integer.parseInt(a[i]));//son enteros
                }
                if(i==16 || i==17 || i==18){
                    ps.setFloat(i+1, Float.parseFloat(a[i]));//son flotantes
                }
                else
                    ps.setString(i+1, a[i]);                //son strings
            }
            int registro = ps.executeUpdate();
            if(registro > 0){
                flag = true;
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente");
            }
            ps.close();
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar... Verifique los campos"); 
        } 
        return flag;
    }
    //v_new
    public boolean insertar_haberes_descuentos(String nameTabla, ArrayList<String> campos, ArrayList<Float> value)
    {
        boolean flag = false;
        int len = campos.size();
        PreparedStatement ps;
        String campo = "";
        String valores = "";
        for (int i = 0; i < len; i++) {
            if(i<len-1){
                campo+=campos.get(i)+",";
                valores+="?,";
            }            
            else{
                campo+=campos.get(i);
                valores+="?";             
            }              
        }
        String insertar_esto = "insert into "+nameTabla+" ("+campo+") values ("+valores+")";
        try {
            ps = cn.prepareCall(insertar_esto);
            for (int i = 0; i < len; i++) 
            {
                if(i==0){
                    float x = value.get(i);
                    ps.setInt(i+1, (int)x);//son enteros
                }
                else
                    ps.setFloat(i+1, value.get(i));    
            }
            int registro = ps.executeUpdate();
            if(registro > 0)
                flag = true;
            ps.close();
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal...\n"+e);
        }
        return flag;
    }
    public int obtener_id_incrementable(String campo, String tabla)
    {
        int id = 1;
        PreparedStatement ps; //bota el ultimo id
        try {
            ps= cn.prepareStatement("select max("+campo+") from "+tabla);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(1) + 1;
            }
            rs.close();
            ps.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal..."+e);
        }
        return id;
    }
    public String [] campo_nombre() throws SQLException{
        Statement stm;
        stm=cn.createStatement();
        ResultSet rs = stm.executeQuery("select A.Mes,A.Año,A.Ape_Paterno,A.Ape_Materno,A.Nombres,A.DNI,A.Cod_Modular,A.Cargo,A.Nivel_Remunerativo,A.Condicion,A.Horas,A.Cod_Planilla,A.Establecimiento,A.T_REMUN,A.T_DSCTO,A.T_LIQUI,B.*,C.* from tBoletas A, tHaberes B, tDescuentos C where A.id_Haberes = B.id and A.id_Descuentos = C.id");
        int cant = rs.getMetaData().getColumnCount();
        String field[] = new String[cant];
        for (int i = 0; i < cant; i++) {
            field[i] = rs.getMetaData().getColumnName(i+1);
        }
        return field;
    }
    public void valores_de_la_consulta_individual(ArrayList boleta,ArrayList importes,ArrayList hab, ArrayList des, String []arr){
        PreparedStatement ps;
        try {
            ps= cn.prepareStatement("select A.Mes,A.Año,A.Ape_Paterno,A.Ape_Materno,A.Nombres,A.DNI,A.Cod_Modular,A.Cargo,A.Nivel_Remunerativo,A.Condicion,A.Horas,A.Cod_Planilla,A.Establecimiento,A.T_REMUN,A.T_DSCTO,A.T_LIQUI,B.*,C.* from tBoletas A, tHaberes B, tDescuentos C where A.id_Haberes = B.id and A.id_Descuentos = C.id and A.mes = '"+arr[0]+"' and A.año = '"+arr[1]+"' and Ape_Paterno = '"+arr[2]+"' and Ape_Materno = '"+arr[3]+"' and Nombres = '"+arr[4]+"'");
            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                for (int i = 1; i <= 13; i++) {
                    boleta.add(rs.getString(i));
                }
                for (int i = 14; i <= 16; i++) {
                    importes.add(rs.getString(i));
                }
                for (int i = 18; i <= 67; i++) {
                    hab.add(rs.getString(i));
                }
                for (int i = 69; i <= 145; i++) {
                    des.add(rs.getString(i));
                }
            }
            rs.close();
            ps.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal..."+e);
        }
    }
     public void valores_de_la_consulta_grupal(ArrayList boleta,ArrayList importes,ArrayList hab, ArrayList des, String []arr){
        PreparedStatement ps; 
        try {
            ps= cn.prepareStatement(" select A.Mes,A.Año,A.Ape_Paterno,A.Ape_Materno,A.Nombres,A.DNI,A.Cod_Modular,A.Cargo,A.Nivel_Remunerativo,A.Condicion,A.Horas,A.Cod_Planilla,A.Establecimiento,A.T_REMUN,A.T_DSCTO,A.T_LIQUI,B.*,C.* from tBoletas A, tHaberes B, tDescuentos C where A.id_Haberes = B.id and A.id_Descuentos = C.id and A.mes = '"+arr[0]+"' and A.año = '"+arr[1]+"' and A.condicion = '"+arr[2]+"'");
            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                for (int i = 1; i <= 13; i++) {
                    boleta.add(rs.getString(i));
                }
                for (int i = 14; i <= 16; i++) {
                    importes.add(rs.getString(i));
                }
                for (int i = 18; i <= 67; i++) {
                    hab.add(rs.getString(i));
                }
                for (int i = 69; i <= 145; i++) {
                    des.add(rs.getString(i));
                }
            }
            rs.close();
            ps.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal..."+e);
        }
    }
    /*EN CASO ENCUENTRE RETORNA 1 CASO CONTARIO 0*/
    public int verificar_consulta(String[] campos) throws SQLException
    {   
        String sql = "SELECT count(*) as contador from tBoletas where Mes = '"+campos[0]+"' and Año = '"+campos[1]+"' and Ape_Paterno = '"+campos[2]+"' and Ape_Materno = '"+campos[3]+"' and Nombres = '"+campos[4]+"'";
        int n = 0;
        Statement stm;
        stm=cn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
        {
            n=rs.getInt(1);
        }
        stm.close();
        return n;
    }
    
    public void iniciar_jtable(JTable tabla1) throws SQLException
    {
        DefaultTableModel tabla = new DefaultTableModel();
        Statement stm;
        stm=cn.createStatement();
        ResultSet rs = stm.executeQuery("select A.usuario, A.contraseña, A.dni,B.tipo_privilegio from tusuario A, tprivilegios B where A.id_privilegio = B.id_privilegio");
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int nroCampos = rsmd.getColumnCount();
            for (int i = 0; i < nroCampos - 1; i++) 
            {
                tabla.addColumn(rsmd.getColumnName(i+1));              
            }
            tabla.addColumn("privilegio");
            while (rs.next()) {
                Object dato[]=new  Object[nroCampos];
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                dato[3]=rs.getString(4);      
                tabla.addRow(dato);
            }
            tabla1.setModel(tabla);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal..."+e);
        }
    }
    public String get_id_privilegio(String privilegio) throws SQLException{
        String tipo = "";
        String sql ="select id_Privilegio from tprivilegios where tipo_privilegio = '"+privilegio+"'";
        Statement stm = cn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
        {
           tipo = rs.getString(1);
        }
        stm.close();  
        return tipo;
    }
    public void insertar_user(String nameTabla, String a[])//insertar tabla usuarios
    {
        int len = a.length;
        PreparedStatement ps;
        String valores = "";
        for (int i = 0; i < len; i++) {
            if(i<len-1)
                valores+="?,";
            else
                valores+="?";
        }
        String insertar_esto = "insert into "+nameTabla+" values ("+valores+")";
        try {
            ps = cn.prepareCall(insertar_esto);
            for (int i = 0; i < len; i++) 
            {
                ps.setString(i+1, a[i]);
            }
            int registro = ps.executeUpdate();
            if(registro > 0)
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente","MENSAJE",JOptionPane.INFORMATION_MESSAGE);
            ps.close();
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal..."+e);
        }    
    }
    
    public boolean delete_registro(String nameTable,String nameField,String primaryKey){
        boolean flag = false;
        try {
            String sql = "delete from "+nameTable+" where "+nameField+" = '"+primaryKey+"'";
            Statement stm = cn.createStatement();
            int s = stm.executeUpdate(sql);
            if(s>0)
                flag = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo salió mal..."+ex);
        }
        return flag;
    }
    /*EN CASO ENCUENTRE RETORNA 1 CASO CONTARIO 0*/
    public int verificar_consulta_grupal(String[] campos) throws SQLException
    {
        String sql = "SELECT count(*) as contador from tBoletas where Mes = '"+campos[0]+"' and Año = '"+campos[1]+"' and Condicion = '"+campos[2]+"'";
        int n = 0;
        Statement stm;
        stm=cn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
        {
            n=rs.getInt(1);
        }
        stm.close();
        return n;
    }
    public void valores_de_la_consulta_editar(ArrayList generales, ArrayList haber,ArrayList descuento, String []campos_ed){
        PreparedStatement ps;
        try { 
            ps= cn.prepareStatement("select A.Mes,A.Año,A.Ape_Paterno,A.Ape_Materno,A.Nombres,A.DNI,A.Cod_Modular,A.Cargo,A.Nivel_Remunerativo,A.Horas,A.Condicion,A.Cod_Planilla,A.Establecimiento,"
                    + "B.*,C.* from tBoletas A, tHaberes B, tDescuentos C where A.id_Haberes = B.id and A.id_Descuentos = C.id "
                    + "and A.Mes = '"+campos_ed[0]+"' and A.Año = '"+campos_ed[1]+"' and A.Ape_Paterno = '"+campos_ed[2]+"' and A.Ape_Materno = '"+campos_ed[3]+"' and A.Nombres = '"+campos_ed[4]+"'");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                for (int i = 1; i <= 13; i++) {
                    generales.add(rs.getString(i));
                }//i==14 id haberes
                for (int i = 15; i <= 64; i++) {
                    haber.add(rs.getString(i));
                }//i==65 id descuentos
                for (int i = 66; i <= 142; i++) {
                    descuento.add(rs.getString(i));
                }
            }
            rs.close();
            ps.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal... "+e);
        }
    }
    public String[] consultar_id_s(String []campos){
        String retornar[] = new String[3];
        PreparedStatement ps;
        try {
            ps= cn.prepareStatement("select A.id,B.id,C.id  from tBoletas A, tHaberes B, tDescuentos C where A.id_Haberes = B.id and A.id_Descuentos = C.id and A.Mes = '"+campos[0]+"' and A.Año = '"+campos[1]+"' and A.Ape_Paterno = '"+campos[2]+"' and A.Ape_Materno = '"+campos[3]+"' and A.Nombres = '"+campos[4]+"'");
            ResultSet rs=ps.executeQuery();                                   
            while(rs.next())
            {
                retornar[0] = rs.getString(1);
                retornar[1] = rs.getString(2);
                retornar[2] = rs.getString(3);  
            }
            rs.close();
            ps.close();           
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal..."+e);
        }
        return retornar;
    }
    public void respaldo_tabla_b(String name_table,ArrayList valores){
        PreparedStatement ps;
        try {
            ps= cn.prepareStatement("select * from "+name_table);
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int nroCampos = rsmd.getColumnCount();
            while(rs.next())
            {
                for (int i = 1; i <= nroCampos; i++) {
                    valores.add(rs.getString(i));
                }   
            }         
            rs.close();
            ps.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal... "+e);
        }
    }
    /*para salvar*/
//    public void respaldo_tabla_b(String name_table,ArrayList valores){
//        PreparedStatement ps;
//        try {
//            ps= conexion().prepareStatement("select * from "+name_table);
//            ResultSet rs=ps.executeQuery();
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int nroCampos = rsmd.getColumnCount();
//            int pp = 1;
//            while(rs.next())
//            {
//                for (int i = 1; i <= nroCampos; i++) {
//                    if(i==15 || i == 16){
//                        valores.add(String.valueOf(pp));
//                    }
//                    else
//                        valores.add(rs.getString(i));
//                }
//                pp++;
//            }         
//            rs.close();
//            ps.close();
//        } 
//        catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Algo salió mal... "+e);
//        }
//    }
    public void respaldo_tablas_h_d(String name_table,ArrayList valores){
        PreparedStatement ps;
        try {
            ps= cn.prepareStatement("select * from "+name_table);
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int nroCampos = rsmd.getColumnCount();
            while(rs.next())
            {
                for (int i = 1; i <= nroCampos; i++) {
                    if(rs.getString(i) == (null))
                        valores.add("");
                    else
                        valores.add(rs.getString(i));
                }   
            }         
            rs.close();
            ps.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal... "+e);
        }
    }
    /*para salvar*/
//    public void respaldo_tablas_h_d(String name_table,ArrayList valores){
//        PreparedStatement ps;
//        try {
//            ps= conexion().prepareStatement("select * from "+name_table);
//            ResultSet rs=ps.executeQuery();
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int nroCampos = rsmd.getColumnCount();
//            int pp = 1;
//            while(rs.next())
//            {
//                valores.add(String.valueOf(pp));
//                for (int i = 2; i <= nroCampos; i++) {
//                    if(rs.getString(i) == (null))
//                        valores.add("");
//                    else
//                        valores.add(rs.getString(i));
//                }
//                pp++;
//            }         
//            rs.close();
//            ps.close();
//        } 
//        catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Algo salió mal... "+e);
//        }
//    }
    /*consulta todos los campos boleta haberes descuentos, incluidos ids*/
    public void consulta_back_up_lineal(ArrayList valores, String[] campos){
        PreparedStatement ps;
        try {
            ps= cn.prepareStatement("select A.*,B.*,C.* from tBoletas A, tHaberes B, tDescuentos C where A.id_Haberes = B.id and A.id_Descuentos = C.id and A.Mes = '"+campos[0]+"' and A.Año = '"+campos[1]+"' and A.Condicion = '"+campos[2]+"'");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int nroCampos = rsmd.getColumnCount();
            while(rs.next())
            {
                for (int i = 1; i <= nroCampos; i++) {
                    if(rs.getString(i) == (null))
                        valores.add("");
                    else
                        valores.add(rs.getString(i));
                }   
            }         
            rs.close();
            ps.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal... "+e);
        }
    }
    /*metodo para insertar del txt a la bd*/
    public void insertar_txt(String nameTabla, ArrayList campos, ArrayList<String> value){
        int len = campos.size();
        PreparedStatement ps;
        String campo = "";
        String valores = "";
        for (int i = 0; i < len; i++) {
            if(i<len-1){
                campo+=campos.get(i)+",";
                valores+="?,";
            }            
            else{
                campo+=campos.get(i);
                valores+="?";             
            }              
        }
        String insertar_esto = "insert into "+nameTabla+" ("+campo+") values ("+valores+")";
        try {
            ps = cn.prepareCall(insertar_esto);
            for (int i = 0; i < len; i++) 
            {
                if(i==0){
                    ps.setInt(i+1, Integer.parseInt(value.get(i)));//son enteros
                }
                else
                    ps.setFloat(i+1, Float.parseFloat(value.get(i)));
            }
            int registro = ps.executeUpdate();
            ps.close();//no le hace nada si lo saco
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal... "+e);
        }    
    }
    public void insertar_txt_boletas(String nameTabla, String a[])
    {
        PreparedStatement ps;
        String valores = "";
        for (int i = 0; i < 19; i++) {
            if(i<18)
                valores+="?,";
            else
                valores+="?";
        }
        String insertar_esto = "insert into "+nameTabla+" values ("+valores+")";
        try {
            //ps = conexion().prepareCall(insertar_esto);
            ps = cn.prepareCall(insertar_esto);
            for (int i = 0; i < 19; i++) 
            {
                if(i==0 || i==14 || i==15){
                    ps.setInt(i+1, Integer.parseInt(a[i]));//son enteros
                }
                if(i==16 || i==17 || i==18){
                    ps.setFloat(i+1, Float.parseFloat(a[i]));//son flotantes
                }
                else
                    ps.setString(i+1, a[i]);                //son strings
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal... "+e);
        }
    }
    
    /*modulos prueba para el update  13.07.21*/
    public boolean modificar_haber_descuento(String nameTabla, String valores[], String primaryKey) throws SQLException
    {
        boolean flag = false;
        String campos = getNombreCampos(nameTabla);
        int len = valores.length;
        PreparedStatement ps;  
        try {
            ps= cn.prepareStatement("UPDATE "+nameTabla+" set "+campos+" where id ='"+primaryKey+"'");         
            for (int i = 0; i < len; i++) 
            {
                ps.setString(i+1, valores[i]);
            }
            int registro = ps.executeUpdate();
            if(registro > 0){
                flag = true;
            }    
            else
                JOptionPane.showMessageDialog(null, "No se pudo modificar...");
            ps.close();
        } 
        catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal...\n"+e);
        }
        return flag;
    }
    /*obtiene el nombre de los campos con =?*/
    public String getNombreCampos(String nameTabla) throws SQLException
    {
        String cadena = "";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from "+nameTabla);
        try {          
            ResultSetMetaData rsmd = rs.getMetaData();
            int nroCampos = rsmd.getColumnCount();
            for (int i = 1; i < nroCampos; i++) 
            {
                if(i<nroCampos-1)
                {
                    cadena = cadena+rsmd.getColumnName(i+1)+"=?, ";
                }
                else
                    cadena = cadena+rsmd.getColumnName(i+1)+"=? ";     
            }              
            rs.close();       
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal...\n"+e);
        }
        return cadena;
    }
    public void modificar_boleta(String nameTabla, String valores[], String primaryKey)
    {
        String campos = "Mes= ?,Año= ?,Ape_Paterno= ?,Ape_Materno= ?,Nombres= ?,DNI= ?,Cod_Modular= ?,Cargo= ?,Nivel_Remunerativo= ?,Horas= ?,Condicion= ?,Cod_Planilla= ?,Establecimiento= ?,T_REMUN= ?,T_DSCTO= ?,T_LIQUI= ?";
        int len = valores.length;
        PreparedStatement ps;  
        try {
            ps= cn.prepareStatement("UPDATE "+nameTabla+" set "+campos+" where id ='"+primaryKey+"'");         
            for (int i = 0; i < len; i++) 
            {
                ps.setString(i+1, valores[i]);
            }
            int registro = ps.executeUpdate();
            if(registro > 0){
                JOptionPane.showMessageDialog(null, "El registro se modificó correctamente");
            }    
            else
                JOptionPane.showMessageDialog(null, "No se pudo modificar...");
            ps.close();
        } 
        catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal...\n"+e);
        }
    }
}
