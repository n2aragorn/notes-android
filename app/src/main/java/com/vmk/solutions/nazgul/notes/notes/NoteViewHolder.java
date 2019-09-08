package com.vmk.solutions.nazgul.notes.notes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vmk.solutions.nazgul.notes.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    LinearLayout llnoteconteiner;
    TextView tvnotetitle, tvnotebody;

    public NoteViewHolder(@NonNull View v) {
        super(v);

        llnoteconteiner =v.findViewById(R.id.llnoteconteiner);
        tvnotetitle =v.findViewById(R.id.tvnotetitle);
        tvnotebody = v.findViewById(R.id.tvnotebody);

    }
}
