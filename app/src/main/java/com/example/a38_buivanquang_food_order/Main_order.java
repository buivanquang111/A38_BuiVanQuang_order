package com.example.a38_buivanquang_food_order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import java.util.ArrayList;


public class Main_order extends AppCompatActivity implements Icon{

    ViewFlipper viewFlipper;
    int[] arrayHinh={R.drawable.anh1,R.drawable.anh2,R.drawable.anh3,R.drawable.anh4,R.drawable.anh5};

    RecyclerView recyclerView;
    ArrayList<Contact> contacts;

    AdapterContact adapterContact;

    Button btnorder;
    TextView tvprice;
    TextView tvname;
    TextView tvcount;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_order);

        anhxa();
        layoutviewflipper();
        viewrecyclerview();
        totalprice();



       img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getBaseContext(),Main_giohang.class);
               intent.putExtra("contact",contacts);
               startActivity(intent);
           }
       });

        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Thank you! your order sent to restaurant",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void viewrecyclerview() {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL,false);
        adapterContact=new AdapterContact(contacts,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterContact);

    }

    private void anhxa() {
        img=findViewById(R.id.imggiohang);
        recyclerView=findViewById(R.id.rvlist);
        btnorder=findViewById(R.id.btnorder);
        tvprice=findViewById(R.id.tvprice);
        tvname=findViewById(R.id.tvname);
        tvcount=findViewById(R.id.tvcount);
        viewFlipper=findViewById(R.id.viewlipper);
        recyclerView=findViewById(R.id.rvlist);
        contacts= new ArrayList<>();
        contacts.add(new Contact("pizza",10,0));
        contacts.add(new Contact("KFC super",10,0));
        contacts.add(new Contact("Bread Eggs",10,0));
        contacts.add(new Contact("Coca cola",10,0));
        contacts.add(new Contact("Chicken",10,0));

    }

    private void layoutviewflipper() {
        for(int i=0;i<arrayHinh.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(arrayHinh[i]);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
    }


    @Override
    public void onClickName(Contact contact) {

        int countnow = Integer.parseInt(tvcount.getText().toString()) + 1;
        tvcount.setText(countnow + "");
        Contact temp = contacts.get(contacts.indexOf(contact));
        temp.setCount(temp.getCount() + 1);
        contacts.set(contacts.indexOf(contact),temp);
        totalprice();

    }

    private void totalprice() {
        float tongtien=0;
        for(Contact i: contacts){
            tongtien=tongtien+i.getCount()*i.getCost();
        }
        tvprice.setText(tongtien+"$");
    }

    @Override
    public void onClickNumber(int a) {

    }


}
