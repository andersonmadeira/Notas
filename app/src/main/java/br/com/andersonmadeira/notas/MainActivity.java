package br.com.andersonmadeira.notas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.andersonmadeira.notas.adapter.NotesAdapter;
import br.com.andersonmadeira.notas.model.Note;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;
    private MainActivity activity;
    private RecyclerView recyclerView;
    private List<Note> noteList = new ArrayList<>();
    private NotesAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, EditorActivity.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myAdapter = new NotesAdapter(noteList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

        prepareNotes();
    }

    private void prepareNotes() {
        Note note = new Note("Mad Max: Fury Road", "Action & Adventure");
        noteList.add(note);

        note = new Note("Inside Out", "Animation, Kids & Family");
        noteList.add(note);

        note = new Note("Star Wars: Episode VII - The Force Awakens", "Action");
        noteList.add(note);

        note = new Note("Shaun the Sheep", "Animation");
        noteList.add(note);

        note = new Note("The Martian", "Science Fiction & Fantasy");
        noteList.add(note);

        note = new Note("Mission: Impossible Rogue Nation", "Action");
        noteList.add(note);

        note = new Note("Up", "Animation");
        noteList.add(note);

        note = new Note("Star Trek", "Science Fiction");
        noteList.add(note);

        note = new Note("The LEGO Movie", "Animation");
        noteList.add(note);

        note = new Note("Iron Man", "Action & Adventure");
        noteList.add(note);

        note = new Note("Aliens", "Science Fiction");
        noteList.add(note);

        note = new Note("Chicken Run", "Animation");
        noteList.add(note);

        note = new Note("Back to the Future", "Science Fiction");
        noteList.add(note);

        note = new Note("Raiders of the Lost Ark", "Action & Adventure");
        noteList.add(note);

        note = new Note("Goldfinger", "Action & Adventure");
        noteList.add(note);

        note = new Note("Guardians of the Galaxy", "Science Fiction & Fantasy");
        noteList.add(note);

        myAdapter.notifyDataSetChanged();
    }
}
