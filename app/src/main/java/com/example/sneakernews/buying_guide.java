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

public class buying_guide extends AppCompatActivity {

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
        else if (id==R.id.wtbMenu)
        {
            Intent intent=new Intent(this, wtb_activity.class);
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
        setContentView(R.layout.b_guide);



        TextView fullart= (TextView) findViewById(R.id.textView19);
        fullart.setMovementMethod(LinkMovementMethod.getInstance());
        fullart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(buying_guide.this ,webView.class);
                intent.putExtra("url", "https://onpointfresh.com/complete-beginners-guide-sneakers/");
                startActivity(intent);
            }
        });
    }
}
