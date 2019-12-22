package com.example.a38_buivanquang_food_order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class Main_order extends AppCompatActivity implements Icon{

    ViewFlipper viewFlipper;
    int[] arrayHinh={R.drawable.anh1,R.drawable.anh2,R.drawable.anh3,R.drawable.anh4,R.drawable.anh5};

    RecyclerView recyclerView;
    List<Contact> contacts;
    Contact contact1,contact2,contact3,contact4,contact5;
    AdapterContact adapterContact;

    Button btnorder;
    TextView tvprice;
    TextView tvname;
    TextView tvcount;
    LinearLayout linearLayout;
    int dem=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_order);

        linearLayout=findViewById(R.id.linearlayout);
        recyclerView=findViewById(R.id.rvlist);
        btnorder=findViewById(R.id.btnorder);
        tvprice=findViewById(R.id.tvprice);
        tvname=findViewById(R.id.tvname);
        tvcount=findViewById(R.id.tvcount);


        viewFlipper=findViewById(R.id.viewlipper);
        for(int i=0;i<arrayHinh.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(arrayHinh[i]);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        recyclerView=findViewById(R.id.rvlist);
        contacts= new ArrayList<>();
        contact1 =new Contact("pizaa",10);
        contact2 =new Contact("KFC super",20);
        contact3 =new Contact("Bread Eggs",30);
        contact4 =new Contact("Coca Cola",40);
        contact5 =new Contact("Chicken super",50);
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL,false);



        adapterContact=new AdapterContact(contacts,getBaseContext());
        adapterContact.setIcon(new Icon() {
            @Override
            public void onClickName(Contact contact) {
                Intent intent=new Intent(getBaseContext(),Main_giohang.class);
                intent.putExtra("contact", (Parcelable) contact);
                startActivity(intent);
            }

            @Override
            public void onClickNumber(int a) {

            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterContact);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Main_giohang.class));
            }
        });
        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Thank you! your order sent to restaurant",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClickName(Contact contact) {

    }

    @Override
    public void onClickNumber(int a) {
        dem=dem+a;
    }
}
