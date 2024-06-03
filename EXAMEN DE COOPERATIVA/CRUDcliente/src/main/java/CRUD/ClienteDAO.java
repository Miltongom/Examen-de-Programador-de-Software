package CRUD;

import com.crudcliente.conexionBD.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public void addCliente(String nombre, String apellido, String telefono, String email) {
        String query = "INSERT INTO Cliente (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCliente(int id) {
        String query = "SELECT * FROM Cliente WHERE id_cliente = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_cliente"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Apellido: " + resultSet.getString("apellido"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCliente(int id, String nombre, String apellido, String telefono, String email) {
        String query = "UPDATE Cliente SET nombre = ?, apellido = ?, telefono = ?, email = ? WHERE id_cliente = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(int id) {
        String query = "DELETE FROM Cliente WHERE id_cliente = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
