package com.adilshah.adil.androidworkoutsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView linkLogin =  (TextView) findViewById(R.id.linkLogin);
        final TextView linkExampleSimpleListView = (TextView) findViewById(R.id.linkExampleSimpleListView);
        final TextView linkCustomListview =(TextView) findViewById(R.id.linkCustomListview);

        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this , LiteLoginActivity.class);
                MainActivity.this.startActivity(loginIntent);
            }
        });

        linkExampleSimpleListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exampleSimpleListViewIntent = new Intent(MainActivity.this , ExampleSimpleListviewActivity.class);
                MainActivity.this.startActivity(exampleSimpleListViewIntent);
            }
        });

        linkCustomListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exampleCustomListViewIntent = new Intent(MainActivity.this , ExampleCustomListViewActivity.class);
                MainActivity.this.startActivity(exampleCustomListViewIntent);
            }
        });
    }
}
