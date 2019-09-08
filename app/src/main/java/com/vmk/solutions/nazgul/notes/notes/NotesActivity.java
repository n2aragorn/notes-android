package com.vmk.solutions.nazgul.notes.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.vmk.solutions.nazgul.notes.BaseActivity;
import com.vmk.solutions.nazgul.notes.util.Constants;
import com.vmk.solutions.nazgul.notes.LoginActivity;
import com.vmk.solutions.nazgul.notes.R;
import com.vmk.solutions.nazgul.notes.notes.models.Note;

import java.util.ArrayList;

public class NotesActivity extends BaseActivity {

    RecyclerView rvnotes;
    ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        setRecyclerViewData();

        setLogoutEvent();
    }

    private void populateNoteList(){
        noteList = new ArrayList<>();

        noteList.add(new Note("Pasear Perro", "Hace mucho que no sale"));
        noteList.add(new Note("Pasear Gato", "Nunca sale"));
        noteList.add(new Note("Alimentar Perro", "Hace mucho que no come"));
        noteList.add(new Note("Alimentar Loro", "Hace mucho que no habla"));
    }

    private void setRecyclerViewData() {
        rvnotes = findViewById(R.id.rvnotes);

        populateNoteList();

        NotesAdapters adapters = new NotesAdapters(noteList, NotesActivity.this);

        rvnotes.setAdapter(adapters);

        rvnotes.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(NotesActivity.this);

        rvnotes.setLayoutManager(manager);
    }

    private void setLogoutEvent() {
        Button btlogout = findViewById(R.id.btlogout);

        btlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.setPref(Constants.prefs_user, false);
                Intent intent = new Intent(NotesActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
