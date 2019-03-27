package com.example.android.espressopractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.espressopractice.R;
import com.example.android.espressopractice.db.Person;

public class PersonInfoActivity extends AppCompatActivity {

    private static final String PERSON_EXTRA = "person";

    private TextView mFirstNameTextView, mLastNameTextView, mMiddleNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        initViews();
    }

    private void initViews() {
        mFirstNameTextView = findViewById(R.id.first_name_text_view);
        mLastNameTextView = findViewById(R.id.last_name_text_view);
        mMiddleNameTextView = findViewById(R.id.middle_name_text_view);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            Person person = (Person) bundle.getSerializable(PERSON_EXTRA);
            mFirstNameTextView.setText(person.getFirstName());
            mLastNameTextView.setText(person.getLastName());
            mMiddleNameTextView.setText(person.getMiddleName());
        }
    }

    public static Intent newInstance(Context context, Person person) {
        Intent intent = new Intent(context, PersonInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(PERSON_EXTRA, person);
        intent.putExtras(bundle);
        return intent;
    }
}
