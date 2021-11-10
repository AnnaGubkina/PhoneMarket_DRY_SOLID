public class Laptop extends Catalog implements MusicPlayer, SmartTV {

    String model;
    int price;

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
        return   "model " + getModel() + '\'' +
                 "price " + getPrice() + '\'';
    }


    @Override
    public void playMusic(String query) {

    }

    @Override
    public void ShowSmartTv(Object player) {

    }
}
