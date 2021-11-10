import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public void filterPrice(List<Catalog> list, int price) {
        list.stream()
                .filter(n-> n.getPrice() < price)
                . forEach(System.out::println);
    }

    public void filterBrand(List<Catalog> list, String name) {
        list.stream()
                .filter(p-> p.getModel().contains(name))
                .forEach(System.out::println);

    }
}
