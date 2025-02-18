package org.example.ispwprogect.utils.bean;

import java.util.HashMap;

public class AddonsBean {

    private int id;
    private HashMap<String, Integer> stickerMap;
    private boolean[][] colorArray;

    public AddonsBean(HashMap<String, Integer> stickers, boolean[][] colors) {
        this.stickerMap = stickers;
        this.colorArray = colors;
    }

    public int getId() {return id;}

    public HashMap<String, Integer> getStickerMap() {return stickerMap;}

    public boolean[][] getColorArray() {return colorArray;}
}
