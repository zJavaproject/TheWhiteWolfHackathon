package com.example.mindcare;

public class Mood {
    String name;
    int intensity;
    int valueX, valueY;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public Mood(String name, int intensity, int valueX, int valueY) {
        this.name = name;
        this.intensity = intensity;
        this.valueX = valueX;
        this.valueY = valueY;
    }

    public int getValueX() { return valueX; }
    public int getValueY() { return valueY; }
}
