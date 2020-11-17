package com.ART.shower_love.ui.donatereceive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ART.shower_love.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

public class Receivemenu extends AppCompatActivity {
    EditText InputSearch;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<uploadinfo> options;
    FirebaseRecyclerAdapter<uploadinfo ,Myviewholder>adapter;
    DatabaseReference Datareference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receivemenu);
    InputSearch = findViewById(R.id.input_search);
    recyclerView = findViewById(R.id.recyclerview);
    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    recyclerView.setHasFixedSize(true);
    Loaddata();
    


    }

    private void Loaddata() {
        options = new FirebaseRecyclerOptions.Builder<uploadinfo>().setQuery(Datareference,uploadinfo.class).build();
        adapter = new FirebaseRecyclerAdapter<uploadinfo, Myviewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Myviewholder holder, int position, @NonNull uploadinfo model) {
                holder.textView.setText(model.getImageName());
                Picasso.get().load(model.getImageURL()).into(holder.imageView);

            }

            @NonNull
            @Override
            public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
                return new Myviewholder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}