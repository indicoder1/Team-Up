package com.indicoder.teamup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class GetTeams extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_teams);
        //Toast.makeText(this,"New Activity",Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
        String members=intent.getStringExtra("MEMBERS");
        String groups=intent.getStringExtra("GROUPS");
        int mcount=Integer.parseInt(members);
        int gcount=Integer.parseInt(groups);
        if(gcount>mcount){
            Toast.makeText(this,"Sorry More members than groups",Toast.LENGTH_SHORT).show();
        }
        else{
            int count[]=new int[gcount];
            int minperteam=mcount/gcount;
            Arrays.fill(count,minperteam);
            int tMcount=mcount-gcount*minperteam;
            if(tMcount>0){
                int index=0;
                while(tMcount>0){
                    count[index]++;
                    index++;
                    tMcount--;
                }
            }
            ArrayList<Integer> gen=new ArrayList<Integer>();
            for(int i=1;i<=mcount;i++)
                gen.add(i);
            String finalgroups[]=new String[gcount];
            Arrays.fill(finalgroups,"");
            Random ran=new Random();
            for(int i=0;i<gcount;i++){
                while(count[i]>0) {
                    int Size = gen.size();
                    int index=ran.nextInt(Size);
                    finalgroups[i]=finalgroups[i]+" "+gen.get(index);
                    gen.remove(index);
                    count[i]--;
                }
            }

            ListAdapter theAdapter = new MyAdapter(this,finalgroups);
            ListView theListView=(ListView) findViewById(R.id.listView1);
            theListView.setAdapter(theAdapter);
           // Toast.makeText(this,members+"m g"+groups,Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_teams, menu);
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
}
