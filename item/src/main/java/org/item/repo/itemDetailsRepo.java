package org.item.repo;

import org.item.Database.DBConnection;
import org.item.models.item_details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class itemDetailsRepo {

    public boolean addItemDetails(item_details itemDetails){

        String sql = "INSERT INTO item_details (item_id, description, color, weight) VALUES (?, ?, ?, ?)";

        try(Connection connection= DBConnection.getConnection();
            PreparedStatement stmt=connection.prepareStatement(sql);)
        {
            stmt.setInt(1, itemDetails.getItemId());
            stmt.setString(2, itemDetails.getDescription());
            stmt.setString(3, itemDetails.getColor());
            stmt.setString(4, itemDetails.getWeight());
             return stmt.executeUpdate() > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<item_details> getItemDetails(){
        ArrayList<item_details> list=new ArrayList<>();
        String sql="SELECT * FROM item_details";

        try(Connection connection=DBConnection.getConnection();
            PreparedStatement stmt=connection.prepareStatement(sql);
            ResultSet resultSet=stmt.executeQuery();
        )

        {
            while (resultSet.next()){
                item_details itemDetails=new item_details();
                itemDetails.setItemId(resultSet.getInt("item_id"));
                itemDetails.setDescription(resultSet.getString("description"));
                itemDetails.setColor(resultSet.getString("color"));
                itemDetails.setWeight(resultSet.getString("weight"));
                list.add(itemDetails);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public item_details getItemDetailsById(int id){

        String sql = "SELECT * FROM item_details WHERE item_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet resultSet = stmt.executeQuery()) {

                if (resultSet.next()) {
                    item_details itemDetails = new item_details();

                    itemDetails.setItemId(resultSet.getInt("item_id"));
                    itemDetails.setDescription(resultSet.getString("description"));
                    itemDetails.setColor(resultSet.getString("color"));
                    itemDetails.setWeight(resultSet.getString("weight"));

                    return itemDetails;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateItemDetails(int item_id , item_details itemDetails){

        String sql = "UPDATE item_details SET description = ?, color = ?, weight = ? WHERE item_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, itemDetails.getDescription());
            stmt.setString(2, itemDetails.getColor());
            stmt.setString(3, itemDetails.getWeight());
            stmt.setInt(4, item_id);

            return stmt.executeUpdate() >0;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteItemDetails(int item_id){

        String sql="DELETE FROM item_details WHERE item_id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item_id);
            {
                return stmt.executeUpdate() > 0;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existsByItemId(int itemId) {

        String sql = "SELECT 1 FROM item_details WHERE item_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, itemId);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
