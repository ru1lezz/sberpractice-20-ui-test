package com.example.android.espressopractice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.espressopractice.db.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> mPersonList;

    public PersonAdapter() {
        mPersonList = new ArrayList<>();
    }

    public void setPersonList(List<Person> personList) {
        mPersonList.clear();
        mPersonList.addAll(personList);
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_list_item, viewGroup, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int i) {
        personViewHolder.bind(mPersonList.get(i));
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mFirstNameTextView, mLastNameTextView, mMiddleNameTextView;
        private Person person;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews();
            itemView.setOnClickListener(this);
        }

        private void initViews() {
            mFirstNameTextView = itemView.findViewById(R.id.first_name_text_view);
            mLastNameTextView = itemView.findViewById(R.id.last_name_text_view);
            mMiddleNameTextView = itemView.findViewById(R.id.middle_name_text_view);
        }

        public void bind(Person person) {
            this.person = person;
            mFirstNameTextView.setText(person.getFirstName());
            mLastNameTextView.setText(person.getLastName());
            mMiddleNameTextView.setText(person.getMiddleName());
        }

        public String getFirstName() {
            return mFirstNameTextView.getText().toString();
        }

        public String getLastName() {
            return mLastNameTextView.getText().toString();
        }

        public String getMiddleName() {
            return mMiddleNameTextView.getText().toString();
        }
        @Override
        public void onClick(View v) {
            Intent intent = PersonInfoActivity.newInstance(v.getContext(), person);
            v.getContext().startActivity(intent);
        }
    }
}