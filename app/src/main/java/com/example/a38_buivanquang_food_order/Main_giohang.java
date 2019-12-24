package com.example.a38_buivanquang_food_order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;


public class Main_giohang extends AppCompatActivity implements Icon{

    ImageView img;
    TextView tvtongtien;
    adapterContactnew adapterContactnew;
    RecyclerView recyclerView;
    ArrayList<Contact> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_giohang);

        Intent intent=getIntent();
        contacts = (ArrayList<Contact>) intent.getSerializableExtra("contact");



        anhxa();
        viewRecyclerview();
        totalprice();

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void totalprice() {
        float tongtien=0;
        for (Contact i:contacts){
            tongtien+=i.getCount()*i.getCost();
        }
        tvtongtien.setText(tongtien+"$");
    }

    private void viewRecyclerview() {
        Iterator iterator=contacts.iterator();
        while(iterator.hasNext()){
            Contact a= (Contact) iterator.next();
            if(a.getCount() == 0){
                iterator.remove();
            }
        }
        adapterContactnew=new adapterContactnew(this,contacts);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterContactnew);
    }

    private void anhxa() {
        img=findViewById(R.id.close);
        tvtongtien=findViewById(R.id.tvtong);
        recyclerView=findViewById(R.id.recyclergiohang);
    }

    @Override
    public void onClickName(Contact contact) {

    }

    @Override
    public void onClickNumber(int a) {

    }

}
