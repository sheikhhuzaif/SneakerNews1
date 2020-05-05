package com.example.sneakernews;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class wtb_activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feeds_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.newsMenu)
        {
            Intent intent=new Intent(this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }
        else if (id==R.id.guideMenu)
        {
            Intent intent=new Intent(this, buying_guide.class);
            this.startActivity(intent);
            return true;
        }
        else if (id==R.id.releasesMenu)
        {
            Intent intent=new Intent(this, releases_activity.class);
            this.startActivity(intent);
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wtb_list);



        TextView Nike= (TextView) findViewById(R.id.textView);
        Nike.setMovementMethod(LinkMovementMethod.getInstance());
        Nike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(wtb_activity.this, webView.class);
                intent.putExtra("url", "http://www.nike.com");
                startActivity(intent);
            }
        });
        TextView Adidas= (TextView) findViewById(R.id.textView2);
        Adidas.setMovementMethod(LinkMovementMethod.getInstance());
        Adidas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(wtb_activity.this, webView.class);
                intent.putExtra("url", "http://www.adidas.com");
                startActivity(intent);
            }
        });
        TextView Goat= (TextView) findViewById(R.id.textView3);
        Goat.setMovementMethod(LinkMovementMethod.getInstance());
        Goat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(wtb_activity.this, webView.class);
                intent.putExtra("url", "http://www.goat.com");
                startActivity(intent);
            }
        });
        TextView StockX= (TextView) findViewById(R.id.textView4);
        StockX.setMovementMethod(LinkMovementMethod.getInstance());
        StockX.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(wtb_activity.this, webView.class);
                intent.putExtra("url", "http://www.stockx.com");
                startActivity(intent);
            }
        });
        TextView SG= (TextView) findViewById(R.id.textView5);
        SG.setMovementMethod(LinkMovementMethod.getInstance());
        SG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(wtb_activity.this, webView.class);
                intent.putExtra("url", "http://www.stadiumgoods.com");
                startActivity(intent);
            }
        });
    }
}
