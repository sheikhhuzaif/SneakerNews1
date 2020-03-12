package com.example.sneakernews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> articles;

    public FeedAdapter(@NonNull Context context, int resource, List<FeedEntry> articles) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.articles = articles;
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


//        TextView tvName =(TextView) convertView.findViewById(R.id.tvName);
//        TextView tvCreator=(TextView) convertView.findViewById(R.id.tvCreator);
//        TextView textPubDate=(TextView) convertView.findViewById(R.id.textPubDate);
//        TextView tvDescription=(TextView) convertView.findViewById(R.id.tvDescription);
        FeedEntry currentApp = articles.get(position);
        viewHolder.tvName.setText(currentApp.getTitle());
        viewHolder.tvCreator.setText(currentApp.getCreator());
        viewHolder.textPubDate.setText(currentApp.getPubDate());
        viewHolder.tvDescription.setText(currentApp.getDescription());
        return convertView;
    }

    private class ViewHolder {
        final TextView tvName;
        final TextView tvCreator;
        final TextView textPubDate;
        final TextView tvDescription;

        ViewHolder(View v) {
            this.tvName = v.findViewById(R.id.tvName);
            this.tvCreator = v.findViewById(R.id.tvCreator);
            this.textPubDate = v.findViewById(R.id.textPubDate);
            this.tvDescription = v.findViewById(R.id.tvDescription);
        }
    }
}
