package org.item.repo;

import org.item.Database.DBConnection;
import org.item.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepo {

    public boolean SignUp(UserModel userModel){

        String sql="INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try(Connection connection= DBConnection.getConnection()) {
            PreparedStatement stm= connection.prepareStatement(sql);

            stm.setString(1,userModel.getUsername());
            stm.setString(2,userModel.getEmail());
            stm.setString(3,userModel.getPassword());

            return stm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public UserModel login(String email, String password){

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setString(1, email);
            stm.setString(2, password);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    UserModel user = new UserModel();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    return user;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
