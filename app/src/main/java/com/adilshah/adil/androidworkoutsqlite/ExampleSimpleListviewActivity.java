package com.adilshah.adil.androidworkoutsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ExampleSimpleListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_simple_listview);

        ListView foodsListView = (ListView) findViewById(R.id.foodsListView);

        String[] foods = {"Roasted Chicken","Biryani","Alu Qeema","Chicken Chilli Dry","Beef Chilli Dry","Buffalo Wings","Jalpeno burger","Thai Platter", "Chinese platter" , "Mashed potatoes","kabli Pulao","Chicken Karahi","Chicken Handi","Makhni Chiken handi","Saji","Chicken Pulao" };
        //Array Adapter for list item
        ListAdapter foodsAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , foods);
        foodsListView.setAdapter(foodsAdapter);


        foodsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String food = String.valueOf(parent.getItemAtPosition(position));

                Toast toastItemName = Toast.makeText(ExampleSimpleListviewActivity.this, "You Clicked "+food , Toast.LENGTH_LONG);
                toastItemName.show();
            }
        });

    }
}
