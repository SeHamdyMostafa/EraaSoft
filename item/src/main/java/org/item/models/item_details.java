package org.item.models;

public class item_details {

    private int id;
    private int itemId;
    private String description;
    private String color;
    private String weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "item_details{" +
                "id=" + id +
                "itemId=" + itemId +
                "description=" + description +'\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +'\'' +
                '}';
    }


}
