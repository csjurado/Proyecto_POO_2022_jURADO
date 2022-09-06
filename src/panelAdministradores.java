import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class panelAdministradores {
    JPanel administradores;
    private JButton agregarCajerosBTN;
    private JButton editarCajerosBTN;
    private JButton EliminarCajerosBTN;
    private JButton agregarProdcutosBTN;
    private JButton actualizarProdcutosBTN;
    private JButton editarProdcutosBTN;
    private JButton buscarCajerosBTN;
    private JTextField nombreCajeroTF;
    private JTextField emailCajeroTF;
    private JTextField celularcajeroTF;
    private JTextField direccionCajeroTf;

    private JButton eliminarProdcutosBTN;

    private JTable tabla1;
    private JTable tabla3;

    private JTextField nombreProductoTF;
    private JTextField codigoProductoTF;
    private JTextField cantidadProdcutoTF;
    private JTextField precioProdcutoTF;
    private JTextField passwordCajeroTF;
    //*************************************************************** IMAGENES
    ImageIcon icono2 = new ImageIcon("src/images/medicine.png");

    //********************************************VARIABLES
    Connection con;
    Statement st;
    ResultSet rs;
    int item;

    ///******************************************** TABLAS

    DefaultTableModel modelo1 = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    DefaultTableModel modelo3 = new DefaultTableModel();


    public panelAdministradores() {
        mostrarProductos();
        mostrarCajeros();
        editarProdcutosBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificar_Productos();
            }
        });
        actualizarProdcutosBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar_producto();
            }
        });
        editarCajerosBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificar_Cajeros();
            }
        });

        buscarCajerosBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar_cajero();
            }
        });
    }

    public void Modificar_Productos(){
        String nombreProducto,codigoProducto, cantidadProducto, precioProducto;
        nombreProducto=nombreProductoTF.getText();
        codigoProducto= codigoProductoTF.getText();
        cantidadProducto= cantidadProdcutoTF.getText();
        precioProducto= precioProdcutoTF.getText();
        final String DB_URL="jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "Montufar1996";
        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="update productos set codigo=?,cantidad=?,precio=? where nombreProducto=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,codigoProducto);
            pst.setString(2,cantidadProducto);
            pst.setString(3,precioProducto);
            pst.setString(4,nombreProducto);
            pst.executeUpdate();
            stmt.close();
            conn.close();
            Limpiar_producto();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");
        }
        JOptionPane.showMessageDialog(null,"PRODUCTO ACTUALIZADO CON EXITO");
    }
    public void Modificar_Cajeros(){
        String nombreCajero,emailCajero, celularCajero, direccionCajero,passwordCajero;
        nombreCajero=nombreCajeroTF.getText();
        emailCajero= emailCajeroTF.getText();
        celularCajero= celularcajeroTF.getText();
        direccionCajero= direccionCajeroTf.getText();
        passwordCajero= passwordCajeroTF.getText();
        final String DB_URL="jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "Montufar1996";
        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="update cajeros set email=?,celular=?,direccion=?,password=? where nombre=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombreCajero);
            pst.setString(2,emailCajero);
            pst.setString(3,celularCajero);
            pst.setString(4,direccionCajero);
            pst.setString(5,passwordCajero);
            pst.executeUpdate();
            stmt.close();
            conn.close();
            Limpiar_cajeros();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");
        }
        JOptionPane.showMessageDialog(null,"CAJERO ACTUALIZADO CON EXITO");
    }
    public void Limpiar_producto(){
        nombreProductoTF.setText("");
        codigoProductoTF.setText("");
        cantidadProdcutoTF.setText("");
        precioProdcutoTF.setText("");
    }
    public void Limpiar_cajeros(){
        nombreCajeroTF.setText("");
        emailCajeroTF.setText("");
        celularcajeroTF.setText("");
        direccionCajeroTf.setText("");
        passwordCajeroTF.setText("");
    }

    public void mostrarProductos(){
        try{
            tabla3.setModel(modelo1);
            con= DriverManager.getConnection("jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC","csjurado","Montufar1996");
            st=con.createStatement();
            String s="select id,nombreProducto,codigo,cantidad,precio from productos ";
            rs=st.executeQuery(s);
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            modelo1.addColumn("ID");
            modelo1.addColumn("Nombre del producto");
            modelo1.addColumn("Código");
            modelo1.addColumn("Cantidad");
            modelo1.addColumn("Precio");
            while(rs.next()){
                Object [] filas = new Object[cantidadColumnas];
                for(int i=0; i<cantidadColumnas;i++ ){
                    filas[i] =rs.getObject(i+1);
                }
                modelo1.addRow(filas);
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
        }
    }
    public void mostrarCajeros(){
        try{
            tabla1.setModel(modelo2);
            con= DriverManager.getConnection("jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC","csjurado","Montufar1996");
            st=con.createStatement();
            String s="select id,nombre,email,celular,direccion, password from cajeros ";
            rs=st.executeQuery(s);
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            modelo2.addColumn("ID");
            modelo2.addColumn("Nombre del cajero");
            modelo2.addColumn("Email");
            modelo2.addColumn("Celular");
            modelo2.addColumn("Direccion");
            modelo2.addColumn("Password");
            while(rs.next()){
                Object [] filas = new Object[cantidadColumnas];
                for(int i=0; i<cantidadColumnas;i++ ){
                    filas[i] =rs.getObject(i+1);
                }
                modelo2.addRow(filas);
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
        }
    }
    public void Buscar_producto(){
        String nombreProducto = "0";
        nombreProducto=nombreProductoTF.getText();

        final String DB_URL="jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "Montufar1996";
        //**************************************************** BUSQUEDA ************************************************
        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="select * from productos where nombreProducto=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombreProducto);
            ResultSet rs=pst.executeQuery();
            if(rs.next()==true){
                String codigo,cantidad, precio;
                nombreProducto=rs.getString(2);
                codigo=rs.getString(3);
                cantidad=rs.getString(4);
                precio=rs.getString(5);
                nombreProductoTF.setText(nombreProducto);
                codigoProductoTF.setText(codigo);
                cantidadProdcutoTF.setText(cantidad);
                precioProdcutoTF.setText(precio);
            }
            else {
                JOptionPane.showMessageDialog(null, "EL PRODUCTO NO SE ENCUENTRA DISPONIBLE",
                        "BUSCAR  ", JOptionPane.PLAIN_MESSAGE, icono2);
                Limpiar_producto();
            }
            stmt.close();
            conn.close();
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");
        }
    }
    public void Buscar_cajero(){
        String nombreCajero = "";
        nombreCajero=nombreCajeroTF.getText();

        final String DB_URL="jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "Montufar1996";
        //**************************************************** BUSQUEDA ************************************************
        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="select * from cajeros where nombre=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombreCajero);
            ResultSet rs=pst.executeQuery();
            if(rs.next()==true){
                String email,celular, direccion,password;
                nombreCajero=rs.getString(2);
                email=rs.getString(3);
                celular=rs.getString(4);
                direccion=rs.getString(5);
                password=rs.getString(6);
                nombreCajeroTF.setText(nombreCajero);
                emailCajeroTF.setText(email);
                celularcajeroTF.setText(celular);
                direccionCajeroTf.setText(direccion);
                passwordCajeroTF.setText(password);
            }
            else {
                JOptionPane.showMessageDialog(null, "EL CAJERO NO SE ENCUENTRA EN LA BASE DE DATOS",
                        "BUSCAR  ", JOptionPane.PLAIN_MESSAGE, icono2);
                Limpiar_cajeros();
            }
            stmt.close();
            conn.close();
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");
        }
    }

}
