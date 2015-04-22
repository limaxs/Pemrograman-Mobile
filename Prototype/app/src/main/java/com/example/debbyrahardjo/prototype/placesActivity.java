package com.example.debbyrahardjo.prototype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by debbyrahardjo on 21/04/2015.
 */
public class placesActivity extends ActionBarActivity {

    //attribute tiap item list (restaurant/tempat makan)
    public class placesAttribute{
        String name;
        String address;
        String distance;
        String time;
    }

    placesAdapter placesListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        //adapter listview di place_list
        placesListAdapter = new placesAdapter();
        ListView place = (ListView) findViewById(R.id.listOfPlace);
        place.setAdapter(placesListAdapter);

        final Context context = this;
        place.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick (AdapterView<?> parent,View view,int position,long id){
                Intent it = new Intent(context,popupDialog.class);
                startActivity(it);
            }
        });


    }


    public class placesAdapter extends BaseAdapter{
        List<placesAttribute> placesList = getDataForListView();
        public int getCount(){
            return placesList.size();
        }

        public placesAttribute getItem(int arg0){
            return placesList.get(arg0);
        }

        public long getItemId(int arg0){
            return arg0;
        }

        //nampilin activity_placelist + isi
        public View getView(int arg0, View arg1, ViewGroup arg2){
            if(arg1==null){
                LayoutInflater inflater = (LayoutInflater) placesActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                arg1 = inflater.inflate(R.layout.activity_placelist,arg2,false);
            }

            TextView name = (TextView)  arg1.findViewById(R.id.restaurant);
            TextView address = (TextView) arg1.findViewById(R.id.address);
            TextView distance = (TextView) arg1.findViewById(R.id.distance);
            TextView time = (TextView) arg1.findViewById(R.id.time);

            placesAttribute places = placesList.get(arg0);

            name.setText(places.name);
            address.setText(places.address);
            distance.setText(places.distance);
            time.setText(places.time);

            return arg1;
        }

        public placesAttribute getPlacesAttribute(int pos){
            return placesList.get(pos);
        }

    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_start_screen,menu);
        return true;
    }

    //buat ngisi list
    public List<placesAttribute> getDataForListView(){
        List<placesAttribute> placesList = new ArrayList<placesAttribute>();

        for(int i=0; i <= 10; i++){
            placesAttribute place = new placesAttribute();
            place.name = "Restaurant "+i;
            place.address = "Jl. Restaurant "+i;
            place.distance = "2,"+i+" KM ";
            placesList.add(place);
        }

        return placesList;
    }

}
