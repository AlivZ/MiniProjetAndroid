package com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Context context, List<Item> itemListe) {
        super(context, 0, itemListe);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout,parent, false);
        }

        ItemViewHolder viewHolder = (ItemViewHolder) convertView.getTag();
        if(viewHolder == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout,null);
            viewHolder = new ItemViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.prenom = (TextView) convertView.findViewById(R.id.prenom);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Item> ItemListe
        Item item = getItem(position);
        viewHolder.nom.setText(item.getNom());
        viewHolder.prenom.setText(item.getPrenom());
        InputStream adresseImg=null;
        try {
            adresseImg = getContext().getAssets().open(item.getImagePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(adresseImg);
        viewHolder.image.setImageBitmap(bitmap);

        return convertView;
    }

}
