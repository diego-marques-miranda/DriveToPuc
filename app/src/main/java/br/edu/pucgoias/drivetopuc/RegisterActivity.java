package br.edu.pucgoias.drivetopuc;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

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

        binding.btnCreateAccount.setOnClickListener(v -> {
            validateRegistration();
        });

        binding.btnBackToLogin.setOnClickListener(v -> {
            finish();
        });
    }

    private void validateRegistration() {

        String name = binding.etName.getText().toString().trim();
        String email = binding.etRegisterEmail.getText().toString().trim();
        String password = binding.etRegisterPassword.getText().toString();
        String confirmPassword = binding.etConfirmPassword.getText().toString();

        clearErrors();

        if (name.isEmpty()) {
            binding.tilName.setError("Informe seu nome completo");
            return;
        }

        if (email.isEmpty()) {
            binding.tilRegisterEmail.setError("Informe seu e-mail");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilRegisterEmail.setError("Informe um e-mail válido");
            return;
        }

        if (password.isEmpty()) {
            binding.tilRegisterPassword.setError("Informe sua senha");
            return;
        }

        if (password.length() < 6) {
            binding.tilRegisterPassword.setError(
                    "A senha deve possuir pelo menos 6 caracteres"
            );
            return;
        }

        if (confirmPassword.isEmpty()) {
            binding.tilConfirmPassword.setError(
                    "Confirme sua senha"
            );
            return;
        }

        if (!password.equals(confirmPassword)) {
            binding.tilConfirmPassword.setError(
                    "As senhas não coincidem"
            );
            return;
        }

        if (binding.rgProfileType.getCheckedRadioButtonId() == -1) {
            Toast.makeText(
                    this,
                    "Selecione o tipo de usuário",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        int selectedProfileId = binding.rgProfileType.getCheckedRadioButtonId();

        String profile;

        if (selectedProfileId == binding.rbDriver.getId()) {
            profile = "MOTORISTA";
        } else {
            profile = "PASSAGEIRO";
        }

        Toast.makeText(
                this,
                "Cadastro válido: " + profile,
                Toast.LENGTH_SHORT
        ).show();
    }

    private void clearErrors() {

        binding.tilName.setError(null);
        binding.tilRegisterEmail.setError(null);
        binding.tilRegisterPassword.setError(null);
        binding.tilConfirmPassword.setError(null);
    }
}