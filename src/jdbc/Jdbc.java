/*
 * Ejemplo de conexion JDBC
 */
package jdbc;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sebas
 */
public class Jdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String user="root";
        String password="12345";
        String user2="sebaspaniaguai"; //db4free.net
        String password2="2169383";//db4free.net
        String name;
        Scanner teclado=new Scanner(System.in);
        try {
            System.out.println("Intentando conectar a la base de datos...");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/contactos", user, password);
            //Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/contactossp", user2, password2);//Para db4free.net
            System.out.println("Conexión existosa.");
            
            Statement estado= con.createStatement();
            //Cargar todos los contactos
            ResultSet resultado=estado.executeQuery("SELECT * FROM `clientes`");
            while(resultado.next()){
                System.out.println(resultado.getString("id")+"\t"+resultado.getString("name")+"\t\t"+resultado.getString("lastname")+"\t"+resultado.getString("phone"));
            }
            //Buscar por nombre
            System.out.println("Buscar por nombre: ");
            System.out.println("Ingrese el nombre qu desea buscar: ");
            name=teclado.nextLine();
            resultado=estado.executeQuery("SELECT * FROM `clientes` WHERE `name` LIKE '"+name+"'");
            while(resultado.next()){
                System.out.println(resultado.getString("id")+"\t"+resultado.getString("name")+"\t\t"+resultado.getString("lastname")+"\t"+resultado.getString("phone"));
            }
            
            //Ingresar contacto
            /*System.out.println("Ingrese nombre: ");
            name=teclado.nextLine();
            System.out.println("Ingrese apellido: ");
            String lastname=teclado.nextLine();
            System.out.println("Ingrese telefono: ");
            String phone=teclado.nextLine();
            estado.executeUpdate("INSERT INTO `clientes` VALUES (NULL, '"+name+"', '"+lastname+"','"+phone+"')");
            */
            //Eliminar contacto
            System.out.println("Ingrese nombre: ");
            name=teclado.nextLine();
            estado.executeUpdate("DELETE FROM `clientes` WHERE `name` LIKE '"+name+"'");
        } catch (SQLException ex) {
            System.out.println("Error de mysql");
        } catch (Exception e) {
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        }
    }
    
}
