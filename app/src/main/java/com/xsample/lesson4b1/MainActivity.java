package com.xsample.lesson4b1;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadBrowser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        if(intent.resolveActivity(getPackageManager())!=null)  /*In here there is no risk of having a null package manager*/
            startActivity(intent);
    }

    public void getCall(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:0716734283"));
        startActivity(intent);
    }

    public void showLocation(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:79,81"));
        startActivity(intent);
    }

    public void browseIt(View view) {
        EditText editText = findViewById(R.id.editText);
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        String query = editText.getText().toString();
        intent.putExtra(SearchManager.QUERY,query);
        if (intent.resolveActivity(getPackageManager())!=null)
            startActivity(intent);
    }

    public void createAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "la")
                .putExtra(AlarmClock.EXTRA_LENGTH, 10)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        }
    }


/*  public void createNote(String subject, String text) {
        Intent intent = new Intent(NoteIntents.ACTION_CREATE_NOTE)
                .putExtra(NoteIntents.EXTRA_NAME, subject)
                .putExtra(NoteIntents.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }*/

