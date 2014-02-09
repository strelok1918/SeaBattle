package com.SeaBattle;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class FieldAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<TextView> field = new ArrayList<TextView>();

    public FieldAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void init(ArrayList<TextView> field) {
        this.field = (ArrayList<TextView>)field.clone();
    }

    public int getPosition(View v) {
        for(int i = 0; i < field.size(); i++) {
            if(field.get(i).equals(v)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int getCount() {
        return field.size();
    }

    @Override
    public Object getItem(int i) {
        return field.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View button = view;
        if(view == null) {
            button = new TextView(mContext);
            button.setBackgroundColor(Color.LTGRAY);

        } else {
            button = (TextView)view;
        }
        button = (TextView)getItem(i);

        return button;
    }

}
