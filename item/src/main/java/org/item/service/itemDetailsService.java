package org.item.service;

import org.item.models.ItemModel;
import org.item.models.item_details;
import org.item.repo.itemDetailsRepo;
import org.item.validation.ItemDetailsValidation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class itemDetailsService {

    private final itemDetailsRepo itemdetailsrepo=new itemDetailsRepo();

    public List<String> addItemDetails(item_details itemDetails){

        List<String> errors= ItemDetailsValidation.validateItem(itemDetails);
        if(!errors.isEmpty()){
            return errors;
        }
         boolean added = itemdetailsrepo.addItemDetails(itemDetails);
        if(!added){
            ArrayList<String> addedErrors =new ArrayList<>();
            addedErrors.add("Added failed");
            return addedErrors;
        }
        return Collections.emptyList();

    }

    public List<item_details> getItemDetails(){
        return itemdetailsrepo.getItemDetails();
    }

    public item_details getItemDetailsById(int id){
        return itemdetailsrepo.getItemDetailsById(id);
    }
    
    public List<String> updateItemDetails(int item_id ,item_details itemDetails){
        List<String> errors=ItemDetailsValidation.validateItem(itemDetails);
        if(!errors.isEmpty()){
            return errors;
        }
       boolean updated=itemdetailsrepo.updateItemDetails(item_id,itemDetails);
        if (!updated) {
            List<String> updateErrors = new ArrayList<>();
            updateErrors.add("Update failed or item not found");
            return updateErrors;
        }
        return Collections.emptyList();
    }
    
    public List<String> deleteItemDetails(int id){
        boolean deleted=itemdetailsrepo.deleteItemDetails(id);
        if(!deleted){
            List<String> deletedErrors=new ArrayList<>();
            deletedErrors.add("Delete failed or item not found");
            return deletedErrors;
        }
        return Collections.emptyList();
    }

    public boolean hasItemDetails(int itemId) {
        return itemdetailsrepo.existsByItemId(itemId);
    }

}
