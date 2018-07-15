package com.education.user.booz.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.education.user.booz.Interface.Onclickinterface;
import com.education.user.booz.R;


public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView category_name;
    public ImageView category_image;

    private Onclickinterface itemClickListener;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        category_image=(ImageView)itemView.findViewById(R.id.category_image);
        category_name=(TextView)itemView.findViewById(R.id.category_name);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(Onclickinterface itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }
}

