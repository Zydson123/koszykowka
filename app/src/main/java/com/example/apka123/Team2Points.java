package com.example.apka123;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Team2Points extends ViewModel {
    private MutableLiveData<Integer> points = new MutableLiveData<>();

    public MutableLiveData<Integer> getPoints() {
        if(points==null){
            points = new MutableLiveData<>();
            points.setValue(0);
        }
        return points;
    }

    public void setPoints(int p) {
        this.points.setValue(p);
    }

    public void addPoints(int p){
        if(points.getValue()!=null){
            this.points.setValue(points.getValue()+p);
        }
    }
}
