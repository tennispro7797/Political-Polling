package com.example.adityamohile.politicalpolling;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class AnswerPollActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    private String questionID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_poll);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Answer Poll");

        this.alertDialog = new AlertDialog.Builder(this).create();
        this.alertDialog.setTitle("Response Recorded Result");

        questionID = getIntent().getExtras().getString("id")+"";
        String question = getIntent().getExtras().getString("question");
        String description = getIntent().getExtras().getString("description");
        TextView pollQ = (TextView) findViewById(R.id.pollQuestion);
        TextView pollD = (TextView) findViewById(R.id.pollDescription);
        pollQ.setText(question);
        pollD.setText(description);
    }

    public void answeredYes(View v) {
        HashMap<String,String> postData = new HashMap<>();
        postData.put("id",questionID);
        postData.put("response","Yes");

        PostResponseAsyncTask task1 = new PostResponseAsyncTask(AnswerPollActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if (s.contains("Response Recorded!")) {

                }
                Log.v("Post",s);
                alertDialog.setMessage(s);
                alertDialog.show();
            }
        });
        task1.execute("http://10.0.2.2/insertResponse.php");

    }

    public void answeredNo(View v) {

        HashMap<String,String> postData = new HashMap<>();
        postData.put("id",questionID);
        postData.put("response","No");

        PostResponseAsyncTask task1 = new PostResponseAsyncTask(AnswerPollActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if (s.contains("Response Recorded!")) {

                }
                Log.v("Post",s);
                alertDialog.setMessage(s);
                alertDialog.show();
            }
        });
        task1.execute("http://10.0.2.2/insertResponse.php");
    }

    public void answeredNeither(View v) {

        HashMap<String,String> postData = new HashMap<>();
        postData.put("id",questionID);
        postData.put("response","No Opinion");

        PostResponseAsyncTask task1 = new PostResponseAsyncTask(AnswerPollActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if (s.contains("Response Recorded!")) {

                }
                Log.v("Post",s);
                alertDialog.setMessage(s);
                alertDialog.show();
            }
        });
        task1.execute("http://10.0.2.2/insertResponse.php");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}