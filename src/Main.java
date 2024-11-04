import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sistemaacademico";
        String usuario = "root";
        String password = "";

        String sql = "CREATE TABLE IF NOT EXISTS Usuarios (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(50) NOT NULL, " +
                "email VARCHAR(50), " +
                "edad INT" +
                ");";

        String nombre = "Juan Perez";
        String email = "juan.perez@example.com";
        int edad = 30;

        String sql1 = "INSERT INTO Usuarios (nombre, email, edad) VALUES (?, ?, ?)";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, password);

            Statement statement = conexion.createStatement();
            statement.executeUpdate(sql);

            PreparedStatement preparedStatement = conexion.prepareStatement(sql1);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, edad);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas insertadas: " + filasAfectadas);

            System.out.println("Conexión exitosa");

            preparedStatement.close();
            statement.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }

    }
}