package sg.edu.rp.c346.id20026389.myndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Showcase extends AppCompatActivity {
    ListView lvsongs;
    Button btn5star,btnBack;
    ArrayList<Song> al;
//    ArrayAdapter<Song> aa;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcase);
        lvsongs=findViewById(R.id.lvSongs);
        btn5star=findViewById(R.id.btn5Star);
        btnBack=findViewById(R.id.btnBack);
        al = new ArrayList<Song>();
        adapter = new CustomAdapter(this, R.layout.row, al);
//        aa = new ArrayAdapter<Song>(this,
//                android.R.layout.simple_list_item_1, al);
//        lvsongs.setAdapter(aa);
        lvsongs.setAdapter(adapter);
        DBHelper dbh = new DBHelper(Showcase.this);
        al.clear();
        al.addAll(dbh.getAllSongs());
        adapter.notifyDataSetChanged();

        btn5star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(Showcase.this);
                al.clear();
                al.addAll(dbh.getAllSongs5Star());
                adapter.notifyDataSetChanged();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}