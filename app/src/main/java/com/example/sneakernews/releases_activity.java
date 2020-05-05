package com.example.sneakernews;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class releases_activity extends AppCompatActivity {
    private static final String TAG = "releases_activity";
    public String[] Names= new String[10];
    public String[] Dates= new String[10];
    public String[] Images=new String[10];
    private ListView listArts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        new downData().execute();
        listArts = (ListView) findViewById(R.id.xmlListView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feeds_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.wtbMenu)
        {
            Intent intent=new Intent(this, wtb_activity.class);
            this.startActivity(intent);
            return true;
        }
        else if (id==R.id.guideMenu)
        {
            Intent intent=new Intent(this, buying_guide.class);
            this.startActivity(intent);
            return true;
        }
        else if (id==R.id.newsMenu)
        {
            Intent intent=new Intent(this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }

    public class downData extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try{
                int i=0;
                int j=0;
                int k=0;

                Document document= Jsoup.connect("https://sneakernews.com/release-dates/").get();
                Elements element=document.select("div.content-box > h2");
                Elements element2=document.select("div.content-box > div.release-date-and-rating > span");
                Elements element3=document.select(".image-box");
                for(Element e: element) {
                    Names[i]=e.text();
                    //System.out.println(e.text());
                    i++;
                }
                for (Element f: element2){
                    Dates[j]=f.text();
                    // System.out.println(f.text());
                    j++;
                }
                for (Element e: element3){
                    Images[k]=e.select("img").attr("src");
                    //System.out.println(e.select("img").attr("src"));
                    k++;
                }

            }
            catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            int x=0;
//            while(x<10){
//                System.out.println(Names[x]+"\n"+Dates[x]+"\n"+Images[x]);
//                x++;
//            }
            ReleaseAdapter releaseAdapter=new ReleaseAdapter(releases_activity.this, R.layout.releases_list, Names, Dates, Images);
            listArts.setAdapter(releaseAdapter);
        }
    }

}
