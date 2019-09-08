package com.vmk.solutions.nazgul.notes.notes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vmk.solutions.nazgul.notes.R;
import com.vmk.solutions.nazgul.notes.notes.models.Note;
import com.vmk.solutions.nazgul.notes.util.Constants;

import java.util.ArrayList;

public class NotesAdapters extends RecyclerView.Adapter<NoteViewHolder> {

    ArrayList<Note> noteList;
    Context ctx;

    public NotesAdapters(ArrayList<Note> noteList, Context ctx) {
        this.noteList = noteList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notes, parent, false);

        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, final int i) {
        holder.tvnotetitle.setText(noteList.get(i).getTitle());
        holder.tvnotebody.setText(noteList.get(i).getBody());

        holder.llnoteconteiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, DetailNotesActivity.class);
                intent.putExtra(Constants.extra_note_title, noteList.get(i).getTitle());
                intent.putExtra(Constants.extra_note_body, noteList.get(i).getBody());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
