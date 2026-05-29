package org.item.repo;

import org.item.Database.DBConnection;
import org.item.models.ItemModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemRepo {

    public ItemModel addNewItem(ItemModel item) {

        String sql = "INSERT INTO items (name, price, user_id) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());
            stmt.setInt(3, item.getUserId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    public List<ItemModel> getItems(int userId) {

        List<ItemModel> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItemModel item = new ItemModel();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                item.setUserId(rs.getInt("user_id"));
                items.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public ItemModel getItemById(int id, int userId) {

        String sql = "SELECT * FROM items WHERE id = ? AND user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setInt(2, userId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ItemModel item = new ItemModel();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                item.setUserId(rs.getInt("user_id"));
                return item;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateItem(int id, ItemModel item) {

        String sql = "UPDATE items SET name = ?, price = ? WHERE id = ? AND user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());
            stmt.setInt(3, id);
            stmt.setInt(4, item.getUserId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteItem(int id, int userId) {

        String sql = "DELETE FROM items WHERE id = ? AND user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setInt(2, userId);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}