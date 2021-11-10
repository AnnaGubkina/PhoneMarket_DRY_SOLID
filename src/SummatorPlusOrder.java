import java.util.List;
import java.util.Scanner;

public class SummatorPlusOrder extends Summator {

    @Override
    public void Sum(List<Catalog> phoneList) {
        super.Sum(phoneList);
    }

    @Override
    public void basketView(int[] countProducts, List<Catalog> list, int sumProducts) {
        super.basketView(countProducts, list, sumProducts);
        System.out.println();
        goToOrder(list);
    }

    public void goToOrder(List<Catalog> phoneList) {
        System.out.println("Нажмите '1' чтобы перейти к оформлению заказа");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            System.out.println("Страница оформления заказа: ... " +
                    "\n Введите данные карты ...");
            //TODO
        } else {
            Main.menuSite(phoneList);
        }
    }
}
