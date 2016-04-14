package cr.ac.itcr.ict_go.Entity;

import java.io.Serializable;

/**
 * Created by car_e on 4/12/2016.
 */
public class Animal implements Serializable {
    private int id;
    private String name;
    private String scientificName;
    private String description;
    private String idImg;


    public Animal(int id, String n, String sn, String d, String img){
        this.id = id;
        this.name = n;
        this.scientificName = sn;
        this.description = d;
        this.idImg = img;
    }
    public Animal(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdImg() {
        return idImg;
    }

    public void setIdImg(String idImg) {
        this.idImg = idImg;
    }
}
