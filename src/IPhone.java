public class IPhone extends Phone{

    String model;
    int price;
    double rating;

    public IPhone(String model, int price, double rating) {
        this.model = model;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
