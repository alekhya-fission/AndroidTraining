package com.fisstion.sample.shownamesusinglistview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewNames extends Activity {
    //List<String>familyNames=new ArrayList<>(5);
    //intially we define a list
    public List<String> familyArrayList= new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //we set the layout
        setContentView(R.layout.activity_list_view_names);
        //we are getting listview id
        ListView namesList=(ListView)findViewById(R.id.list_view);
        /*familyArrayList.add("alekhya");
        familyArrayList.add("bharath");
        familyArrayList.add("subbaraydu");
        familyArrayList.add("satyavathi");*/
        getNames();
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, familyArrayList);
        namesList.setAdapter(adapter);


    }
    //get name method
    public void getNames(){
        familyArrayList.add("Subbarayadu");
        familyArrayList.add("Sathyavathi");
        familyArrayList.add("Bharath");
        familyArrayList.add("alekhya");

    }
}
