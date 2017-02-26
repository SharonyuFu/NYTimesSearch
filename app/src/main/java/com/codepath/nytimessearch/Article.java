package com.codepath.nytimessearch;

import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;
import org.parceler.ParcelFactory;

import java.util.ArrayList;
import java.util.Date;

import static com.loopj.android.http.AsyncHttpClient.log;

/**
 * Created by sharonyu on 2017/2/25.
 */

@com.codepath.nytimessearch.Parcel
public class Article implements Parcelable {

    public String getWebUrl() {
        return webUrl;
    }

    public String getHeadline() {
        return headline;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    String webUrl;
    String headline;
    String thumbNail;

    public String getPubDate() {
        return pubDate;
    }

    public String getNewsDesk() {
        return newsDesk;
    }

    String pubDate;
    String newsDesk;

    public Article (JSONObject jsonObject){
        try{
            this.webUrl = jsonObject.getString("web_url");
            this.headline = jsonObject.getJSONObject("headline").getString("main");

            JSONArray multimedia = jsonObject.getJSONArray("multimedia");

            if (multimedia.length() > 0){
                JSONObject multimediaJson = multimedia.getJSONObject(0);
                this.thumbNail = "http://www.nytimes.com/" + multimediaJson.getString("url");

            } else{
                this.thumbNail = "";
            }

            this.pubDate = jsonObject.getString("pub_date");
            this.newsDesk = jsonObject.getString("newsDesk");

        }catch(JSONException e){

        }
    }

    @ParcelFactory
    public static ArrayList<Article> fromJSONArray(JSONArray array) {
        ArrayList<Article> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Article(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(this.webUrl);
        dest.writeString(this.headline);
        dest.writeString(this.thumbNail);

    }

    protected Article(android.os.Parcel in) {
        this.webUrl = in.readString();
        this.headline = in.readString();
        this.thumbNail = in.readString();

    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        @Override
        public Article createFromParcel(android.os.Parcel source) {
            return new Article(source);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
