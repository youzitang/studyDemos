package youzi.studydemos.listView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import youzi.studydemos.R;

public class FacnyListActivity extends AppCompatActivity {
    String[] items={"A","B","C","D","E"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facny_list);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this, R.layout.row_fancy_list,R.id.label, items));
    }
}
