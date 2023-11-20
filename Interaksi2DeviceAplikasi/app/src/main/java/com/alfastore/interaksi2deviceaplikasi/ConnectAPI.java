package com.alfastore.interaksi2deviceaplikasi;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ConnectAPI extends AsyncTask<String, Void, String> {
    /**
     * Catatan AsyncTask
     * Param 1 = use in .execute(...) paramater and doInBackground(...) parameter
     * Param 2 = use in publishProgress(...) paramater doInBackground and onProgressUpdate(...) parameter
     * Param 3 = use in get return from doInBackground and onPostExecute(...) paramater
     */

    private JsonObject postData;
    private StringBuilder result;

    @Override
    protected String doInBackground(String... method) {
        HttpURLConnection urlConnection = null;

        try {
            // add query or path in url
            if (result != null){
                URL url = new URL("https://reqres.in/api/users?" + result);
                Log.i("TESAPI", url.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
            }else {
                URL url = new URL("https://reqres.in/api/users");
                Log.i("TESAPI", url.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
            }


            // Add Header
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Content-Language", "en-US");

            urlConnection.setRequestMethod(method[0]);
            urlConnection.setChunkedStreamingMode(0);
            urlConnection.setDoInput(true);

            if (method[0].equals("POST")){
                urlConnection.setDoOutput(true);

                try{
                    OutputStream out2 = new BufferedOutputStream(urlConnection.getOutputStream());
                    BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(
                            out2, "UTF-8"));
                    writer2.write(postData.toString());
                    writer2.flush();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


            int code = urlConnection.getResponseCode();
            if (code ==  200) {
                Log.i("TESAPI", "Everything is OK");
            }else if (code ==  201) {
                Log.i("TESAPI", "Created");
            }else {
                throw new IOException("Invalid response from server: " + code);
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()
            ));

            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject jsonObject = new JSONObject(s);
            String page = jsonObject.getString("page");

            String namaLengkap = null;
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++){
                String namaDepan = jsonArray.getJSONObject(i).getString("first_name");
                String namaBelakang = jsonArray.getJSONObject(i).getString("last_name");

                namaLengkap = namaDepan + " " + namaBelakang;
            }

            // Get from JSON Object
            Log.e("TESAPI", "PAGE : " + page);
            // Get from JSON Array
            Log.e("TESAPI", "NAMA : " + namaLengkap);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    protected void queryParamMethodPOST(String property, String value){
        postData = new JsonObject();
        postData.addProperty(property, value);
    }

    protected void setQuery(HashMap<String, String> params) throws UnsupportedEncodingException
    {
        result = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
    }
}
