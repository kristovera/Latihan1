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
import com.example.latihan1.CrudDsn.HapusDsnActivity;
import com.example.latihan1.Model.DefaultResult;
import com.example.latihan1.Network.GetDataService;
import com.example.latihan1.Network.RetrofitClientInstance;
import com.example.latihan1.R;

public class HapusMatkulActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_matkul);

        //variabel
        final EditText edHapusMatkul = (EditText)findViewById(R.id.editTextHapusMatkul);
        Button btnHapusMatkul = (Button)findViewById(R.id.buttonHapusMatkul);
        pd = new ProgressDialog(HapusMatkulActivity.this);

        btnHapusMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_mtkl(
                        edHapusMatkul.getText().toString(),"721802011"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(HapusMatkulActivity.this,"DATA BERHASIL DIHAPUS",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(HapusMatkulActivity.this,"DATA EROR",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
