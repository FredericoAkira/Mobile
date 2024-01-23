package com.example.project1442.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project1442.Adapter.PopularListAdapter;
import com.example.project1442.Domain.PopularDomain;
import com.example.project1442.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottom_navigation();

    }

    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("John Diggle", "Discover the John Diggle History\n" +
                " In 1897 Viking Era\n" +
                " With his gloriusness and kindness to the people \n" +
                "give money to the poor, and raise them from violence\n" +
                " The new king above our head\n" +
                " The only one can save our hunger\n" +
                " All of people in my country adore him as John Diggle the Kinger \n" +
                "Look inside and you will believe\n" +
                " Don't wait, buy now this interesting story\n" +
                " or you will miss the great John Diggle \n" +
                "John Diggle.", "pic7", 15, 4, 35000));
        items.add(new PopularDomain("MathFix", "Discover the new Math Fix featuring the\n" +
                " Plus (+) Minus (-) Multiples(x) Division(/) \n" +
                " And Full with counting and measuring \n" +
                "Live with the big knowledge about math\n" +
                " You can exercise too, and live with how math works\n" +
                " companion for productivity, creativity, and\n" +
                " entertainment. Experience seamless multitasking, \n" +
                "stunning math problems\n" +
                " enhanced with amazing explanation\n" +
                " present for you only MathFix! \n" +
                "MathFix.", "pic8", 10, 4.5, 24500));
        items.add(new PopularDomain("TOF", "Discover the Science Era\n" +
                " Look inside for the Theory Of Everything\n" +
                " Create by Tom Hawking \n" +
                "sleek design and advanced technology, the\n" +
                " Through One Book Only\n" +
                " Give you entertain and knowledge\n" +
                " Throug stunning picture and visuals, \n" +
                "Look's Cool Right ?\n" +
                " Buy Now! Or not its too late\n" +
                " knowledge experience to the next level with the \n" +
                "TOF.", "pic9", 13, 4.2, 37000));
        items.add(new PopularDomain("Internet 2.0", "Discover the Internet\n" +
                " Look inside for Internet 2.0\n" +
                " Create by Tom Hawking \n" +
                "sleek design and advanced technology, the\n" +
                " Through One Book Only\n" +
                " Give you entertain and knowledge\n" +
                " Throug stunning picture and visuals, \n" +
                "Look's Cool Right ?\n" +
                " Buy Now! Or not its too late\n" +
                " knowledge experience to the next level with the \n" +
                "Internet 2.0.", "pic4", 13, 4.2, 15000));
        items.add(new PopularDomain("Thingamacji 2.0", "Discover the Thingamacji\n" +
                " Look inside for Thingamacji\n" +
                " Create by Pens Hawking \n" +
                "sleek design and advanced technology, the\n" +
                " Through One Book Only\n" +
                " Give you entertain and knowledge\n" +
                " Throug stunning picture and visuals, \n" +
                "Look's Cool Right ?\n" +
                " Buy Now! Or not its too late\n" +
                " knowledge experience to the next level with the \n" +
                "Thingamacji", "pic5", 10, 4.9, 35000));
        items.add(new PopularDomain("Bible", "Discover the Live of Jesus Christ\n" +
                " Look inside for Historical Envidence\n" +
                " Create by God Himself \n" +
                "Big Known Human History\n" +
                " Through Our Saviour of the sins\n" +
                " Give you long last life and free of sins\n" +
                " Through His body and blood, \n" +
                "Jesus our saviour ?\n" +
                " From The beginning to the end\n" +
                " knowledge experience to the next level with the \n" +
                "Bible", "pic6", 10, 5.0, 45000));

        recyclerViewPupolar = findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPupolar = new PopularListAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
}