package org.item.service;

import org.item.models.ItemModel;
import org.item.repo.ItemRepo;
import org.item.repo.itemDetailsRepo;
import org.item.validation.ItemValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemService {

    private final ItemRepo repo = new ItemRepo();
    private final itemDetailsService itemDetailsService=new itemDetailsService();

    public List<String> addItem(ItemModel item) {

        List<String> errors = ItemValidation.validateItem(item.getName(),String.valueOf(item.getPrice()));
        if (!errors.isEmpty()) {
            return errors;
        }
        repo.addNewItem(item);
        return Collections.emptyList();
    }

    public List<ItemModel> getAllItems(int userId) {
        return repo.getItems(userId);
    }

    public ItemModel getItemById(int id, int userId) {
        return repo.getItemById(id,userId);
    }

    public List<String> updateItem(int id, ItemModel item) {
        List<String> errors = ItemValidation.validateItem(item.getName(), String.valueOf(item.getPrice()));
        if (!errors.isEmpty()) {
            return errors;
        }
        boolean updated = repo.updateItem(id, item);
        if (!updated) {
            List<String> updateErrors = new ArrayList<>();
            updateErrors.add("Update failed or item not found");
            return updateErrors;
        }
        return Collections.emptyList();
    }

    public List<String> deleteItem(int id, int userId) {
        itemDetailsService.deleteItemDetails(id);
        boolean deleted = repo.deleteItem(id,userId);
        if (!deleted) {
            List<String> deleteErrors = new ArrayList<>();
            deleteErrors.add("Delete failed or item not found");
            return deleteErrors;
        }

        return Collections.emptyList();
    }
}