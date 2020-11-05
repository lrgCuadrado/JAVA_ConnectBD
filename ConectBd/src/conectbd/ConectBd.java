package conectbd;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ConectBd {
Connection con;
    public void ConectBd(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/persona","root","1234");
            System.out.println("Conexion establecida");
            
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    
    }
    //Mostar datos de forma sucesiva
    public void mostrar_datos(){
        try {
           Statement st= con.createStatement();
           ResultSet rs= st.executeQuery("SELECT * FROM Usuario");
            while(rs.next()){
                System.out.println(rs.getInt("Id_usuario"));
            }
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
    
    public void buscar_datos(int id_usuario){
        try {
           Statement st= con.createStatement();
           ResultSet rs= st.executeQuery("SELECT * FROM Usuario WHERE Id_usuario=" + id_usuario);
            if(rs.next()){
                System.out.println(rs.getInt("Id_usuario")+" "+rs.getString("nombre"));
            }else{
                JOptionPane.showMessageDialog(null,"No exite el Usuario");
            }
        }catch (Exception e) {
            System.out.println("Error:" + e);
            JOptionPane.showMessageDialog(null, "¿Ya intento conectar a la base?");
        }
    }
    
}
