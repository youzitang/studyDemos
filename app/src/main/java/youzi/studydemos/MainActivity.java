package youzi.studydemos;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import youzi.studydemos.pattens.IndexListFactory;

import static youzi.studydemos.pattens.IndexListFactory.getInstanceByIndex;

public class MainActivity extends Activity {
    TextView selection;
    String[] items={"①ListView"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, items));
        //下面这两行是动态创建
        //ListView list = new ListView(this);
        //setContentView(list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),position+":"+items[position],Toast.LENGTH_SHORT).show();
                //工厂方法获取要加载的类
                Class activity = getInstanceByIndex(position);
                Intent i=new Intent(MainActivity.this,activity);
                startActivity(i);
            }
        });
    }
    public void DisplayToast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
