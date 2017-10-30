package br.com.andersonmadeira.notas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.andersonmadeira.notas.R;
import br.com.andersonmadeira.notas.model.Note;

/**
 * Created by anderson on 29/10/17.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    private List<Note> notes;

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, content;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }

    public NotesAdapter(List<Note> noteList) {
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
        holder.title.setText(note.getTitle());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
