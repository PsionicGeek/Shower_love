package com.ART.shower_love.ui.donatereceive;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ART.shower_love.R;


public class Myviewholder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView  textView;

    public Myviewholder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_of_item);
        textView = itemView.findViewById(R.id.text_r_item);
    }
}
