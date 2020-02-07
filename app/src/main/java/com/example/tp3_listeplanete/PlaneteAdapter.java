package com.example.tp3_listeplanete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class PlaneteAdapter extends BaseAdapter {

    private final Context contextMainActivity;
    private ArrayList<String> planetes;

    public PlaneteAdapter(ArrayList<String> planetesName, Context contextMainActivity) {
        this.contextMainActivity = contextMainActivity;
        this.planetes = planetesName;
    }

    @Override
    public int getCount() {
        return planetes.size();
    }

    @Override
    public Object getItem(int arg0) {
        return planetes.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) contextMainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = itemView.findViewById(R.id.textView);
        final CheckBox checkBox = itemView.findViewById(R.id.checkbox);
        final Spinner spinner = itemView.findViewById(R.id.spinner);


        nomPlanete.setText(planetes.get(position));
        Data datas = new Data();

        //  installer l'adaptateur pour la liste déroulante (spinner)
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>( contextMainActivity, android.R.layout.simple_spinner_item, datas.getTaillePlanetes());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();
            }
        });

        return itemView;
    }
}


