package com.example.enaitzdam.retrofittutorial;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.enaitzdam.retrofittutorial.responses.Averias;
import com.example.enaitzdam.retrofittutorial.responses.Talleres;

import java.util.List;

public class TallerAdapter extends ArrayAdapter<Talleres> {

    private Context mContext;
    private List<Talleres> mValues;

    public TallerAdapter(Context context, int textViewResourceId, List<Talleres> objects) {
        super(context, textViewResourceId, objects);
        this.mContext = context;
        this.mValues = objects;
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public Talleres getItem(int position) {
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
        label.setText(" " + mValues.get(position).getNombre());
        label.setHeight(50);
        label.setGravity(Gravity.LEFT | Gravity.CENTER);
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setTextSize(18);
        label.setText(" " + mValues.get(position).getNombre());
        label.setHeight(70);
        label.setGravity(Gravity.LEFT | Gravity.CENTER);
        return label;
    }
}
