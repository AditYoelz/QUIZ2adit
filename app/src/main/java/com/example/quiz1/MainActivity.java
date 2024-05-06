package com.example.quiz1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final static int RADIO_BUTTON_NASI_GORENG = 1;
    private final static int RADIO_BUTTON_MIE_GORENG = 2;
    private final static int RADIO_BUTTON_MIE_REBUS = 3;
    private final static int RADIO_BUTTON_TEH_ES = 4;
    private final static int RADIO_BUTTON_ES_JERUK = 5;

    private RadioGroup radioGroupMakanan;
    private RadioGroup radioGroupMinuman;
    private EditText editTextJumlahPorsi;
    private Button buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupMakanan = findViewById(R.id.radioGroupFood);
        radioGroupMinuman = findViewById(R.id.radioGroupDrink);
        editTextJumlahPorsi = findViewById(R.id.editTextJumlahPorsi);
        buttonHitung = findViewById(R.id.buttonHitungTotal);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungTotal();
            }
        });
    }

    private void hitungTotal() {
        int selectedMakananId = radioGroupMakanan.getCheckedRadioButtonId();
        int selectedMinumanId = radioGroupMinuman.getCheckedRadioButtonId();
        String jumlahPorsiStr = editTextJumlahPorsi.getText().toString();

        if (selectedMakananId == -1 || selectedMinumanId == -1 || jumlahPorsiStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Harap lengkapi semua pilihan", Toast.LENGTH_SHORT).show();
            return;
        }

        int hargaMakanan = getHargaMakanan(selectedMakananId);
        int hargaMinuman = getHargaMinuman(selectedMinumanId);
        int jumlahPorsi = Integer.parseInt(jumlahPorsiStr);
        int totalHarga = (hargaMakanan + hargaMinuman) * jumlahPorsi;

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("total_harga", totalHarga);
        intent.putExtra("nama_minuman", ((RadioButton) findViewById(selectedMinumanId)).getText().toString());
        intent.putExtra("jumlah_porsi", jumlahPorsi);
        startActivity(intent);
    }

    private int getHargaMakanan(int selectedMakananId) {
        switch (selectedMakananId) {
            case RADIO_BUTTON_NASI_GORENG:
                return 10000;
            case RADIO_BUTTON_MIE_GORENG:
            case RADIO_BUTTON_MIE_REBUS:
                return 8000;
            default:
                return 0;
        }
    }

    private int getHargaMinuman(int selectedMinumanId) {
        switch (selectedMinumanId) {
            case RADIO_BUTTON_TEH_ES:
                return 5000;
            case RADIO_BUTTON_ES_JERUK:
                return 7000;
            default:
                return 0;
        }
    }
}
