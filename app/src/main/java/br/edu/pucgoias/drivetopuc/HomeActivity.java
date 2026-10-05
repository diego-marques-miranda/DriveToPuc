package br.edu.pucgoias.drivetopuc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.pucgoias.drivetopuc.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}