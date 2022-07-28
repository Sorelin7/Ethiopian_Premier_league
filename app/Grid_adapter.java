package com.group_d.ethiopianpremierleague;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Grid_adapter extends BaseAdapter {
    Context context;
    String[] discrption;
    int [] photo;
    LayoutInflater inflater;

    public Grid_adapter(Context context, String[] discrption, int[] photo) {
        this.context = context;
        this.discrption = discrption;
        this.photo = photo;
    }

    @Override
    public int getCount() {
        return discrption.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (convertview == null)
            convertview = inflater.inflate(R.layout.grid_view, null);
        ImageView imageView = convertview.findViewById(R.id.gridimage);
        TextView textView=convertview.findViewById(R.id.discription);
        imageView.setImageResource(photo[position]);
        textView.setText(discrption[position]);

        return convertview;
    }
}

