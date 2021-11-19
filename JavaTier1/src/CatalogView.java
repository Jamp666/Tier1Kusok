import static java.lang.System.out;

public class CatalogView {
        public void printCommands(State state){
                switch (state) {
                case CATALOG:
                        out.println("Список команд каталога:");
                        out.println("add - добавление категории");
                        out.println("delete - удаление категории");
                        out.println("list - Просмотр категорий в каталоге");
                        out.println("listall - полного списка категорий и позиций в каталоге");
                        out.println("select - выбрать категорию");
                        out.println("help - список комманд");
                        out.println(" ");
                        break;
                case CATEGORY:
                        System.out.println("Список команд категории:");
                        System.out.println("add - добавление товара");
                        System.out.println("delete - удаление товара");
                        System.out.println("list - Просмотр товаров в категории");
                        System.out.println("listall - полного списка товаров и позиций в категории");
                        System.out.println("back - назад в меню каталога");
                        System.out.println("help - список комманд");
                        System.out.println(" ");
                        break;
                }
        }

        public void printEnterCommandMsg() {
                System.out.println("Введите команду");
        }

        public void printWrongCommandMsg() {
                System.out.println("Неверная команда");
        }

        public void printAddItemNameMsg() {
                System.out.println("Введите наименование товара");
        }

        public void printAddItemMeasureMsg() {
                System.out.println("Введите единицу измерения товара");
        }

        public void printAddItemPriceMsg() {
                System.out.println("Введите цену товара");
        }

        public void printAddItemСountMsg() {
                System.out.println("Введите количество товара");
        }

        public void printLongNameError() {
                System.out.println("Слишком длинное название");
        }

        public void printAddCategoryMsg() {
                System.out.println("Введите наименование категории либо exit для отмены добавления");
        }

        public void printDoubleNameError() {
                System.out.println("Категория с таким названием уже существует");
        }

        public void printCannotDeleteError() {
                System.out.println("Удаление невозможно");
        }

        public void printEnterNameOrExitMsg() {
                System.out.println("Введите намиенование либо exit для отмены");
        }

        public void printEmptyCatalogMsg() {
                System.out.println("Каталог пуст");
        }

        public void printEmptyListMsg() {
                System.out.println("Список пуст");
        }

        public void printCategoryListMsg() {
                System.out.println("Список категорий:");
        }

        public void printDots() {
                System.out.println("------------------");
        }

        public void printAddCanceledMsg() {
                System.out.println("Добавление отменено");
        }

        public void printCategoryAddedMsg(String name) {
                System.out.println("Категория " + name + " добавлена");
        }

        public void printCategoryDeletedMsg(String name) {
                System.out.println("Категория " + name + " удалена");
        }

        public void printDeleteCanceledMsg() {
                System.out.println("Удаление отменено");
        }

        public void printCategoryNotFoundMsg() {
                System.out.println("Категория не найдена");
        }

        public void printCategory(int num, String name) {
                out.println(num + " " + name);
        }

        public void printCurrentCategory(String categoryName) {
                out.println("Выбрана категория: " + categoryName);
        }

        public void printSelectionCanceledMsg() {
                out.println("Выбор отменен");
        }
}
