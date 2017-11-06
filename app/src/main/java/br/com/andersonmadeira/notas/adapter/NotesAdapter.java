package br.com.andersonmadeira.notas.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.andersonmadeira.notas.EditorActivity;
import br.com.andersonmadeira.notas.R;
import br.com.andersonmadeira.notas.model.Note;

/**
 * Created by anderson on 29/10/17.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    private final Context context;
    private List<Note> notes;

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle, tvExcerpt;
        public long id;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvExcerpt = (TextView) itemView.findViewById(R.id.tvExcerpt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EditorActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putLong("id", id);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

    public NotesAdapter(List<Note> noteList, Context context) {
        this.context = context;
        this.notes = noteList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.tvTitle.setText(note.getTitle());
        holder.tvExcerpt.setText(note.getExcerpt());
        holder.id = note.getId();
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
