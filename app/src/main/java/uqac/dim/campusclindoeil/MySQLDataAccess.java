package uqac.dim.campusclindoeil;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLDataAccess {
    public static void insertUtilisateur(String pseudo, String email, String motDePasse) {
        String sql = "INSERT INTO utilisateur (pseudo, email, mot_de_passe) VALUES (?, ?, ?)";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, pseudo);
            statement.setString(2, email);
            statement.setString(3, motDePasse);
            Log.i("DIM", "sql = " + sql);
            Log.i("DIM", "statement = " + statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertArticle(String nom, String description, double prix, int idVendeur, int idCategorie) {
        String sql = "INSERT INTO article (nom, description, prix, idVendeur, idCategorie) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nom);
            statement.setString(2, description);
            //statement.setString(3, prix);
            //statement.setString(4, idVendeur);
            //statement.setString(5, idCategorie);
            Log.i("DIM", "sql = " + sql);
            Log.i("DIM", "statement = " + statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
