package com.example.enaitzdam.retrofittutorial;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.enaitzdam.retrofittutorial.responses.Averias;
import java.util.List;

public class AveriaAdapter extends ArrayAdapter<Averias> {

    private Context mContext;
    private List<Averias> mValues;

    public AveriaAdapter(Context context, int textViewResourceId, List<Averias> objects) {
        super(context, textViewResourceId, objects);
        this.mContext = context;
        this.mValues = objects;
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public Averias getItem(int position) {
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
        label.setText(" " + mValues.get(position).getTitulo());
        label.setHeight(50);
        label.setGravity(Gravity.LEFT | Gravity.CENTER);
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setTextSize(18);
        label.setText(" " + mValues.get(position).getTitulo());
        label.setHeight(70);
        label.setGravity(Gravity.LEFT | Gravity.CENTER);
        return label;
    }
}


