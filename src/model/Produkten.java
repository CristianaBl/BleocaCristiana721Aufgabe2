package model;

public class Produkten implements HasID{
    private int id;
    private String name;
    private int price;
    private String Universum;

    /**
     * Constructor for the Produkt class
     * @param name,the name of the produkt
     * @param price, the price of the produkt
     */
    public Produkten(Integer id, String name, int price, String universum) {
        this.name = name;
        this.price = price;
        this.Universum = universum;
        this.id = id;
    }


    /**
     *
     * @return the price
     */

    @Override
    public Integer getId() {
        return id;
    }
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getUniversum() {
        return Universum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniversum(String universum) {
        this.Universum = universum;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return a representation of a product ,as a String concatenation
     */
    @Override
    public String toString() {
        return
                "name=" + name  +
                ", price=" + price +
                ", jahreszeit=" + Universum;

    }

}
