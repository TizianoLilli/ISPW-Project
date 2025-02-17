package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.Color;

public class ColorBean {

    private int gid;

    private Color color;
    private boolean matteFinish;

    public ColorBean(Color color, boolean matteFinish) {
        this.color = color;
        this.matteFinish = matteFinish;
    }

    public void setColor(Color c) {
        this.color = c;
    }
    public Color getColor() {return color;}

    public void setMatteFinish(boolean matteFinish) {this.matteFinish = matteFinish;}
    public boolean getMatteFinish() {return matteFinish;}

    public int getGuitarId() {return gid;}
    public void setGuitarId(int guitarId) {this.gid = guitarId;}
}
