import java.util.HashMap;


public class Catalog {
        private final HashMap<Integer, Category> categories = new HashMap<>();
        private int categorySequence = 1;
        private int itemSequence = 1;

        public int getCurrentItemSequence() { return itemSequence; }

        public void incrementItemSequence() { itemSequence++;}

        public int getCurrentCategorySequence() {
                return categorySequence;
        }

        public void incrementCategorySequence() {
                categorySequence++;
        }

        public int getCatalogSize() {
                return categories.size();
        }

        public HashMap<Integer, Category> getCategories() {
                return categories;
        }
}
