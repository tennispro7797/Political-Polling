package com.example.adityamohile.politicalpolling;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class PollPostActivity extends AppCompatActivity {

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_post);
        this.alertDialog = new AlertDialog.Builder(this).create();
        this.alertDialog.setTitle("POST Request Result");

    }

    public void submitQuestion(View v) {

        final EditText postQuestion = (EditText) findViewById(R.id.enterQuestion);
        final EditText postDescription = (EditText) findViewById(R.id.enterDescription);
        String postQ = postQuestion.getText().toString();
        String postD = postDescription.getText().toString();

        HashMap<String,String> postData = new HashMap<>();
        postData.put("question",postQ);
        postData.put("description",postD);

        PostResponseAsyncTask task1 = new PostResponseAsyncTask(PollPostActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if (s.contains("Successful")) {
                    postQuestion.setText("");
                    postDescription.setText("");
                }
                Log.v("Post",s);
                alertDialog.setMessage(s);
                alertDialog.show();
            }
        });
        task1.execute("http://10.0.2.2/test.php");
    }
}
