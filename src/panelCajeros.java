import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton mostrarButton;
    Connection con;
    Statement st;
    ResultSet rs;
    public static void main(String[] args) {
        JFrame frame = new JFrame("VENTANA DE CAJEROS");
        frame.setContentPane(new panelCajeros().cajeros);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public panelCajeros (){

            try{
                con= DriverManager.getConnection("jdbc:mysql://localhost/farmacia?serverTimezone=UTC","csjurado","12345");
                //con= DriverManager.getConnection("jdbc:mysql://mysql-jzaldumbide.alwaysdata.net/jzaldumbide_bdd?serverTimezone=UTC","278457","rYqhic-buvwoh-1tecqe");
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
    }
    public void Buscar_cliente(){

        String nombre = "0";
        nombre=nombreTF.getText();

        final String DB_URL="jdbc:mysql://localhost/farmacia?serverTimezone=UTC";
        final String USERNAME="csjurado";
        final String PASSWORD="12345";


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
                direccion=rs.getString(4);
                celular=rs.getString(5);

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

        final String DB_URL="jdbc:mysql://localhost/farmacia?serverTimezone=UTC";
        final String USERNAME="csjurado";
        final String PASSWORD="12345";


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

}
