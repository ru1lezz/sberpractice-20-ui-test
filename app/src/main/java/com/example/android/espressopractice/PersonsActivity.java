package com.example.android.espressopractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PersonsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private PersonAdapter mAdapter;
    private ExecutorService mExecutorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        initRecyclerView();
        mExecutorService = Executors.newSingleThreadExecutor();
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(PersonsActivity.this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL));
        mAdapter = new PersonAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mExecutorService.execute(() -> {
            mAdapter.setPersonList(PersonApplication.getPersonDatabase().getPersonDao().getPersonList());
        });
    }

    public static Intent newInstance(Context context) {
        return new Intent(context, PersonsActivity.class);
    }
}
