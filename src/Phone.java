public class Phone extends Catalog implements Clock, MusicPlayer, SmsSendler {

    String model;
    int price;
    double rating;


    public double getRating() {
        return rating;
    }

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

    public String toString() {
        return "Phone " +
                "model " + getModel() + '\'' +
                "price " + getPrice() + '\'' +
                "rating " + getRating() + '\'';
    }

    @Override
    public void setAlarm(String time) {
    }

    @Override
    public void playMusic(String query) {
    }

    @Override
    public void sendSMS(String msg, String number) {
    }
}
