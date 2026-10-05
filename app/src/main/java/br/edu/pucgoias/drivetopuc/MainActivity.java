package br.edu.pucgoias.drivetopuc;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.pucgoias.drivetopuc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configureListeners();
    }

    private void configureListeners() {

        binding.btnLogin.setOnClickListener(v -> {
            validateLogin();
        });

        binding.btnRegister.setOnClickListener(v -> {
            Toast.makeText(
                    this,
                    "Tela de cadastro em desenvolvimento",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }

    private void validateLogin() {

        String email = binding.etEmail.getText().toString().trim();
        String password = binding.etPassword.getText().toString();

        binding.tilEmail.setError(null);
        binding.tilPassword.setError(null);

        if (email.isEmpty()) {
            binding.tilEmail.setError("Informe seu e-mail");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.setError("Informe um e-mail válido");
            return;
        }

        if (password.isEmpty()) {
            binding.tilPassword.setError("Informe sua senha");
            return;
        }

        if (password.length() < 6) {
            binding.tilPassword.setError("A senha deve possuir pelo menos 6 caracteres");
            return;
        }

        Toast.makeText(
                this,
                "Dados válidos. Autenticação será implementada posteriormente.",
                Toast.LENGTH_SHORT
        ).show();
    }
}