package com.example.a38_buivanquang_food_order;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterContactnew extends RecyclerView.Adapter<adapterContactnew.Viewhoder> {

    Context context;
    ArrayList<Contact> arrayList;

    public adapterContactnew(Context context, ArrayList<Contact> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public adapterContactnew(ArrayList<Contact> contacts) {
        this.arrayList=contacts;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public adapterContactnew.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_order,parent,false);
        Viewhoder viewhoder=new Viewhoder(view);

        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapterContactnew.Viewhoder holder, int position) {
        Contact contact=arrayList.get(position);
        holder.binData(contact);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView tvname;
        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tvfood);
        }

        public void binData(Contact contact) {
            tvname.setText(contact.getName()+"("+contact.getCount()+")");
        }
    }
}
