package CRUD;

import com.crudtecnico.conexionBD.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TecnicoDAO {

    // Método para agregar un nuevo técnico
    public void agregarTecnico(String nombre, String apellido, String especialidad) {
        String query = "INSERT INTO Tecnico (nombre, apellido, especialidad) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, especialidad);
            preparedStatement.executeUpdate();
            System.out.println("Técnico agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los técnicos
    public void obtenerTecnicos() {
        String query = "SELECT * FROM Tecnico";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_tecnico"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Apellido: " + resultSet.getString("apellido"));
                System.out.println("Especialidad: " + resultSet.getString("especialidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un técnico
    public void actualizarTecnico(int idTecnico, String nombre, String apellido, String especialidad) {
        String query = "UPDATE Tecnico SET nombre = ?, apellido = ?, especialidad = ? WHERE id_tecnico = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, especialidad);
            preparedStatement.setInt(4, idTecnico);
            preparedStatement.executeUpdate();
            System.out.println("Técnico actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un técnico
    public void eliminarTecnico(int idTecnico) {
        String query = "DELETE FROM Tecnico WHERE id_tecnico = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idTecnico);
            preparedStatement.executeUpdate();
            System.out.println("Técnico eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
