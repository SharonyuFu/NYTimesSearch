package com.codepath.nytimessearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static com.loopj.android.http.AsyncHttpClient.log;

/**
 * Created by sharonyu on 2017/2/25.
 */

public class ArticleArrayAdapter extends ArrayAdapter<Article> {
    public ArticleArrayAdapter(Context context, List<Article> articles){
        super(context,android.R.layout.simple_list_item_1,articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Article article = this.getItem(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_article_result,parent,false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);
        imageView.setImageResource(0);

        TextView tvTitles = (TextView) convertView.findViewById(R.id.tvTitle);
        tvTitles.setText(article.getHeadline());

        String thumbnail = article.getThumbNail();
        log.d("a",thumbnail.toString());

        if(!TextUtils.isEmpty(thumbnail)){
            Picasso.with(getContext()).load(thumbnail).fit().centerCrop()
                    .placeholder(R.drawable.noimagefound)
                    .error(R.drawable.noimagefound).into(imageView);
        }else{
            imageView.setImageResource(R.drawable.noimagefound);
        }

        return convertView;
    }
}
