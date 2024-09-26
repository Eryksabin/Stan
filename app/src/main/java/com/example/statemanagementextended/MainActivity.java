package com.example.statemanagementextended;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "count"; // Klucz do przechowywania danych w Bundle
    private TextView textViewCount; // Element widoku do wyświetlania liczby
    private int count = 0; // Zmienna do przechowywania wartości licznika
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCount = findViewById(R.id.textViewCount); // Inicjalizacja TextView
        Button buttonIncrement = findViewById(R.id.buttonIncrement); // Inicjalizacja Button
        // Odczyt danych ze stanu, jeśli istnieje
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT); // Przywróć wartość licznika
        }
        updateCountText(); // Aktualizuj widok TextView
        // Ustawienie akcji kliknięcia przycisku
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++; // Zwiększ wartość licznika
                updateCountText(); // Aktualizuj widok TextView
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count); // Zapisz aktualny stan licznika do Bundle
    }
    private void updateCountText() {
        textViewCount.setText("Licznik: " + count); // Ustaw tekst TextView na aktualną wartość licznika

    }
}
