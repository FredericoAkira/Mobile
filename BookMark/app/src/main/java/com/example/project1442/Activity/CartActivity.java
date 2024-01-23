package com.example.project1442.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.project1442.Adapter.CartListAdapter;
import com.example.project1442.Helper.ChangeNumberItemsListener;
import com.example.project1442.Helper.ManagmentCart;
import com.example.project1442.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ManagmentCart managmentCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double tax;
    private ScrollView scrollView;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managmentCart = new ManagmentCart(this);

        initView();
        setVariavle();
        initList();
        calcualteCart();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                calcualteCart();
            }
        });

        recyclerView.setAdapter(adapter);
        if (managmentCart.getListCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calcualteCart() {
        double percentTax = 0.02;  // you can change this value for tax price
        double delivery = 3000;

// Calculate tax in IDR
        double tax = Math.round((managmentCart.getTotalFee() * percentTax * 100.0)) / 100.0;

// Calculate total, itemTotal, and delivery in IDR
        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;
        double deliveryInIDR = Math.round(delivery * 100) / 100;

// Format numbers as currency in IDR
        String formattedItemTotal = String.format("Rp %,.2f", itemTotal);
        String formattedTax = String.format("Rp %,.2f", tax);
        String formattedDelivery = String.format("Rp %,.2f", deliveryInIDR);
        String formattedTotal = String.format("Rp %,.2f", total);

// Set text in TextViews
        totalFeeTxt.setText(formattedItemTotal);
        taxTxt.setText(formattedTax);
        deliveryTxt.setText(formattedDelivery);
        totalTxt.setText(formattedTotal);

    }

    private void setVariavle() {
        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerView = findViewById(R.id.view3);
        scrollView = findViewById(R.id.scrollView2);
        backBtn = findViewById(R.id.backBtn);
        emptyTxt = findViewById(R.id.emptyTxt);
    }
}