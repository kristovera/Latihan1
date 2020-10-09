package com.example.latihan1.Pertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.latihan1.R;

import static com.example.latihan1.R.id.spinnerLatihan;

public class ListActivity extends AppCompatActivity {

    String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lv = (ListView)findViewById(R.id.lvLatihan);
        Spinner sp = (Spinner)findViewById(spinnerLatihan);

        lv.setAdapter(new ArrayAdapter<String>(ListActivity.this,android.R.layout.simple_list_item_1));
        ArrayAdapter<String> aa = new ArrayAdapter<String>(ListActivity.this,android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int i, long I) {
                Toast.makeText(ListActivity.this, "Anda memilih " + items[i], Toast.LENGTH_LONG).show();
            }
        });
             sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> adapter, View view , int i , long I) {
                    Toast.makeText(ListActivity.this,"Anda tidak memilih " + items[i],Toast.LENGTH_LONG);
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView){
                    Toast.makeText(ListActivity.this,"Anda tidak memilih" ,Toast.LENGTH_LONG);
                }


             });


    }
}