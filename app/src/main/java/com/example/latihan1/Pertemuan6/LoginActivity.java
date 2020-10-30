package com.example.latihan1.Pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.latihan1.HomeActivity;
import com.example.latihan1.Model.User;
import com.example.latihan1.Network.GetDataService;
import com.example.latihan1.Network.RetrofitClientInstance;
import com.example.latihan1.R;

public class LoginActivity extends AppCompatActivity {

    ProgressDialog pd;
    List<User> users;
    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Toast.makeText(LoginActivity.this, "Anda sudah login", Toast.LENGTH_SHORT).show();

        session = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);

        if(!session.getString("nimnik", "").isEmpty() && !session.getString("nama", "").isEmpty()) {
            finish();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            return;
        }

        final EditText edNimNik = findViewById(R.id.edLoginNimNik);
        final EditText edPassword =  findViewById(R.id.edPassword);
        Button btnlogin = findViewById(R.id.btnLogin);
        pd = new ProgressDialog(LoginActivity.this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Loading...");
                pd.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<List<User>> call = service.login(
                        edNimNik.getText().toString(),
                        edPassword.getText().toString()
                );
                call.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        pd.dismiss();
                        users = response.body();
                        if(users.size()==0){
                            pd.dismiss();
                            Toast.makeText(LoginActivity.this, "Username atau password salah.", Toast.LENGTH_SHORT).show();
                        }else{
                            User u = users.get(0);

                            SharedPreferences.Editor editor = session.edit();
                            editor.clear();
                            editor.putString("nimnik", u.getNimnik());
                            editor.putString("nama", u.getNama());
                            editor.apply();
                            finish();
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this, "Username atau password salah.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}