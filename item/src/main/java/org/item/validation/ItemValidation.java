package org.item.validation;

import org.item.models.ItemModel;
import java.util.ArrayList;
import java.util.List;
public class ItemValidation {

    private static final String ENGLISH_NAME_REGEX = "^(?=.*[A-Za-z])[A-Za-z0-9 ]+$";

    public static List<String> validateItem(String name, String priceStr) {

        List<String> errors = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            errors.add("Name is required");
        } else if (name.trim().length() < 2) {
            errors.add("Name must be at least 2 characters");
        } else if (!name.matches(ENGLISH_NAME_REGEX)) {
            errors.add("Name must contain English letters only");
        }

        if (priceStr == null || priceStr.trim().isEmpty()) {
            errors.add("Price is required");
        } else {
            try {
                double price = Double.parseDouble(priceStr);
                if (price <= 0) {
                    errors.add("Price must be greater than 0");
                }
            } catch (NumberFormatException e) {
                errors.add("Price must be a valid number");
            }
        }

        return errors;
    }
}