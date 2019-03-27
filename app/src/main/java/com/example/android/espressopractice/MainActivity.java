package com.example.android.espressopractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.espressopractice.db.Person;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private EditText mFirstNameEditText, mLastNameEditText, mMiddleNameEditText;
    private Button mSubmitButton;
    private ExecutorService mExecutorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListener();
        mExecutorService = Executors.newSingleThreadExecutor();
    }

    private void initViews() {
        mFirstNameEditText = findViewById(R.id.first_name_edit_text);
        mLastNameEditText = findViewById(R.id.last_name_edit_text);
        mMiddleNameEditText = findViewById(R.id.middle_name_edit_text);
        mSubmitButton = findViewById(R.id.submit_btn);
    }

    private void initListener() {
        mSubmitButton.setOnClickListener((v) -> {
            Person person = new Person();
            person.setFirstName(mFirstNameEditText.getText().toString());
            person.setLastName(mLastNameEditText.getText().toString());
            person.setMiddleName(mMiddleNameEditText.getText().toString());
            Log.i(getClass().getName(),person.toString());
            mExecutorService.execute(() -> {
                System.out.println(person);
                PersonApplication.getPersonDatabase().getPersonDao().insert(person);
                    }
            );
            startActivity(PersonsActivity.newInstance(MainActivity.this));
        });
    }
}
