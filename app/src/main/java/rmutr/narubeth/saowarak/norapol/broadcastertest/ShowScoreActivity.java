package rmutr.narubeth.saowarak.norapol.broadcastertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowScoreActivity extends AppCompatActivity {

    //Explicit
    private TextView showScoreTextView, showDateTextView;
    private int scoreAnInt, timesAnInt;
    private String currentDateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        //Show Score
        showScore();

        //Show Date
        showDate();

        //Update Data to SQLite
        updateDataToSQLite();

    } // Main Method

    private void updateDataToSQLite() {

        String strName = getIntent().getStringExtra("Name");

        MyManage myManage = new MyManage(this);
        myManage.addTest(currentDateString,
                Integer.toString(scoreAnInt),
                Integer.toString(timesAnInt),strName);


    } // updateDataToSQLite

    private void showDate() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        currentDateString = dateFormat.format(date);
        showDateTextView = (TextView) findViewById(R.id.textView7);
        showDateTextView.setText(currentDateString);

    } //showDate

    private void showScore() {

        scoreAnInt = getIntent().getIntExtra("Score", 0);
        timesAnInt = getIntent().getIntExtra("Times", 0);

        showScoreTextView = (TextView) findViewById(R.id.textView8);
        showScoreTextView.setText(Integer.toString(scoreAnInt) + "/" +
        Integer.toString(timesAnInt));

    } //Show Score

    public void clickReadScore(View view) {
        startActivity(new Intent(ShowScoreActivity.this, ListScoreActivity.class));
    } //clickReadScore

} //Main Class
