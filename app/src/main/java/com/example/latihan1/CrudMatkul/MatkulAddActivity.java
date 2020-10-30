package com.example.latihan1.CrudMatkul;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.latihan1.Model.DefaultResult;
import com.example.latihan1.Network.GetDataService;
import com.example.latihan1.Network.RetrofitClientInstance;
import com.example.latihan1.R;

public class MatkulAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_add2);

        final EditText edNama = (EditText)findViewById(R.id.editTextNamaMatkul);
        final EditText edKode = (EditText)findViewById(R.id.editTextKode);
        final EditText edHari = (EditText)findViewById(R.id.editTextHari);
        final EditText edSesi = (EditText)findViewById(R.id.editTextSesi);
        final EditText edSks = (EditText)findViewById(R.id.editTextSks);
        Button btnSimpanMk = (Button)findViewById(R.id.buttonSimpanMatkul);
        pd = new ProgressDialog(MatkulAddActivity.this);

        btnSimpanMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_mtkl(
                        edNama.getText().toString(),
                        edKode.getText().toString(),
                        edHari.getText().toString(),
                        edSesi.getText().toString(),
                        edSks.getText().toString(),
                        "721802011"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "DATA BERHASIL DISIMPAN", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "DATA TIDAK DAPAT DISIMPAN", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
