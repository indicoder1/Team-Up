package com.indicoder.teamup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Sarthak on 17-03-2016.
 */
public class MyAdapter extends ArrayAdapter<String>{
    public MyAdapter(Context context,String[] values){
        super(context,R.layout.row_layout,values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.row_layout,parent,false);
        String group=getItem(position);
        TextView theTextView=(TextView) theView.findViewById(R.id.textView3);
        theTextView.setText(group);
        return theView;
    }
}
