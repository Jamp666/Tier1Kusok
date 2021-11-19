import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

public class Controller {
        private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private final Catalog catalog;
        private final CatalogView view;
        private State state;
        private int currentCategoryId;

        Controller(Catalog catalog, CatalogView view) {
                this.catalog = catalog;
                this.view = view;
        }

        public void init() throws IOException {
                state = State.CATALOG;
                showCommandList();
        }

        public void showCommandList() throws IOException {
                if (state == State.CATEGORY) {
                        view.printCurrentCategory(catalog.getCategories().get(currentCategoryId).getCategoryName());
                }
                view.printCommands(state);
                enterCommand();
        }

        public void enterCommand() throws IOException {
                view.printEnterCommandMsg();
                switch (state) {
                        case CATALOG:
                                switch (reader.readLine()) {
                                        case "add":
                                                addCategory();
                                                break;
                                        case "list":
                                                showCategories();
                                                enterCommand();
                                                break;
                                        case "help":
                                                showCommandList();
                                                break;
                                        case "delete":
                                                deleteCategory();
                                                break;
                                        case "listall":
                                                showCategories();
                                                break;
                                        case "select":
                                                selectCategory();
                                                break;
                                        default:
                                                view.printWrongCommandMsg();
                                                enterCommand();
                                                break;
                                }
                                break;
                        case CATEGORY:
                                switch (reader.readLine()) {
                                        case "add":
                                                addItem();
                                                break;
                                        case "list":
                                        showItems();
                                                break;
                                        case "help":
                                                showCommandList();
                                                break;
                                        case "delete":
//                                        deleteItem();
                                                break;
                                        case "listall":
//                                        showItems();
                                                break;
                                        case "exit":
                                        exitItemMode();
                                                break;
                                        default:
                                                view.printWrongCommandMsg();
                                                enterCommand();
                                                break;
                                }
                                break;
                }
        }

        private void selectCategory() throws IOException {
                if (catalog.getCatalogSize() == 0) {
                        view.printEmptyCatalogMsg();
                } else {
                        view.printEnterNameOrExitMsg();
                        showCategories();
                        String name = reader.readLine();
                        if (name.equals("exit")) {
                                view.printSelectionCanceledMsg();
                        } else {
                                for (Map.Entry<Integer, Category> entry : catalog.getCategories().entrySet()) {
                                        if (entry.getValue().getCategoryName().equals(name)) {
                                                setState(State.CATEGORY);
                                                setCurrentCategoryId(entry.getKey());
                                                showCommandList();
                                                break;
                                        } else {
                                                view.printCategoryNotFoundMsg();
                                        }
                                }
                        }
                }
                enterCommand();
        }

        private void exitItemMode() throws IOException {
                setState(State.CATALOG);
                showCommandList();
                enterCommand();
        }

        private void showItems() {
                for (Map.Entry<Integer, Category.Item> entry : catalog.getCategories().get(currentCategoryId).getItems().entrySet()) {
                        if (entry.getValue().getCategoryID()==currentCategoryId) {
                                System.out.println(
                                        entry.getValue().getItemID() + " " +
                                        entry.getValue().getItemName() + " " +
                                        entry.getValue().getCount() + " " +
                                        entry.getValue().getMeasure() + " " +
                                        entry.getValue().getPrice());
                        }
                }

        }

        private void addItem() throws IOException {
                view.printAddItemNameMsg();
                String itemName = reader.readLine();
                if (itemName.length() > 255) {
                        view.printLongNameError();
                        addItem();
                }
                view.printAddItemMeasureMsg();
                String itemMeasure = reader.readLine();
                view.printAddItemPriceMsg();
                int itemPrice = Integer.parseInt(reader.readLine());
                view.printAddItemСountMsg();
                int itemCount = Integer.parseInt(reader.readLine());
                System.out.println(itemName + " " + itemMeasure + " " + itemPrice + " " + itemCount);
                catalog.getCategories().get(currentCategoryId).addItem(catalog.getCurrentItemSequence(), getCurrentCategoryId(), itemName, itemMeasure, itemPrice, itemCount);
                catalog.incrementItemSequence();
                enterCommand();
        }

        private void addCategory() throws IOException {
                view.printAddCategoryMsg();
                String categoryName = reader.readLine();
                if (categoryName.length() > 255) {
                        view.printLongNameError();
                        addCategory();
                } else if (categoryName.equals("exit")) {
                        view.printAddCanceledMsg();
                } else if (categoryDuplicateCheck(categoryName)) {
                        view.printDoubleNameError();
                        addCategory();
                } else {
                        int sequence = catalog.getCurrentCategorySequence();
                        catalog.getCategories().put(sequence, new Category(sequence,categoryName));
                        view.printCategoryAddedMsg(catalog.getCategories().get(sequence).getCategoryName());
                        catalog.incrementCategorySequence();
                }
                enterCommand();
        }

        private void deleteCategory() throws IOException {
                if (catalog.getCatalogSize() <= 1) {
                        view.printCannotDeleteError();
                } else {
                        view.printEnterNameOrExitMsg();
                        showCategories();
                        String name = reader.readLine();
                        if (name.equals("exit")) {
                                view.printDeleteCanceledMsg();
                        } else {
                                boolean isDeleted = false;
                                for (Map.Entry<Integer, Category> entry : catalog.getCategories().entrySet()) {
                                        if (entry.getValue().getCategoryName().equals(name)) {
                                                view.printCategoryDeletedMsg(entry.getValue().getCategoryName());
                                                catalog.getCategories().remove((entry).getKey());
                                                isDeleted = true;
                                                break;
                                        }
                                }
                                if (!isDeleted) {
                                        view.printCategoryNotFoundMsg();
                                }
                        }
                }
                enterCommand();
        }

        private void showCategories() {
                if (catalog.getCategories().size() == 0) {
                        view.printEmptyListMsg();
                } else {
                        view.printCategoryListMsg();
                        view.printDots();
                        catalog.getCategories().forEach((k,v) ->  view.printCategory(k, v.getCategoryName()));
                        view.printDots();
                }
        }

        private boolean categoryDuplicateCheck(String name) {
                boolean isDuplicate = false;
                for (Map.Entry<Integer, Category> entry : catalog.getCategories().entrySet()) {
                        if (entry.getValue().getCategoryName().equals(name)) {
                                isDuplicate = true;
                                break;
                        }
                }
                return isDuplicate;
        }

        public void setState(State state) {
                this.state = state;
        }

        public void setCurrentCategoryId(int currentCategoryId) {
                this.currentCategoryId = currentCategoryId;
        }

        public int getCurrentCategoryId() {
                return currentCategoryId;
        }
}
