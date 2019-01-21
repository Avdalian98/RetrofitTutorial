package com.example.enaitzdam.retrofittutorial;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.enaitzdam.retrofittutorial.responses.Marcas;

import java.util.List;

public class MarcasAdapter extends ArrayAdapter<Marcas> {

    private Context mContext;
    private List<Marcas> mValues;

    public MarcasAdapter(Context context, int textViewResourceId, List<Marcas> objects) {
        super(context, textViewResourceId, objects);
        this.mContext = context;
        this.mValues = objects;
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public Marcas getItem(int position) {
        return mValues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setTextSize(18);
        label.setText(" " + mValues.get(position).getMarca());
        label.setHeight(50);
        label.setGravity(Gravity.LEFT | Gravity.CENTER);
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setTextSize(18);
        label.setText(" " + mValues.get(position).getMarca());
        label.setHeight(70);
        label.setGravity(Gravity.LEFT | Gravity.CENTER);
        return label;
    }
}

