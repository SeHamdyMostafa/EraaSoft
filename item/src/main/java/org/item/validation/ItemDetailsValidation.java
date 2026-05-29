package org.item.validation;

import org.item.models.item_details;

import java.util.ArrayList;
import java.util.List;

public class ItemDetailsValidation {

    public static List<String> validateItem(item_details itemDetails) {

        List<String> errors = new ArrayList<>();

        if (itemDetails.getDescription() == null || itemDetails.getDescription().trim().isEmpty()) {
            errors.add("Description is required");
        }
        else if (itemDetails.getDescription().length() < 3) {
            errors.add("Description must be at least 3 characters");
        }

        if (itemDetails.getColor() == null || itemDetails.getColor().trim().isEmpty()) {
            errors.add("Color is required");
        }
        if (itemDetails.getWeight() == null || itemDetails.getWeight().trim().isEmpty()) {
            errors.add("Weight is required");
        }
        return errors;
    }
}