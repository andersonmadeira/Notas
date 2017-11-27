package br.com.andersonmadeira.notas.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import br.com.andersonmadeira.notas.EditorActivity;
import br.com.andersonmadeira.notas.MainActivity;
import br.com.andersonmadeira.notas.R;
import br.com.andersonmadeira.notas.Util.Util;
import br.com.andersonmadeira.notas.model.Note;

/**
 * Created by anderson on 29/10/17.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    private MainActivity editor;
    private List<Note> notes;

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        public TextView tvTitle, tvExcerpt, tvUpdatedAt;
        public long id;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvExcerpt = (TextView) itemView.findViewById(R.id.tvExcerpt);
            tvUpdatedAt = (TextView) itemView.findViewById(R.id.tvUpdatedAt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(editor, EditorActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putLong("id", id);
                    intent.putExtras(bundle);
                    editor.startActivity(intent);
                }
            });

            itemView.setLongClickable(true);
            itemView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Selecione uma ação");
            menu.add(0, 0, getAdapterPosition(), "Editar");
            menu.add(0, 1, getAdapterPosition(), "Apagar");
        }
    }

    public NotesAdapter(List<Note> noteList, MainActivity editorActivity) {
        this.editor = editorActivity;
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
        Date date = note.getUpdatedAt();
        holder.tvTitle.setText(note.getTitle());
        holder.tvExcerpt.setText(note.getExcerpt());
        holder.tvUpdatedAt.setText(Util.formatDateFull(note.getUpdatedAt()));
        holder.id = note.getId();
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
