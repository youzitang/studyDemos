package youzi.studydemos.listView;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list = new ListView(this);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        setContentView(list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ListViewActivity.this,position+""+getStringOfPosition(position),Toast.LENGTH_SHORT).show();
                switch(position){
                    case 0:
                        Intent i = new Intent(ListViewActivity.this,FacnyListActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i1 = new Intent(getApplicationContext(),ArrayAdapterListActivity.class);
                        startActivity(i1);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"没有对应动作",Toast.LENGTH_LONG).show();
                }
                //finish();
            }
        });
    }
    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        data.add("使用简单的ArrayAdapter");
        data.add("使用ArrayAdapter");
        data.add("使用SimpleAdapter");
        data.add("使用BaseAdapter");
        return data;
    }
    private String getStringOfPosition(int position){
        List<String> data = getData();
        return data.get(position);
    }
}
