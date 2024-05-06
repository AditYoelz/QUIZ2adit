package com.example.quiz1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz1.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int totalHarga = extras.getInt("total_harga");
            String namaMinuman = extras.getString("nama_minuman");
            int jumlahPorsi = extras.getInt("jumlah_porsi");

            TextView textViewNamaMinuman = findViewById(R.id.textViewNamaMinuman);
            TextView textViewJumlahPorsi = findViewById(R.id.textViewJumlahPorsi);
            TextView textViewTotalHarga = findViewById(R.id.textViewTotalHarga);

            textViewNamaMinuman.setText("Nama Minuman: " + namaMinuman);
            textViewJumlahPorsi.setText("Jumlah Porsi: " + jumlahPorsi);
            textViewTotalHarga.setText("Total Harga: Rp" + totalHarga);
        }
    }
}
