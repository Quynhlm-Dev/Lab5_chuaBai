package com.quynhlm.dev.lab5_chuabai;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SchoolAdapter extends BaseAdapter {
    private Context ctx;
    private ArrayList<School> list;

    public SchoolAdapter(Context ctx, ArrayList<School> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_co_so, parent, false);

        School thong_tin = list.get(position);
        TextView txtname = convertView.findViewById(R.id.ten_co_so);
        ImageView imglogo = convertView.findViewById(R.id.imglogo);

        if (thong_tin != null) {
            txtname.setText(thong_tin.getName());
            imglogo.setImageResource(thong_tin.getImglogo());
        }
        return convertView;
    }
}
