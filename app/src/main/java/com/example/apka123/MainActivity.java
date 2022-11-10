package com.example.apka123;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.apka123.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int points = 0;
    PunktyViewModel punktyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        punktyViewModel = new ViewModelProvider(this).get(PunktyViewModel.class);

        punktyViewModel.getPoints().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        binding.points.setText(String.valueOf(integer));
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
    }
}