package com.example.apka123;

import androidx.lifecycle.ViewModel;

public class PunktyViewModel extends ViewModel{
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int i){
        this.points+=i;
    }
}

