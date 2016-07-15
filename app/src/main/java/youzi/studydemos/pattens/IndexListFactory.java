package youzi.studydemos.pattens;

import android.app.Activity;

import youzi.studydemos.listView.ListViewActivity;

/**
 * Created by tier on 2016/7/15.
 */
public class IndexListFactory {
    public static Class getInstanceByIndex(int index){
        Activity activity = null;
        switch(index){
            case 0:
                activity=new ListViewActivity();
            break;
        }

        return activity.getClass();
    }
}
