import java.util.HashMap;

public class Category {
        private int categoryID;
        private String categoryName;
        private final HashMap<Integer, Item> items = new HashMap<>();

        Category(int number, String name) {
                this.categoryID = number;
                this.categoryName = name;
        }

        public int getCategoryID() {
                return categoryID;
        }

        public String getCategoryName() {
                return categoryName;
        }

        public void setCategoryID(int categoryID) {
                this.categoryID = categoryID;
        }

        public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
        }

        public HashMap<Integer, Item> getItems() {
                return items;
        }

        public void addItem(int itemID, int categoryID, String name, String measure, int price, int count) {
                items.put(itemID, new Item(itemID,categoryID,name,measure,price,count));
        }

        public int getItemCategoryID(int categoryID) {
                return items.get(categoryID).getCategoryID();
        }

        public int getItemID(int categoryID) {
                return items.get(categoryID).getItemID();
        }

        public String getItemName(int categoryID) {
                return items.get(categoryID).getItemName();
        }

        public String getItemMeasure(int categoryID) {
                return items.get(categoryID).getMeasure();
        }

        public int getItemPrice(int categoryID) {
                return items.get(categoryID).getPrice();
        }

        public int getItemCount(int categoryID) {
                return items.get(categoryID).getCount();
        }

        public class Item {
                private int categoryID;
                private int itemID;
                private String itemName;
                private String measure;
                private int price;
                private int count;

                Item(int itemID, int categoryID, String name, String measure, int price, int count) {
                        this.itemID = itemID;
                        this.categoryID = categoryID;
                        this.itemName = name;
                        this.measure = measure;
                        this.price = price;
                        this.count = count;
                }

                public void setCount(int count) {
                        this.count = count;
                }

                public int getCount() {
                        return count;
                }

                public void setMeasure(String measure) {
                        this.measure = measure;
                }

                public void setPrice(int price) {
                        this.price = price;
                }

                public String getMeasure() {
                        return measure;
                }

                public int getPrice() {
                        return price;
                }

                public int getItemID() {
                        return itemID;
                }

                public String getItemName() {
                        return itemName;
                }

                public void setItemID(int itemID) {
                        this.itemID = itemID;
                }

                public void setItemName(String itemName) {
                        this.itemName = itemName;
                }

                public int getCategoryID() {
                        return categoryID;
                }

                public void setCategoryID(int categoryID) {
                        this.categoryID = categoryID;
                }
        }
}
