import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;

public class panelCajeros extends JFrame{

    JPanel cajeros;
    private JTextField nombreTF;
    private JTextField emailTF;
    private JTextField direccionTF;
    private JTextField celularTF;
    private JButton nuevoClienteButton;
    private JButton clienteAntiguoBTN;
    private JComboBox nombreCB;
    private JTextField idTF;
    private JButton borrarTF;
    private JComboBox produtosCB;
    private JButton comprarButton;
    private JButton finalizarButton;
    private JButton buscarButton;
    private JTextField nombreProductoTF;
    private JTextField codigoProductoTF;
    private JTextField cantidadProdcutoTF;
    private JTextField precioProdcutoTF;
    private JButton MostrarProductosBTN;
    private JTable tabla1;
    private JButton editarInformaciĆ³nButton;
    private JButton limpiarBusquedaBTN;
    private JTable tabla2;
    private JTextField cantidadAComprarTF;
    private JTextField totalPagarTF;

    ImageIcon icono2 = new ImageIcon("src/images/medicine.png");

    DefaultTableModel modelo1 = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    // **************************************** Variables ***********************************
    Connection con;
    Statement st;
    ResultSet rs;
    int item;
    double totalPagar;
    int cant;
    double pre;


    public static void main(String[] args) {
        JFrame frame = new JFrame("VENTANA DE CAJEROS");
        frame.setContentPane(new panelCajeros().cajeros);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public panelCajeros (){

            try{
                con= DriverManager.getConnection("jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC","csjurado","Montufar1996");
                st=con.createStatement();
                String s="select * from clientes ";
                rs=st.executeQuery(s);
                while(rs.next()){
                   nombreCB.addItem(rs.getString(2));

                }
                String s1="select * from productos ";
                rs= st.executeQuery(s1);
                while (rs.next()){
                    produtosCB.addItem(rs.getString(2));
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
            // ******************************************** TABLA ****************************************************************************
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Codigo");
        modelo2.addColumn("Stock");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("Precio");
        modelo2.addColumn("Total");
            // ******************************************** TABLA ****************************************************************************
        clienteAntiguoBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar_cliente();
            }
        });
        borrarTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Limpiar();
            }
        });
        nombreCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreTF.setText(""+nombreCB.getSelectedItem());
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar_producto();
            }
        });
        produtosCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreProductoTF.setText(""+produtosCB.getSelectedItem());
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar_producto();
            }
        });

        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //Comprar();
            Comprar_producto();

            }
        });


        tabla1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        limpiarBusquedaBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Limpiar_producto();
            }
        });
        MostrarProductosBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProductos();
            }
        });
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });
    }

    public void Buscar_cliente(){

        String nombre = "0";
        nombre=nombreTF.getText();

        final String DB_URL="jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "Montufar1996";

        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="select * from clientes where nombre=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,nombre);
            //System.out.println(sql);


            ResultSet rs=pst.executeQuery();


            if(rs.next()==true){
                String id  ,email,direccion, celular;
                id=rs.getString(1);
                nombre=rs.getString(2);
                email=rs.getString(3);
                celular=rs.getString(4);
                direccion=rs.getString(5);


                System.out.println();
                idTF.setText(id);
                nombreTF.setText(nombre);
                emailTF.setText(email);
                direccionTF.setText(direccion);
                celularTF.setText(celular);


            }
            else {
                ImageIcon icono = new ImageIcon("src/images/user.png");
                JOptionPane.showMessageDialog(null, "El usuario NO SE ENCUENTRA EN LA BASE DE DATOS",
                        "BUSCAR  ", JOptionPane.PLAIN_MESSAGE, icono);
                Limpiar();
            }
            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }
    public void Limpiar(){
        idTF.setText("");
        nombreTF.setText("");
        emailTF.setText("");
        direccionTF.setText("");
        celularTF.setText("");
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
            //System.out.println(sql);


            ResultSet rs=pst.executeQuery();


            if(rs.next()==true){
                String codigo,cantidad, precio;

                nombreProducto=rs.getString(2);
                codigo=rs.getString(3);
                cantidad=rs.getString(4);
                precio=rs.getString(5);

                System.out.println();
                nombreProductoTF.setText(nombreProducto);
                codigoProductoTF.setText(codigo);
                cantidadProdcutoTF.setText(cantidad);
                precioProdcutoTF.setText(precio);


            }
            else {
                JOptionPane.showMessageDialog(null, "EL PRODUCTO NO SE ENCUENTRA DISPONIBLE",
                        "BUSCAR  ", JOptionPane.PLAIN_MESSAGE, icono2);
                Limpiar();
            }
            stmt.close();
            conn.close();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
        //**************************************************** BUSQUEDA ************************************************
        // ******************************************** TABLA ***********************************************
        String where ="";
        if(!"".equals(nombreProducto)){
            where = "where nombreProducto ='"+ nombreProducto + "'";
        }
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            tabla1.setModel(modelo);
            con= DriverManager.getConnection("jdbc:mysql://mysql-csjurado.alwaysdata.net/csjurado_bdd?serverTimezone=UTC","csjurado","Montufar1996");
            st=con.createStatement();
            String s="select id,nombreProducto,codigo,cantidad,precio from productos "+where;
            rs=st.executeQuery(s);
            ResultSetMetaData rsMD = rs.getMetaData();
            int cantidadColumnas = rsMD.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("Nombre del producto");
            modelo.addColumn("CĆ³digo");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Precio");
            while(rs.next()){
                Object [] filas = new Object[cantidadColumnas];
                for(int i=0; i<cantidadColumnas;i++ ){
                    filas[i] =rs.getObject(i+1);

                }
                modelo.addRow(filas);
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

        // ******************************************** TABLA ***********************************************



    }

    public void Comprar (){

        int salida = JOptionPane.showConfirmDialog(null,"Deseas comprar el producto : "+nombreProductoTF.getText(),"COMPRAS",JOptionPane.YES_NO_CANCEL_OPTION,3,icono2);
        System.out.println(salida);
        if (salida==0){
            int compra;
             compra = Integer.parseInt(JOptionPane.showInputDialog(null," Cuanto desea comprar del producto : "+nombreProductoTF.getText(),"COMPRAS",JOptionPane.INFORMATION_MESSAGE));
             int cantidad=Integer.parseInt(cantidadProdcutoTF.getText());
             int nuevaCantidad = cantidad-compra;
             cantidadProdcutoTF.setText(String.valueOf(nuevaCantidad));
             Modificar_Productos();
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
            stmt.close();
            conn.close();
            Limpiar_producto();

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }
    public void Limpiar_producto(){
        nombreProductoTF.setText("");
        codigoProductoTF.setText("");
        cantidadProdcutoTF.setText("");
        precioProdcutoTF.setText("");
    }

    public void Comprar_producto(){
        tabla2.setModel(modelo2);
        if(!"".equals(cantidadAComprarTF.getText())){
            String codigo = codigoProductoTF.getText();
            String nombre = nombreProductoTF.getText();
            double precio = Double.parseDouble(precioProdcutoTF.getText());
            int stock = Integer.parseInt(cantidadProdcutoTF.getText());
            int cantidad = Integer.parseInt(cantidadAComprarTF.getText());
            int nuevaCantidad = stock - cantidad;
            cantidadProdcutoTF.setText(String.valueOf(nuevaCantidad));
            double total = cantidad*precio;
            if(stock>=cantidad){
                item = item+1;
                modelo2=(DefaultTableModel) tabla2.getModel();
                Object[] O =new Object[6];
                O[0]=nombre;
                O[1]=codigo;
                O[2]=stock;
                O[3]=cantidad;
                O[4]=precio;
                O[5]=total;
                modelo2.addRow(O);
            } else {
                JOptionPane.showMessageDialog(null,"STOCK NO DISPONIBLE ");
            }
        }else {
            JOptionPane.showMessageDialog(null,"Ingrese UNA CANTIDAD ");
        }

        Modificar_Productos();


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
            modelo1.addColumn("CĆ³digo");
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
    void calcularTotal(){
        totalPagar=0;
        for (int i =0;i<tabla2.getRowCount();i++){
            cant=Integer.parseInt(tabla2.getValueAt(i,3).toString());
            pre=Double.parseDouble(tabla2.getValueAt(i,4).toString());
            totalPagar=totalPagar+(cant*pre);
        }
        String.valueOf(totalPagar);
        totalPagarTF.setText(""+totalPagar);
        JOptionPane.showMessageDialog(null, "VENTA SATISFACTORIA", "PRODUCTOS  ", JOptionPane.PLAIN_MESSAGE, icono2);
    }

}
















