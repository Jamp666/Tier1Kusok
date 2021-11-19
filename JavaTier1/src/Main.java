import java.io.IOException;

public class Main {
        public static void main(String[] args) throws IOException {
                Catalog catalog = new Catalog();
                CatalogView view = new CatalogView();
                Controller controller = new Controller(catalog, view);
                controller.init();
        }
        /*
        Остановился на добавлении позиции 18.10.21
        Все х...ня переделать под норм MVC ыа 18.10.21
        Item 09.11.21
         */
}
