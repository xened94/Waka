package com.example.waka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.waka.Domain.BebidasDomain;
import com.example.waka.Helper.ManagementCart;

public class MostrarDetalleActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView tittleTxt, feeTxt, descriptionTxt, numberOrderTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private BebidasDomain object;
    int numberOrder = 1;
    private ManagementCart managementCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalle);

        managementCart=new ManagementCart(this);
        initView();
        getBundle();
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        tittleTxt = findViewById(R.id.tittleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood=findViewById(R.id.picFood);
    }

    private void getBundle() {
        object = (BebidasDomain) getIntent().getSerializableExtra("object");

        int drableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drableResourceId)
                .into(picFood);

        tittleTxt.setText(object.getNombre());
        feeTxt.setText("$" + object.getFee());
        descriptionTxt.setText(object.getDescripcion());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOrder < 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }


        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });





        }
    }
