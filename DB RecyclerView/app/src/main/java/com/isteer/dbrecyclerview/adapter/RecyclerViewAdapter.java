package com.isteer.dbrecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isteer.dbrecyclerview.R;
import com.isteer.dbrecyclerview.model.Contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private final Context context;
    private final List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

//    Where to get the single card as ViewHolder Object
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

//    What will happen after creating we create the ViewHolder Object
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.contactName.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());

    }

//    How many items?
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView contactName;
        public TextView phoneNumber;
        public ImageView iconButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            contactName = itemView.findViewById(R.id.textView);
            phoneNumber = itemView.findViewById(R.id.textView2);
            iconButton = itemView.findViewById(R.id.imageView);

            iconButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Log.d("MrKap_View","Clicked From View Holder");
            int position = this.getAdapterPosition();
            Contact contact = contactList.get(position);
            String name = contact.getName();
            String phone = contact.getPhoneNumber();

            Toast.makeText(context, "Position "+ (position+1) + " returns, "+
                    name + " : " + phone ,Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, DisplayContact.class);
            intent.putExtra("Rname",name);
            intent.putExtra("Rphone", phone);
            context.startActivity(intent);
        }
    }
}
