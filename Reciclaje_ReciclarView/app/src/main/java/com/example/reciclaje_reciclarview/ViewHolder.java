package com.example.reciclaje_reciclarview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public  ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setDetails(Context ctx,  String Id, String Nombre, String Image){
        TextView mId = mView.findViewById(R.id.rId);
        TextView mNombre = mView.findViewById(R.id.rNombre);
        TextView mImage = mView.findViewById(R.id.rImagenView);

        mId.setText(Id);
        mNombre.setText(Nombre);
        Picasso.get().load(Image).into((Target) mImage);

    }
}
