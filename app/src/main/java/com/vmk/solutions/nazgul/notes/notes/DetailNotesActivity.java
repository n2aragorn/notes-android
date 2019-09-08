package com.vmk.solutions.nazgul.notes.notes;

import android.os.Bundle;
import android.widget.TextView;

import com.vmk.solutions.nazgul.notes.BaseActivity;
import com.vmk.solutions.nazgul.notes.util.Constants;
import com.vmk.solutions.nazgul.notes.R;

public class DetailNotesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notes);

        String noteTitle = getIntent().getStringExtra(Constants.extra_note_title);
        String noteBody = getIntent().getStringExtra(Constants.extra_note_body);

        TextView tvnotetitle = findViewById(R.id.tvnotetitle);
        TextView tvnotebody = findViewById(R.id.tvnotebody);

        tvnotetitle.setText(noteTitle);
        tvnotebody.setText(noteBody);
    }
}
