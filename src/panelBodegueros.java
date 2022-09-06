import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class panelBodegueros extends JFrame{
    JPanel bodegueros;
    private JComboBox productosCB;
    private JTextField nombreProductoTF;
    private JTextField codigoProductoTF;
    private JTextField cantidadProdcutoTF;
    private JTextField precioProdcutoTF;
    private JButton añadirUnProductoButton;
    private JButton eliminarUnProductoButton;
    private JButton modificarUnProductoButton;
    private JButton buscarUnProductoButton;
    private JButton limpiarButton;
    private JTable tabla1;
    private JTextField idTF;
    //******************************************** VARIABLES
    DefaultTableModel modelo1 = new DefaultTableModel();

    Connection con;
    Statement st;
    ResultSet rs;
    //**************************************** IMAGENES **********************

    public panelBodegueros (){
        try{
            con= DriverManager.getConnection("jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC","csjurado","Montufar1996");
            st=con.createStatement();
            String s1="select * from productos ";
            rs= st.executeQuery(s1);
            while (rs.next()){
                productosCB.addItem(rs.getString(2));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
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
        mostrarProductos();
        productosCB.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    nombreProductoTF.setText(""+productosCB.getSelectedItem());
                }
        });
        buscarUnProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar_producto();
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Limpiar_producto();
            }
        });
        eliminarUnProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar_producto();
            }
        });
        modificarUnProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificar_Productos();
            }
        });
        añadirUnProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aniadir_Productos();
            }
        });
    }
    public void Buscar_producto(){
        String nombreProducto = "0";
        nombreProducto=nombreProductoTF.getText();
        final String DB_URL="jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "Montufar1996";
        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="select * from productos where nombreProducto=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombreProducto);
            ResultSet rs=pst.executeQuery();
            if(rs.next()==true){
                String id,codigo,cantidad, precio;
                id=rs.getString(1);
                nombreProducto=rs.getString(2);
                codigo=rs.getString(3);
                cantidad=rs.getString(4);
                precio=rs.getString(5);

                idTF.setText(id);
                nombreProductoTF.setText(nombreProducto);
                codigoProductoTF.setText(codigo);
                cantidadProdcutoTF.setText(cantidad);
                precioProdcutoTF.setText(precio);


            }
            else {
                JOptionPane.showMessageDialog(null, "El PRODUCTO NO SE ENCUENTRA EN LA BASE DE DATOS ",
                        "BUSCAR  ", JOptionPane.PLAIN_MESSAGE);
                Limpiar_producto();
            }
            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");
        }
    }
    public void Limpiar_producto(){
        idTF.setText("");
        nombreProductoTF.setText("");
        codigoProductoTF.setText("");
        cantidadProdcutoTF.setText("");
        precioProdcutoTF.setText("");
    }

    public void Eliminar_producto(){
        final String DB_URL="jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "Montufar1996";
        String borrarid=nombreProductoTF.getText();

        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="delete from productos where nombreProducto=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,borrarid);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"PRODUCTO BORRADO ");
            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
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
            JOptionPane.showMessageDialog(null, "DATOS DEL PRODUCTO ACTUALIZADO CON EXITO",
                    "PRODUCTOS  ", JOptionPane.PLAIN_MESSAGE);
            stmt.close();
            conn.close();
            Limpiar_producto();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }
    public void Aniadir_Productos(){
        String  nombreProducto,codigoProducto, cantidadProducto, precioProducto;
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
            String sql="insert into productos(nombreProducto, codigo,cantidad,precio)values(?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombreProducto);
            pst.setString(2,codigoProducto);
            pst.setString(3,cantidadProducto);
            pst.setString(4,precioProducto);
            JOptionPane.showMessageDialog(null, "PRODUCTO AÑADIDO CON EXITO  ",
                    "NUEVO PRODUCTO REGISTRADO ", JOptionPane.PLAIN_MESSAGE);
            pst.executeUpdate();
            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }

    public void mostrarProductos(){
        try{
            tabla1.setModel(modelo1);
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
}
