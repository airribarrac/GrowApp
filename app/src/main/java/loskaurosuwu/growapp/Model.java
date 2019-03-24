package loskaurosuwu.growapp;

import java.util.ArrayList;

public class Model {

    private int image;
    private String title;
    private String desc;
    private ArrayList<Integer> valores;

    public Model(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public ArrayList<Integer> getValores(){
        return valores;
    }
    public void setValor(int valor){
        valores.add(valor);
    }

}
