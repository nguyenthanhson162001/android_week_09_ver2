package com.example.android_week_09;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<Person> list ;
    private int idLayout ;
    private Context context;

    public ListAdapter(List<Person> list, int idLayout, Context context) {
        this.list = list;
        this.idLayout = idLayout;
        this.context = context;
    }

    @Override
    public int getCount() {
       if(list == null){
           return 0;
       }
        return list.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
//        LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }
        TextView name =  view.findViewById(R.id.name);
        name.setText(list.get(i).getName());
        return view;
    }
}
