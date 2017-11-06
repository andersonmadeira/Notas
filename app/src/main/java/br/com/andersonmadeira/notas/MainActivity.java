package br.com.andersonmadeira.notas;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.ListPreference;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.andersonmadeira.notas.adapter.NotesAdapter;
import br.com.andersonmadeira.notas.model.Note;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;
    private MainActivity thisActivity;
    private RecyclerView recyclerView;
    private List<Note> noteList = new ArrayList<>();
    private NotesAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
                LayoutInflater inflater = thisActivity.getLayoutInflater();

                builder.setView(inflater.inflate(R.layout.note_name_input_layout, null))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView tvTitle = ((TextView) ((AlertDialog)dialog).findViewById(R.id.etTitle));
                                String title = tvTitle.getText().toString();

                                Intent intent = new Intent(thisActivity, EditorActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("id", 0);
                                bundle.putString("tvTitle", title);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // pass
                            }
                        });

                builder.show();

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myAdapter = new NotesAdapter(noteList, thisActivity);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        List<Note> elems = Note.listAll(Note.class);

        noteList.clear();

        for ( Note n : elems ) {
            Log.d("tvTitle: ", n.toString());
            noteList.add(n);
        }

        myAdapter.notifyDataSetChanged();
    }
}
