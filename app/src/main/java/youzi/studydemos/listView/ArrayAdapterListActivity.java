package youzi.studydemos.listView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import youzi.studydemos.R;

public class ArrayAdapterListActivity extends AppCompatActivity {
    String[] Items = {"A","B","C"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_list);
        ListView list = (ListView)findViewById(R.id.list);
        //list.setAdapter(new ArrayAdapter<String>(this, R.layout.row_fancy_list,R.id.label, getData()));
        list.setAdapter(new myArrayAdapter());
    }
    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        return data;
    }
    class myArrayAdapter extends ArrayAdapter{
        public myArrayAdapter() {
            super(getApplicationContext(),R.layout.row_fancy_list,getData());
        }
        public View getView(int position, View convertView, ViewGroup parent){
            View itemView = convertView;
            ViewHolder holder = null;
            if(itemView == null) {
                LayoutInflater li = getLayoutInflater();
                itemView = li.inflate(R.layout.row_fancy_list, parent, false);
                holder = new ViewHolder(itemView);
                //设置持有者 所有View对象都有getTag()和setTag()方法 通过这两个方法可以在任何对象与部件之间建立联系
                //在持有者模式中，tag用来保存对象，而对象又用来保存要使用的子部件，将持有者添加到行视图之后，只要用到了行，就可以方便访问子部件，不用每次都获取部件
                itemView.setTag(holder);
            }else{
                holder = (ViewHolder)itemView.getTag();
            }
            //TextView label = (TextView) itemView.findViewById(R.id.label);//itemView 必须加
            //label.setText(getItem(position).toString());
            holder.getLabel().setText(getItem(position).toString());
            //label.setText(Items[position]);
            return itemView;
        }
    }
}
//持有者模式
class ViewHolder{
    View base;
    TextView label = null;
    public ViewHolder(View base) {
        this.base = base;
    }

    TextView getLabel(){
        if(label == null){
            label = (TextView)base.findViewById(R.id.label);
        }
        return label;
    }
}

