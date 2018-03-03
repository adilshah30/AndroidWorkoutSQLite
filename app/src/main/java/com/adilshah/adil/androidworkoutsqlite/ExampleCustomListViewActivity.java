package com.adilshah.adil.androidworkoutsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ExampleCustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_custom_list_view);

        ListView foodsListView = (ListView) findViewById(R.id.foodsListView);

        String[] foods = {"Roasted Chicken","Biryani","Alu Qeema","Chicken Chilli Dry","Beef Chilli Dry","Buffalo Wings","Jalpeno burger","Thai Platter", "Chinese platter" , "Mashed potatoes","kabuli Pulao","Chicken Karahi","Chicken Handi","Makhni Chicken handi","Saji","Chicken Pulao" };
        String[] food_description = {"Roasted chicken description","biryani description","Alu qeema Description","Chicken Chilli Dry Description","Beef Chilli Dry description","Buffalo Wings Description","Jalpeno burger Description","Thai Platter Description","Chinese platter Description","Mashed potatoes description","kabuli Pulao description","Chicken Karahi description","Chicken Handi description","Makhni Chicken handi description","Saji description","Chicken Pulao description"};
        int[] food_imgs = {R.mipmap.roasted_chicken, R.mipmap.biryani , R.mipmap.alu_qeema , R.mipmap.chiken_chilli_dry , R.mipmap.beef_chilli_dry, R.mipmap.buffalo_wings,R.mipmap.jalapeno_cheeseburger,R.mipmap.thai_platter,R.mipmap.chinese_platter,R.mipmap.mashed_potatoes,R.mipmap.kabuli_pulao,R.mipmap.chicken_karahi,R.mipmap.chicken_handi,R.mipmap.chicken_makhani_handi,R.mipmap.saji,R.mipmap.chicken_pulao};

        //Array Adapter for list item
        ListAdapter foodsAdapter =  new CustomAdapter(this , foods ,food_imgs , food_description);
        foodsListView.setAdapter(foodsAdapter);


        foodsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String food = String.valueOf(parent.getItemAtPosition(position));

                Toast toastItemName = Toast.makeText(ExampleCustomListViewActivity.this, "You Clicked "+food , Toast.LENGTH_LONG);
                toastItemName.show();
            }
        });



    }
}
