package com.example.movilgram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movilgram.R;
import com.example.movilgram.model.Auto;
import com.example.movilgram.ui.product.ProductDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AutoAdapterRecyclerView extends RecyclerView.Adapter<AutoAdapterRecyclerView.PictureViewHolder> {
    private ArrayList<Auto> pictures;
    private int resource; //es el layout-cardview
    private Activity activity;

    public AutoAdapterRecyclerView(ArrayList<Auto> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false); //convierte xml a view, inflando un view pasando todo el recurso
        return new PictureViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final PictureViewHolder holder, final int position) { //recorre la lista y va generando tarjetas
        Auto picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        Picasso.get().load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ProductDetailActivity.class); //donde estoy ubicado y a donde quiero ir
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//validacion para que la transicion no explote
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    //asigna la transicion
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent,ActivityOptionsCompat.makeSceneTransitionAnimation(activity,view,activity.getString(R.string.transitionname_picture)).toBundle());
                }else { //si alguien corre la actividad en una version menor a lollipop
//contexto de recyclerView se inicia a la actividad asi
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() { //devuelve el conteo de los elementos que hay
        return pictures.size();
    }

    //clase inner, trabaja todos los views que componen la tarjeta
    public class PictureViewHolder extends RecyclerView.ViewHolder {
        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);
            pictureCard = (ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard = (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard = (TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard = (TextView) itemView.findViewById(R.id.likeNumberCard);
        }
    }
}
