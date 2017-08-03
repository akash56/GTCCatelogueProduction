package com.example.akash.gtccatelogueproduction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;

import static com.example.akash.gtccatelogueproduction.R.layout.spirit;

/**
 * Created by Akash on 7/31/2017.
 */

public class Tab2Beer extends android.support.v4.app.Fragment {
    Context context;
    private Rock[] beer = {new Rock("Heknankien", R.drawable.blended), new Rock("tuborg", R.drawable.jwblack)};
    @Nullable


    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(spirit, container, false);


        //ArrayAdapter adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,mobileArray);


        final Tab1Spirit.LazyAdapter adapter = new Tab1Spirit.LazyAdapter(getActivity(), Arrays.asList(beer));
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
}
