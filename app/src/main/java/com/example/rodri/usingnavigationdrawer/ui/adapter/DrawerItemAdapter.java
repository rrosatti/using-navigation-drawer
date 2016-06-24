package com.example.rodri.usingnavigationdrawer.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rodri.usingnavigationdrawer.R;
import com.example.rodri.usingnavigationdrawer.model.DrawerItem;

import java.util.ArrayList;

/**
 * Created by rodri on 6/24/2016.
 */
public class DrawerItemAdapter extends ArrayAdapter<DrawerItem> {

    private Activity activity;
    private ArrayList<DrawerItem> drawerItems;
    private LayoutInflater inflater = null;

    public DrawerItemAdapter(Activity activity, int textViewResourceId, ArrayList<DrawerItem> drawerItems) {
        super(activity, textViewResourceId, drawerItems);

        try {
            this.activity = activity;
            this.drawerItems = drawerItems;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public int getCount() {
        return drawerItems.size();
    }

    public class ViewHolder {
        public ImageView displayIconImg;
        public TextView displayTitle;
        public TextView displayCounter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            v = inflater.inflate(R.layout.drawer_list_item, null);

            holder.displayIconImg = (ImageView) v.findViewById(R.id.imgIcon);
            holder.displayTitle = (TextView) v.findViewById(R.id.txtTitle);
            holder.displayCounter = (TextView) v.findViewById(R.id.txtCounter);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.displayIconImg.setImageResource(drawerItems.get(position).getIcon());
        holder.displayTitle.setText(drawerItems.get(position).getTitle());

        if (drawerItems.get(position).getCounterVisibility()) {
            holder.displayCounter.setText(drawerItems.get(position).getCount());
        } else {
            holder.displayCounter.setVisibility(View.GONE);
        }

        return v;

    }
}
