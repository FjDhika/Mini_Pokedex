package com.kelasdicoding.minipokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

    private void showRecyclerList() {
        rclrPoke.setLayoutManager(new LinearLayoutManager(this));
        ListPokeAdapter listPokeAdapter = new ListPokeAdapter(list);
        rclrPoke.setAdapter(listPokeAdapter);
    }
}
