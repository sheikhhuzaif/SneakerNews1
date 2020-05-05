package com.example.sneakernews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

public class ReleaseAdapter extends ArrayAdapter {
    private static final String TAG = "ReleaseAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private String[] reNames;
    private String[] reDates;
    private String [] reImages;

    public ReleaseAdapter(@NonNull Context context, int resource, String[] reNames, String[] reDates, String[] reImages) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.reNames = reNames;
        this.reDates = reDates;
        this.reImages = reImages;
    }

    @Override
    public int getCount() {
        return reNames.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ReleaseAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);

            viewHolder = new ReleaseAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ReleaseAdapter.ViewHolder) convertView.getTag();
        }
       // FeedEntry currentApp = articles.get(position);
        viewHolder.reName.setText(reNames[position]);
        viewHolder.reDate.setText(reDates[position]);
        try {
            Picasso.get().load(reImages[position]).into(viewHolder.reImage);
        }
        catch(Exception e)
        {
            Log.d(TAG, "getView: Error in picasso");
        }
        return convertView;
    }

    private class ViewHolder {
        final TextView reName;
        final TextView reDate;
        final ImageView reImage;

        ViewHolder(View v) {
            this.reName = v.findViewById(R.id.releaseName);
            this.reImage = v.findViewById(R.id.wtbImage);
            this.reDate=v.findViewById(R.id.releaseDate);
        }

    }
    }

