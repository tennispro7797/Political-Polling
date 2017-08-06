package com.example.adityamohile.politicalpolling;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String,Void,String>{
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker(Context cntxt) {
        this.context = cntxt;
    }
    @Override
    protected String doInBackground(String... params) {
        String postQ = params[0];
        String postD = params[1];
        String url2 = "http://192.168.0.6/test.php";
        URL url = null;
        try {
            url = new URL(url2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("question","UTF-8")+"="+URLEncoder.encode(postQ,"UTF-8")+
                    "&"+URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(postD,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line;
            while ((line=bufferedReader.readLine())!= null){
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.alertDialog = new AlertDialog.Builder(context).create();
        this.alertDialog.setTitle("POST Request Result");
    }

    @Override
    protected void onPostExecute(String result) {
        this.alertDialog.setMessage(result);
        Log.v("result",result);
        this.alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
