/**
 * Resource:
 * http://blog.csdn.net/x605940745/article/details/11981049
 *
 * http://blog.csdn.net/mkrcpp/article/details/11563083
 * http://www.csdn123.com/html/topnews201408/84/6884.htm
 */
package youzi.studydemos.listView;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import youzi.studydemos.R;

public class SimpleAdapterListActivity extends AppCompatActivity {
    private String[] name = {"张三","李四","王二麻子"};
    private String[] desc = {"张三做豆腐","李四卖馒头","王二麻子的刀"};
    private int[] imageids = {android.R.drawable.alert_dark_frame,android.R.drawable.alert_light_frame,android.R.drawable.arrow_down_float};
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_list);
        list = (ListView)findViewById(R.id.list);
        //list = new ListView(this);
        List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
        for(int i=0;i<name.length;i++){
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("headpic",imageids[i]);
            item.put("name",name[i]);
            item.put("desc",desc[i]);
            items.add(item);
        }
        /*SimpleAdapter的参数说明
		 * 第一个参数 表示访问整个android应用程序接口，基本上所有的组件都需要
		 * 第二个参数表示生成一个Map(String ,Object)列表选项
		 * 第三个参数表示界面布局的id  表示该文件作为列表项的组件
		 * 第四个参数表示该Map对象的哪些key对应value来生成列表项
		 * 第五个参数表示来填充的组件 Map对象key对应的资源一依次填充组件 顺序有对应关系
		 * 注意的是map对象可以key可以找不到 但组件的必须要有资源填充  因为 找不到key也会返回null 其实就相当于给了一个null资源
		 * 下面的程序中如果 new String[] { "name", "head", "desc","name" } new int[] {R.id.name,R.id.head,R.id.desc,R.id.head}
		 * 这个head的组件会被name资源覆盖
		 * */
        SimpleAdapter adapter = new SimpleAdapter(this,
                items,
                R.layout.row_simpleadapter_list,
                new String[]{"headpic","name","desc"},
                new int[]{R.id.headpic,R.id.name,R.id.desc}
        ){//这种扩展的方法有点意思
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final int p=position;
                final View view=super.getView(position,convertView,parent);
                Button btn = (Button)view.findViewById(R.id.button);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(SimpleAdapterListActivity.this, p+"", Toast.LENGTH_SHORT).show();
                        //警告框的写法
                        new AlertDialog.Builder(SimpleAdapterListActivity.this)
                                .setTitle("More")
                                .setMessage("你选中了"+String.valueOf(p))
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        setTitle("点击了对话框上的确定按钮");
                                    }
                                })
                                .setNeutralButton("中立" ,new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        setTitle("点击了对话框上的中立按钮");
                                    }
                                })
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        setTitle("点击了对话框上的取消按钮");
                                    }
                                })
                                .create()
                                .show();
                    }
                });
                return view;
            }

        };
        //设置适配器
        list.setAdapter(adapter);
        //设置背景颜色选择器
        list.setSelector(R.drawable.on_item_selected);

        //设置焦点响应问题   同时要将 item 中的焦点 focusable 设置为 false
        list.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        //设置 item 的监听事件
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //获得 item 里面的文本控件
                TextView text1 = (TextView) view.findViewById(R.id.name);
                Toast.makeText(getApplicationContext(), text1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
