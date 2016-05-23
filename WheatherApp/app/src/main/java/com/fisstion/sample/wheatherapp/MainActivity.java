package com.fisstion.sample.wheatherapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import model.Forecast;
import model.WhaetherInfo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button webServicesButton;
    private OkHttpClient okHttpClient;
    private Request request;
    private Response response;
    ArrayList<Forecast> arrayForeCast;
    private final String TAG = "MainActivity";
    private final String webServiceURL = " https://query.yahooapis.com/v1/public/yql?q=select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=%22hyderabad, in%22)&format=json";

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   context = this;
        webServicesButton = (Button) findViewById(R.id.gettingWebservices);
        okHttpClient=new OkHttpClient();
        webServicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callServiceAndGetData();


            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void callServiceAndGetData() {

        if (isNetworkEnabled()) {
            new CallWebServiceAsync().execute();
        } else {
            //Show alert dialog to user saying that "You don't have network connection. Please check your Internet".
            //TODO need to create an alert dialog.

        }

    }


    private boolean isNetworkEnabled() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.fisstion.sample.wheatherapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.fisstion.sample.wheatherapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    private class CallWebServiceAsync extends AsyncTask<Void, Void, Void> {

        // To store result
        private String webServiceResult = null;

        // To show some loader to user please wait. And to initialize service.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //Here we will hit the server and get some data
        @Override
        protected Void doInBackground(Void... params) {
            webServiceResult = downloadData();
            Log.d("webservice","result");
            return null;
        }

        //After getting the data. process it and show in UI
        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);

            formatData(webServiceResult);

        }
    }

    private void formatData(String resultJSON) {


        //Simple way of parsing JSON data using GSON library.
        ArrayList<Forecast> arrayForeCast = new ArrayList<Forecast>();

        WhaetherInfo whaetherInfo = new Gson().fromJson(resultJSON, WhaetherInfo.class);

        arrayForeCast = whaetherInfo.getQuery().getResults().getChannel().getItem().getForecast();

        // Normal for loop to loop employees array.
        for (int i = 0; i < arrayForeCast.size(); i++) {

            Forecast forecast = arrayForeCast.get(i);
            Log.v(TAG, "Name " + forecast.getText());
           Log.v(TAG,"temparature"+forecast.getHigh());
            Log.v(TAG, "code " + forecast.getCode());


        }

        // For each loop to get employess.


    }

    private String downloadData() {
        String Result=null;
        try{
             request = new Request.Builder()
                    .url(webServiceURL)
                    .build();
            response = okHttpClient.newCall(request).execute();
            Result=response.body().string();

        }
        catch (Exception e){
            e.printStackTrace();
            Result=null;

        }
        return Result;

    }


    private String readInputStream(InputStream inputStream) throws UnsupportedEncodingException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
*/

    }
}









