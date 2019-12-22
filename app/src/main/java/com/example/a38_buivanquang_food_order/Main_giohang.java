package com.example.a38_buivanquang_food_order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main_giohang extends AppCompatActivity {

    ImageView img;
    Contact oder[];
    Contact contact;
    List<Contact> contacts;
    double tongtien=0;
    TextView tvtongtien;
    AdapterContact adapterContact;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_giohang);

        img=findViewById(R.id.imgview);
        tvtongtien=findViewById(R.id.tvtong);
        recyclerView=findViewById(R.id.recyclergiohang);


        contacts=new ArrayList<>();
        oder=new Contact[6];
        Intent intent=getIntent();
        contact=(Contact)intent.getSerializableExtra("contact");

        if(contacts.size()==0){
            contacts.add(contact);
        }
        for (int i=0;i<contacts.size();i++){

            tongtien=tongtien+contacts.get(i).cost;
        }
        if(tongtien==0){
            tvtongtien.setText("0");
        }
        else
        {
            tvtongtien.setText(""+tongtien);
        }

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapterContact=new AdapterContact(contacts,getBaseContext());
        adapterContact.notifyDataSetChanged();
        recyclerView.setAdapter(adapterContact);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),Main_order.class);
                startActivity(intent);
            }
        });

    }
}
