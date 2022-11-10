package com.example.apka123;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.apka123.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    PunktyViewModel punktyViewModel;
    Team2Points team2Points;
    private SharedPreferences pointsShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        pointsShared = getPreferences(MODE_PRIVATE);

        punktyViewModel = new ViewModelProvider(this).get(PunktyViewModel.class);

        team2Points = new ViewModelProvider(this).get(Team2Points.class);

        loadPoints();

        punktyViewModel.getPoints().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        binding.points.setText(String.valueOf(integer));
                    }
                }
        );
        team2Points.getPoints().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        binding.points2.setText(String.valueOf(integer));
                    }
                }
        );

        //dzięki bindowaniu widoków nie musimy używać findviewbyid
        binding.button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punktyViewModel.addPoints(1);
                    }
                }
        );
        binding.button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punktyViewModel.addPoints(2);
                    }
                }
        );
        binding.button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punktyViewModel.addPoints(3);
                    }
                }
        );
        binding.button4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        team2Points.addPoints(1);
                    }
                }
        );
        binding.button5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        team2Points.addPoints(2);
                    }
                }
        );
        binding.button6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        team2Points.addPoints(3);
                    }
                }
        );
    }

    @Override
    protected void onPause(){
        super.onPause();
        savePoints();
    }
    private void savePoints(){
        SharedPreferences.Editor editor = pointsShared.edit(); //włącza edytowanie
        editor.putInt("Points1", punktyViewModel.getPoints().getValue() );
        editor.putInt("Points2", team2Points.getPoints().getValue());
        editor.apply(); //zatwierdza edycje
    }
    private void loadPoints(){
        int p = pointsShared.getInt("Points1",0);
        punktyViewModel.setPoints(p);
        int p2 = pointsShared.getInt("Points2",0);
        team2Points.setPoints(p2);
    }
}