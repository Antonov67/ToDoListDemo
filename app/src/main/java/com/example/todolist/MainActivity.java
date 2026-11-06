package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<String> tasks = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private EditText editText;
    private Button button;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                tasks
        );

        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasks.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tasks.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Удалено", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}