package com.howtodoinjava.app.model;

public class Photo {

    private String name;
    private String l; // TODO: refactoring name of variable
    private String a;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        if (l != null) {
            this.l = l.replace(",", ".");
        } else {
            this.l = null;
        }
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        if (a != null) {
            this.a = a.replace(",", ".");
        } else {
            this.a = null;
        }
    }
}
