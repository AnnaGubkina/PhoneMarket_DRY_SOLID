import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Применение dry и solid в программе.
DRY
1. принцип DRY применился в классе Main, в методе  menuSite
теперь мы можем создать другой список, с абсолютно другим каталогом телефонов или ноутбуков. передать новый лист в наш метод и он будет работать точно также, как работал с первым списком.
DRY также применяем в методе menuFilter. если мы захотим отфильтровать другой каталог товаров, то также можем его добавить в этот метод.

SOLID

1. Single-responsibility principle применяется , например , в классе Filter. у него есть своя отдельная функция - фильтровать товары по каким то признакам. и только это.
а сами товары имеют свои классы, где описываются уже характеристики именно данного товара. это тоже single-responsibility principle.

2. Open-closed principle применился , при создании класса  SummatorFlusOrder, который расширяет класс Summator.
например мы хотим , чтобы после вывода корзины на экран в некоторых случаях показывалась возможность
перехода к странице оформления и оплаты заказа.
Для этого в новом классе добавлен дополнительные метод goToOrder. Мы можем также добавить туда еще методы, если нужны какие то дополнения к нашему сумматору.

3. Liskov substitution principle также применили в классах SummatorPlusOrder, который расширяет класс Summator. при этом наш наследник выполняет все те же функции , что и родитель и вполне может его заменить.

4. Interface segregation principle применяется в классе phone, который имплиментирует 3 разных интерфейса, которые применимы к мобильным телефонам. а класс Laptop имплиментирует
только те интерфейсы, которые относятся к ноутбукам.

5. Dependency inversion principle применяется в классе main , в методе  menuSite.
Oбъект Summator summator = new SummatorPlusOrder(); в данном случае мы можем также сделать через интерфейс CatalogSum summator = new SummatorPlusOrder(); и тогда у нас  модули сумматора будут доступны только через
абстракцию, а именно через интерфейс CatalogSum.
 */

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(" << Phone and Laptop market >>");
        System.out.println();
        List<Catalog> phoneList = new ArrayList<>();
        phoneList.add(new Huawei("Huawei P40", 69000, 3.3));
        phoneList.add(new IPhone("IPhone 13", 100000, 4.8));
        phoneList.add(new IPhone("IPhone 10", 35000, 4.1));
        phoneList.add(new Samsung("Samsung Galaxy S21", 98000, 4.9));
        phoneList.add(new Samsung("Samsung A32", 21000, 3.9));
        phoneList.add(new Xiaomi("Xiaomi 11T pro", 56000, 4.5));

        List<Catalog> laptopList = new ArrayList<>();
        laptopList.add(new MacBook("MacBook Air", 140000));
        laptopList.add(new Acer("Acer Swift", 51000));

        menuWelcome(phoneList,laptopList);


    }

        public static void menuWelcome (List<Catalog> phoneList ,List<Catalog> laptopList ) {
            System.out.println("Выберите раздел " +
                    "\n 1.Телефоны " +
                    "\n 2.Ноутбуки");
            int input = scanner.nextInt();
            if (!(input == 1 || input == 2)) {
                System.out.println("Неверный пункт меню");
            } else if (input == 1) {
                menuSite(phoneList);
            } else {
                menuSite(laptopList);
            }
        }

        public static void menuSite (List < Catalog > list) {
            System.out.println("Меню" +
                    "\n 1. Каталог " +
                    "\n 2. Фильтр");
            int menuChoice = scanner.nextInt();
            if (!(menuChoice == 1 || menuChoice == 2)) {
                System.out.println("Неверный пункт меню");
                menuSite(list);
            }
            if (menuChoice == 1) {
                menuCatalog(list);
                Summator summator = new SummatorPlusOrder();
                summator.Sum(list);
            } else if (menuChoice == 2) {
                menuFilter(list);
            }
        }

        public static void menuFilter (List < Catalog > list) {
            System.out.println("Отфильтровать " +
                    "\n 1. по цене" +
                    "\n 2. по марке или модели");
            int filter = scanner.nextInt();
            if (filter == 1) {
                System.out.println("Введите максимальную цену");
                int maxPrice = scanner.nextInt();
                Filter price = new Filter();
                price.filterPrice(list, maxPrice);
            } else if (filter == 2) {
                System.out.println("Введите марку или название модели");
                Scanner console = new Scanner(System.in);
                String modelPhone = console.nextLine();
                if (!modelPhone.isEmpty()) {
                    Filter modelName = new Filter();
                    modelName.filterBrand(list, modelPhone);
                }
            }
        }

        // метод выбора товаров
        public static void menuCatalog (List < Catalog > phoneList) {
            System.out.println("Выберите модель,количество или нажмите 'end' для выхода");
            System.out.println("Список товаров для покупки: ");
            for (int i = 0; i < phoneList.size(); i++) {
                System.out.println(i + 1 + ". " + phoneList.get(i).getModel() + " цена " + phoneList.get(i).getPrice());
            }
        }
    }