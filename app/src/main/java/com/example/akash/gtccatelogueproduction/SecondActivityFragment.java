package com.example.akash.gtccatelogueproduction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class SecondActivityFragment extends Fragment {
    Map<String,Rock[]> brand=new HashMap<>();
    //private Rock[] rs={}
    private Rock[] blendedWhiskey={new Rock("JW Red Label",R.drawable.jwred),new Rock("JW Black Label",R.drawable.jwblack),
            new Rock("Vat 69",R.drawable.vat)};

    public SecondActivityFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.spirit, container, false);
        //Intent intent = getActivity().getIntent();

        //if (intent!=null) {
            //Rock rck = (Rock) intent.getExtras().getParcelable("p");
            final Tab1Spirit.LazyAdapter adapter = new Tab1Spirit.LazyAdapter(getActivity(), Arrays.asList(blendedWhiskey));
            final ListView l = (ListView) rootView.findViewById(R.id.list);
            l.setAdapter(adapter);


            l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Rock rc = (Rock) adapter.getItem(position);
                    Intent in = new Intent(view.getContext(), Detail_activity.class).putExtra("p", rc);
                    //Toast.makeText(getContext(),"love is life"+rc.name, Toast.LENGTH_SHORT).show();
                    //in.putExtra("drinkName",l.getItemAtPosition(position).toString());

                    startActivity(in);
                }
            });

        return rootView;
    }

}
