package com.example.latihan1.Crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.latihan1.Adapter.MahasiswaCRUDRecyclerAdapter;
import com.example.latihan1.Model.Mahasiswa;
import com.example.latihan1.Network.GetDataService;
import com.example.latihan1.Network.RetrofitClientInstance;
import com.example.latihan1.R;

public class MahasiswaGetAllActivity extends AppCompatActivity {

    RecyclerView rvMhs;
    MahasiswaCRUDRecyclerAdapter mhsAdapter;
    ProgressDialog pd;
    List<Mahasiswa> mahasiswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_get_all);

        rvMhs = (RecyclerView)findViewById(R.id.rvGetMhsAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Mahasiswa>> call = service.getMahasiswa("72180203");

        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                pd.dismiss();
                mahasiswaList = response.body();
                mhsAdapter = new MahasiswaCRUDRecyclerAdapter(mahasiswaList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MahasiswaGetAllActivity.this);
                rvMhs.setLayoutManager(layoutManager);
                rvMhs.setAdapter(mhsAdapter);
            }

            @Override
            public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MahasiswaGetAllActivity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}
