package CRUD;

import com.crudequipo.conexionBD.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipoDAO {

    public void addEquipo(String tipo, String modelo, int id_marca) {
        String query = "INSERT INTO Equipo (tipo, modelo, id_marca) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tipo);
            preparedStatement.setString(2, modelo);
            preparedStatement.setInt(3, id_marca);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public void getEquipo(int id_equipo) {
        String query = "SELECT * FROM Equipo WHERE id_equipo = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id_equipo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_equipo"));
                System.out.println("Tipo: " + resultSet.getString("tipo"));
                System.out.println("Modelo: " + resultSet.getString("modelo"));
                System.out.println("ID Marca: " + resultSet.getInt("id_marca"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEquipo(int id_equipo, String tipo, String modelo, int id_marca) {
        String query = "UPDATE Equipo SET id_equipo ?, tipo = ?, modelo = ?, WHERE  = id_marca?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setInt(1, id_equipo);
            preparedStatement.setString(2, tipo);
            preparedStatement.setString(3, modelo);
            preparedStatement.setInt(4, id_marca);
           
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void deleteEquipo(int id_equipo) {
        String query = "DELETE FROM Equipo WHERE id_equipo = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id_equipo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}