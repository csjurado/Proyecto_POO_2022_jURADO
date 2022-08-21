import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class inicio extends JDialog{
    private JComboBox modosCB;
    private JButton ingresarBTN;
    private JButton salirBTN;
    private JTextField usuarioTF;
    private JPasswordField passwordTF;
    private JPanel panelInicio;

    public inicio(JFrame parent) {

        super(parent);
        setTitle("Login");
        setContentPane(panelInicio);
        setMinimumSize(new Dimension(640,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        ingresarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (modosCB.getSelectedItem().toString()=="CAJERO"){
                    String email = usuarioTF.getText();
                    String password = String.valueOf(passwordTF.getPassword());
                    System.out.println("boton ok");
                    user = getAuthenticationUser(email,password);
                    if(user!= null){

                        JFrame crud1 = new JFrame("CAJERO");
                        crud1.setContentPane(new panelCajeros().cajeros);
                        crud1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        crud1.pack();
                        crud1.setVisible(true);

                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(inicio.this,"Email o Password incorrectos","ERROR",JOptionPane.ERROR_MESSAGE);
                        Limpiar();
                    }
                }

                if (modosCB.getSelectedItem().toString()=="BODEGUERO"){
                    String email = usuarioTF.getText();
                    String password = String.valueOf(passwordTF.getPassword());
                    System.out.println("boton ok");
                    user = getAuthenticationBodeguero(email,password);
                    if(user!= null){

                        JFrame crud1 = new JFrame("BODEGUEROS");
                        crud1.setContentPane(new panelBodegueros().bodegueros);
                        crud1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        crud1.pack();
                        crud1.setVisible(true);
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(inicio.this,"Email o Password incorrectos","ERROR",JOptionPane.ERROR_MESSAGE);
                        Limpiar();
                    }
                }
                if (modosCB.getSelectedItem().toString()=="ADMINISTRADOR"){
                    String email = usuarioTF.getText();
                    String password = String.valueOf(passwordTF.getPassword());
                    System.out.println("boton ok");
                    user = getAuthenticationAdministrador(email,password);
                    if(user!= null){

                        JFrame crud1 = new JFrame("ADMINISTRADOR");
                        crud1.setContentPane(new panelAdministradores().administradores);
                        crud1.setSize(600,500);
                        crud1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        crud1.pack();
                        crud1.setVisible(true);
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(inicio.this,"Email o Password incorrectos","ERROR",JOptionPane.ERROR_MESSAGE);
                        Limpiar();
                    }
                }

            }
        });
        setVisible(true);
        salirBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Limpiar();
            }
        });
    }
    public User user;
    private User getAuthenticationUser(String email,String password){
        User user = null;

        final String DB_URL="jdbc:mysql://localhost/farmacia?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "12345";
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt=conn.createStatement();
            String sql="SELECT * FROM cajeros WHERE email=? AND password=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            System.out.println("Conexion ok ");
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                user= new User();

                user.nombre=resultSet.getString("nombre");
                user.email=resultSet.getString("email");
                user.celular=resultSet.getString("celular");
                user.direccion=resultSet.getString("direccion");
                user.password=resultSet.getString("password");
            }
            stmt.close();
            conn.close();
        }catch (Exception e){
            System.out.println("Error de conexion");
            e.printStackTrace();
        }

        return user;
    }

    private User getAuthenticationBodeguero(String email,String password){
        User user = null;

        final String DB_URL="jdbc:mysql://localhost/farmacia?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "12345";
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt=conn.createStatement();
            String sql="SELECT * FROM bodegueros WHERE email=? AND password=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            System.out.println("Conexion ok ");
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                user= new User();

                user.nombre=resultSet.getString("nombre");
                user.email=resultSet.getString("email");
                user.celular=resultSet.getString("celular");
                user.direccion=resultSet.getString("direccion");
                user.password=resultSet.getString("password");
            }
            stmt.close();
            conn.close();
        }catch (Exception e){
            System.out.println("Error de conexion");
            e.printStackTrace();
        }

        return user;
    }


    private User getAuthenticationAdministrador(String email,String password){
        User user = null;

        final String DB_URL="jdbc:mysql://localhost/farmacia?serverTimezone=UTC";
        final String USERNAME= "csjurado";
        final String PASSWORD= "12345";
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt=conn.createStatement();
            String sql="SELECT * FROM administradores WHERE email=? AND password=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            System.out.println("Conexion ok ");
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                user= new User();

                user.nombre=resultSet.getString("nombre");
                user.email=resultSet.getString("email");
                user.celular=resultSet.getString("celular");
                user.direccion=resultSet.getString("direccion");
                user.password=resultSet.getString("password");
            }
            stmt.close();
            conn.close();
        }catch (Exception e){
            System.out.println("Error de conexion");
            e.printStackTrace();
        }

        return user;
    }

    public static void main(String[] args) {
        inicio loginForm = new inicio(null);
        User user = loginForm.user;

        if(user!=null){

            ImageIcon usuarioimg = new ImageIcon("src/images/user.png");
            JOptionPane.showMessageDialog(null, "Atenticacion correcta :"+user.nombre +"\n Email : "+user.email+"\n Celular : "+user.celular +"\n Direccion : "+user.direccion +"\n Password : "+user.password,
                    "ACCESO PERMITIDO", JOptionPane.INFORMATION_MESSAGE, usuarioimg);

        }else{

            System.out.println("Autenticacion fallida");
        }
    }
    public void Limpiar(){
        //usuarioTF.setText("");
        passwordTF.setText("");
    }

}
