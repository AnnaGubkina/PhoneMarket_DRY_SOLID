import java.util.List;
import java.util.Scanner;

public class Summator implements CatalogSum {
    // выбираем товары и считаем сумму и количество
    @Override
    public void Sum(List<Catalog> list) {
        Scanner scan = new Scanner(System.in);
        int currentPrice = 0;
        int sumProducts = 0;
        int[] countProducts = new int[list.size()];
        while (true) {
            String input = scan.nextLine();
            if (input.equals("end")) {
                basketView(countProducts, list, sumProducts);
                break;
            }
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            currentPrice = list.get(productNumber).getPrice() * productCount;
            sumProducts += currentPrice;
            countProducts[productNumber] += productCount;
        }
    }

    //показ товаров в корзине, их количество и сумма
    @Override
    public void basketView(int[] countProducts, List<Catalog> phoneList, int sumProducts) {

        System.out.println("Ваша корзина:\nНаименование товара | Кол-во | Цена/за.ед | Общая стоимость");
        for (int i = 0; i < countProducts.length; ++i)
            if (countProducts[i] != 0)
                System.out.println(phoneList.get(i).getModel() + "\t\t\t\t\t" + countProducts[i] + "\t\t\t"
                        + phoneList.get(i).getPrice() + "\t\t\t\t" + phoneList.get(i).getPrice() * countProducts[i]);

        System.out.print("Сумма товаров: " + sumProducts);
    }
}


