package com.example.latihan1.CrudMatkul;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.latihan1.CrudDsn.MainDsnActivity;
import com.example.latihan1.Model.DefaultResult;
import com.example.latihan1.Network.GetDataService;
import com.example.latihan1.Network.RetrofitClientInstance;
import com.example.latihan1.R;

public class MatkulUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_update);

        final EditText edKodeLama = (EditText)findViewById(R.id.edKodeLama);
        final EditText edNama = (EditText)findViewById(R.id.edUpNamaMatkul);
        final EditText edKode = (EditText)findViewById(R.id.edUpKode);
        final EditText edHari = (EditText)findViewById(R.id.edUpHari);
        final EditText edSks = (EditText)findViewById(R.id.edUpSks);
        final EditText edSesi = (EditText)findViewById(R.id.edUpSesi);
        Button btnEdit = (Button) findViewById(R.id.btnUpdateMatkul);
        pd = new ProgressDialog(MatkulUpdateActivity.this);

        Intent data = getIntent();
        if(data.getExtras() != null){
            edNama.setText(data.getStringExtra("nama"));
            edKode.setText(data.getStringExtra("kode"));
            edHari.setText(data.getStringExtra("hari"));
            edSks.setText(data.getStringExtra("sks"));
            edSesi.setText(data.getStringExtra("sesi"));
            edKodeLama.setText(data.getStringExtra("kode"));
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_mtkl(
                        edNama.getText().toString(),
                        edKode.getText().toString(),
                        edHari.getText().toString(),
                        edSks.getText().toString(),
                        edSesi.getText().toString(),
                        edKode.getText().toString(),
                        "721802011"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this, "DATA BERHASIL DIUBAH", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MatkulUpdateActivity.this, MainDsnActivity.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this, "DATA EROR", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
