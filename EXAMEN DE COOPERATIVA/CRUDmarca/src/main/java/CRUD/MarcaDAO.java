
package CRUD;

import com.crudmarca.conexionBD.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarcaDAO {
    // Método para agregar una nueva marca
    public void agregarMarca(String nombreMarca) {
        String query = "INSERT INTO Marca (nombre) VALUES (?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nombreMarca);
            preparedStatement.executeUpdate();
            System.out.println("Marca agregada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las marcas
    public void obtenerMarcas() {
        String query = "SELECT * FROM Marca";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_marca"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar una marca
    public void actualizarMarca(int idMarca, String nuevoNombre) {
        String query = "UPDATE Marca SET nombre = ? WHERE id_marca = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nuevoNombre);
            preparedStatement.setInt(2, idMarca);
            preparedStatement.executeUpdate();
            System.out.println("Marca actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una marca
    public void eliminarMarca(int idMarca) {
        String query = "DELETE FROM Marca WHERE id_marca = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idMarca);
            preparedStatement.executeUpdate();
            System.out.println("Marca eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
