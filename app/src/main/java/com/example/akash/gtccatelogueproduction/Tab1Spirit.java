package com.example.akash.gtccatelogueproduction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Akash on 7/28/2017.
 */

public class Tab1Spirit extends Fragment {
    Context context;

    private Rock[] spirit = {new Rock("Blended Whiskey", R.drawable.blended), new Rock("Single Malt Whiskey", R.drawable.singlemalt),
            new Rock("Rum", R.drawable.rum), new Rock("Gin", R.drawable.gin), new Rock("Vodka", R.drawable.vodka), new Rock("Tequila", R.drawable.tequila),
            new Rock("Liqueurs", R.drawable.liqueurs)};
    private Rock[] wine = {new Rock("Italian Wine", R.drawable.italian), new Rock("Australian Wine", R.drawable.australian)};


    @Nullable


    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.spirit, container, false);


        //ArrayAdapter adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,mobileArray);


        final LazyAdapter adapter = new LazyAdapter(getActivity(), Arrays.asList(spirit));
        final ListView l = (ListView) rootView.findViewById(R.id.list);
        l.setAdapter(adapter);


        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Rock rc = (Rock) adapter.getItem(position);
                Intent in = new Intent(view.getContext(), SecondActivity.class).putExtra("p", rc);
                //Toast.makeText(getContext(),"love is life"+rc.name, Toast.LENGTH_SHORT).show();
                //in.putExtra("drinkName",l.getItemAtPosition(position).toString());

                startActivity(in);
            }
        });
        return rootView;
    }


    public static class LazyAdapter extends ArrayAdapter<Rock> {


        public LazyAdapter(Activity context, List<Rock> rocks) {
            super(context, R.layout.spirit, rocks);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Rock rock = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
            }
            ImageView iconView = (ImageView) convertView.findViewById(R.id.list_image);
            iconView.setImageResource(rock.image);
            TextView versionNameView = (TextView) convertView.findViewById(R.id.title);
            versionNameView.setText(rock.name);
            return convertView;
        }
    }


}