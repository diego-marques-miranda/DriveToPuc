package br.edu.pucgoias.drivetopuc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.pucgoias.drivetopuc.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configureListeners();
    }

    private void configureListeners() {

        binding.btnBackToLogin.setOnClickListener(v -> {
            finish();
        });
    }
}