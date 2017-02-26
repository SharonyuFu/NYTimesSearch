package com.codepath.nytimessearch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.codepath.nytimessearch.Article;
import com.codepath.nytimessearch.ArticleArrayAdapter;
import com.codepath.nytimessearch.EndlessScrollListener;
import com.codepath.nytimessearch.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.io.Serializable;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

import static com.loopj.android.http.AsyncHttpClient.log;

public class SearchActivity extends AppCompatActivity implements Serializable {

    EditText etQuery;
    GridView gvResults;
    Button btnSearch;
    ArrayList<Article> articles;
    ArticleArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupViews();



        gvResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(),ArticleActivity.class);
                Article article = articles.get(position);
                i.putExtra("article", Parcels.wrap(article));
                startActivity(i);

            }
        });

//        gvResults.setOnScrollListener(new EndlessScrollListener() {
//            @Override
//            public boolean onLoadMore(int page, int totalItemsCount) {
//                // Triggered only when new data needs to be appended to the list
//                // Add whatever code is needed to append new items to your AdapterView
//
//                loadNextDataFromApi(page);
//
//                // or loadNextDataFromApi(totalItemsCount);
//                return true; // ONLY if more data is actually being loaded; false otherwise.
//            }
//        });
    

    }
//
//    public void loadNextDataFromApi(int offset) {
//
//
//    }

    private void showFilterDialog() {
        FragmentManager fm = getSupportFragmentManager();
        Filter filterFragmnet = Filter.newInstance("Some Title");
        filterFragmnet.show(fm, "fragment_edit_name");

    }

    public void setupViews() {
        etQuery = (EditText) findViewById(R.id.etQuery);
        gvResults = (GridView) findViewById(R.id.gvResults);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        articles = new ArrayList<>();
        adapter = new ArticleArrayAdapter(this,articles);
        gvResults.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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

    public void onArticleSearch(View view) {

        String query = etQuery.getText().toString();
//        Toast.makeText(this,"Search For " + query,Toast.LENGTH_LONG).show();
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("api-key", "1244891bfb134e8bb3f4f0c7a9fd3271");
        params.put("page",0);
        params.put("q",query);
        String url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?";
        client.get(url,params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                JSONArray articleJsonResults = null;

                try{
                    articleJsonResults = response.getJSONObject("response").getJSONArray("docs");
                    adapter.addAll(Article.fromJSONArray(articleJsonResults));
                    log.d("sceesss",adapter.toString());



                }catch(JSONException e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    public void onComposeAction(MenuItem item) {
        showFilterDialog();
    }
}
