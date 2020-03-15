package com.example.reciclaje_reciclarview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mfirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Post List");

        mRecyclerView =findViewById(R.id.recyclerView);
         mRecyclerView.setHasFixedSize(true);

         mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

         mfirebaseDatabase=FirebaseDatabase.getInstance();
         mRef = mfirebaseDatabase.getReference("Bono");
    }

    @Override
    protected
    void onStart() {
        super.onStart();
            FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(
                    Model.class,
                    R.layout.row,
                    ViewHolder.class,
                    mRef

            ) {
                @Override
                protected
                void populateViewHolder(ViewHolder viewHolder, Model model, int i) {
                    viewHolder.setDetails(getApplicationContext(),model.getIdPunto(),model.getNombre(),model.getImage());

                }
            };
            mRecyclerView.setAdapter(firebaseRecyclerAdapter);

        }
    }

