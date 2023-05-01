package com.example.ejerciciomovilesandreso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.example.ejerciciomovilesandreso.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setTheme(R.style.Theme_EjercicioMovilesAndresO);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.usernameField.getText().toString();
                String password = binding.passwordField.getText().toString();

                if (username.equals("Admin") && password.equals("123")) {
                    if (!binding.agreementCheckbox.isChecked()) {
                        // Mostrar mensaje de error si el CheckBox no está seleccionado
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Error");
                        builder.setMessage("No puede continuar sin aceptar los acuerdos, inténtalo otra vez.");
                        builder.setPositiveButton("Aceptar", null);
                        builder.show();
                        // Limpiar campos de usuario y contraseña
                        binding.usernameField.setText("");
                        binding.passwordField.setText("");
                        return;
                    }
                    else {
                        abrir();
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Error");
                    builder.setMessage("Usuario o contraseña incorrectos");
                    builder.setPositiveButton("Aceptar", null);
                    builder.show();
                    binding.usernameField.setText("");
                    binding.passwordField.setText("");
                }
            }
        });
    }

    public void abrir (){
        Intent open = new Intent(this, menu_principal.class);
        startActivity(open);
    }
}