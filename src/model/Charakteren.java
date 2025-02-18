package model;

import java.util.List;


public class Charakteren implements HasID {

    private Integer id;
    private String name;
    private String ort;
    List<Produkten> orederdProducts;

    /**
     *
     * @param id
     * @param name
     * @param ort
     * @param orederdProducts
     */
    public Charakteren(Integer id, String name, String ort, List<Produkten> orederdProducts) {
        this.id = id;
        this.name = name;
        this.ort = ort;
        this.orederdProducts = orederdProducts;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public List<Produkten> getOrederdProducts() {
        return orederdProducts;
    }

    public void setOrederdProducts(List<Produkten> orederdProducts) {
        this.orederdProducts = orederdProducts;
    }

    @Override
    public String toString() {
        return "id: "+ id + " " + name + " " + ort + " " + orederdProducts;
    }
}
