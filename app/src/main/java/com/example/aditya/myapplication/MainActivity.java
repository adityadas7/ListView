package com.example.aditya.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] name;
    private final String[] publisher;
    private final String[] designers;
    private final Integer[] imageId;
    public CustomList(Activity context, String[] name, String[] publisher, String[] designers, Integer[] imageId) {
        super(context, R.layout.list_single, name);
        this.context = context;
        this.name = name;
        this.publisher = publisher;
        this.designers = designers;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.txt1);
        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.txt2);
        TextView txtTitle3 = (TextView) rowView.findViewById(R.id.txt3);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle1.setText(name[position]);
        txtTitle2.setText(publisher[position]);
        txtTitle3.setText(designers[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
};
public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] name = {
            "   Counter Strike 1.6",
            "   BattleField 3",
            "   NFS Most Wanted",
            "   Prince of Persia",
            "   Diablo",
            "   Darksiders",
            "   Grand Theft Auto V",
            "   Watchdogs",
            "   Call of Duty"
    } ;
    String[] publisher = {
            "Valve Corporation",
            "Electronic Arts",
            "Criterion Games",
            "Ubisoft",
            "Blizzard Entertainment",
            "Vigil Games",
            "Rockstar Games",
            "Ubisoft",
            "Activision"
    } ;
    String[] designers = {
            "1999",
            "2011",
            "2005",
            "2005",
            "2012",
            "2012",
            "2013",
            "2014",
            "2007"
    } ;
    Integer[] imageId = {
            R.drawable.cs,
            R.drawable.bf,
            R.drawable.nfsmw,
            R.drawable.pop,
            R.drawable.diablo,
            R.drawable.ds,
            R.drawable.gta,
            R.drawable.wd,
            R.drawable.cod
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CustomList adapter = new CustomList(MainActivity.this, name, publisher, designers, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        /***
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });***/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
};
