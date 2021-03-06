package com.example.latihan1.CrudDsn;

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

public class HapusDsnActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_dsn);

        //variabel
        final EditText edHapusDsn = (EditText)findViewById(R.id.editTextHapusDsn);
        Button btnHapusDsn = (Button)findViewById(R.id.buttonHapusDsn);
        pd = new ProgressDialog(HapusDsnActivity.this);

        btnHapusDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_dsn(
                        edHapusDsn.getText().toString(),"721802011"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(HapusDsnActivity.this,"DATA BERHASIL DIHAPUS",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(HapusDsnActivity.this,"DATA TIDAK BERHASIL DIHAPUS",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
