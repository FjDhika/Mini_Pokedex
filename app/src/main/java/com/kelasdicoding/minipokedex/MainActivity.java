package com.kelasdicoding.minipokedex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rclrPoke;
    private ArrayList<Poke> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rclrPoke = findViewById(R.id.rclr_poke_list);
        rclrPoke.setHasFixedSize(true);

        list.addAll(PokeData.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showRecyclerList() {
        rclrPoke.setLayoutManager(new LinearLayoutManager(this));
        ListPokeAdapter listPokeAdapter = new ListPokeAdapter(list);
        rclrPoke.setAdapter(listPokeAdapter);
        listPokeAdapter.setOnClickedCallback(new ListPokeAdapter.OnClickedCallback() {
            @Override
            public void OnClicked(Poke data) {
                showSelectedPoke(data);
            }
        });
    }

    private void showSelectedPoke(Poke data){
        Intent intent = new Intent(this,PokeDetail.class);
        startActivity(intent);
        Toast.makeText(this,data.getName(),Toast.LENGTH_LONG).show();
    }
}
