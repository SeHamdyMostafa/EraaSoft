package org.item.repo;

import org.item.Database.DBConnection;
import org.item.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RememberMeRepo {

    public void saveToken(int userId, String token, int days) {

        String sql = "INSERT INTO remember_me_tokens (user_id, token, expiry_date) VALUES (?, ?, SYSDATE + ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setString(2, token);
            stmt.setInt(3, days);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserModel findUserByToken(String token) {

        String sql = "SELECT u.* FROM users u JOIN remember_me_tokens t ON u.id = t.user_id WHERE t.token = ? AND t.expiry_date > SYSDATE ";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, token);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteByUserId(int userId) {

        String sql = "DELETE FROM remember_me_tokens WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}