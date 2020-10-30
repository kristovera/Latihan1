package com.example.latihan1.CrudMatkul;
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

import com.example.latihan1.Adapter.MatkulCRUDRecyclerAdapter;
import com.example.latihan1.Model.MataKuliah;
import com.example.latihan1.Network.GetDataService;
import com.example.latihan1.Network.RetrofitClientInstance;
import com.example.latihan1.R;


public class MatkulGetAllActivity extends AppCompatActivity {

    RecyclerView rvMtkl;
    MatkulCRUDRecyclerAdapter mtklAdapter;
    ProgressDialog pd;
    List<MataKuliah> matakuliahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_get_all);

        rvMtkl = (RecyclerView)findViewById(R.id.rvGetMatkulAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<MataKuliah>> call = service.getMatkul("72180203");

        call.enqueue(new Callback<List<MataKuliah>>() {
            @Override
            public void onResponse(Call<List<MataKuliah>> call, Response<List<MataKuliah>> response) {
                pd.dismiss();
                matakuliahList = response.body();
                mtklAdapter = new MatkulCRUDRecyclerAdapter(matakuliahList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatkulGetAllActivity.this);
                rvMtkl.setLayoutManager(layoutManager);
                rvMtkl.setAdapter(mtklAdapter);

            }

            @Override
            public void onFailure(Call<List<MataKuliah>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MatkulGetAllActivity.this,"error",Toast.LENGTH_LONG);
            }
        });
    }
}
