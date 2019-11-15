package com.kelasdicoding.minipokedex;

import java.util.ArrayList;

public class PokeData {
    private static String[] names={
            "377",
            "378",
            "379",
            "380",
            "381",
            "382",
            "383",
            "384",
            "386",
            "486"
    };

    private static String[] type={
            "Type-1",
            "Type-2",
            "Type-3",
            "Type-1",
            "Type-2",
            "Type-3",
            "Type-1",
            "Type-2",
            "Type-3",
            "Type-1",
            "Type-2"
    };

    private static int[] photo={
            R.drawable.poke_377,
            R.drawable.poke_378,
            R.drawable.poke_379,
            R.drawable.poke_380,
            R.drawable.poke_381,
            R.drawable.poke_382,
            R.drawable.poke_383,
            R.drawable.poke_384,
            R.drawable.poke_386,
            R.drawable.poke_486
    };

    static ArrayList<Poke> getListData(){

        ArrayList<Poke> list = new ArrayList<>();

        for(int i=0; i<names.length;i++){
            Poke poke = new Poke();
            poke.setName(names[i]);
            poke.setPhoto(photo[i]);
            poke.setDetail(type[i]);
            list.add(poke);
        }
        return list;
    }
}
