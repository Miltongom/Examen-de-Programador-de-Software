
package CRUD;

import com.crudservicio.conexionBD.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicioDAO {
    // Método para agregar un nuevo servicio
    public void agregarServicio(String fechaRecepcion, String estado, String diagnostico, String solucion,
                                 int idCliente, int idTecnico, int idEquipo) {
        String query = "INSERT INTO Servicio (fecha_recepcion, estado, diagnostico, solucion, id_cliente, id_tecnico, id_equipo) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, fechaRecepcion);
            preparedStatement.setString(2, estado);
            preparedStatement.setString(3, diagnostico);
            preparedStatement.setString(4, solucion);
            preparedStatement.setInt(5, idCliente);
            preparedStatement.setInt(6, idTecnico);
            preparedStatement.setInt(7, idEquipo);
            preparedStatement.executeUpdate();
            System.out.println("Servicio agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los servicios
    public void obtenerServicios() {
        String query = "SELECT * FROM Servicio";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID Servicio: " + resultSet.getInt("id_servicio"));
                System.out.println("Fecha Recepción: " + resultSet.getString("fecha_recepcion"));
                System.out.println("Estado: " + resultSet.getString("estado"));
                System.out.println("Diagnóstico: " + resultSet.getString("diagnostico"));
                System.out.println("Solución: " + resultSet.getString("solucion"));
                System.out.println("ID Cliente: " + resultSet.getInt("id_cliente"));
                System.out.println("ID Técnico: " + resultSet.getInt("id_tecnico"));
                System.out.println("ID Equipo: " + resultSet.getInt("id_equipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un servicio
    public void actualizarServicio(int idServicio, String fechaRecepcion, String estado, String diagnostico,
                                    String solucion, int idCliente, int idTecnico, int idEquipo) {
        String query = "UPDATE Servicio SET fecha_recepcion = ?, estado = ?, diagnostico = ?, solucion = ?, " +
                       "id_cliente = ?, id_tecnico = ?, id_equipo = ? WHERE id_servicio = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, fechaRecepcion);
            preparedStatement.setString(2, estado);
            preparedStatement.setString(3, diagnostico);
            preparedStatement.setString(4, solucion);
            preparedStatement.setInt(5, idCliente);
            preparedStatement.setInt(6, idTecnico);
            preparedStatement.setInt(7, idEquipo);
            preparedStatement.setInt(8, idServicio);
            preparedStatement.executeUpdate();
            System.out.println("Servicio actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un servicio
    public void eliminarServicio(int idServicio) {
        String query = "DELETE FROM Servicio WHERE id_servicio = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idServicio);
            preparedStatement.executeUpdate();
            System.out.println("Servicio eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
