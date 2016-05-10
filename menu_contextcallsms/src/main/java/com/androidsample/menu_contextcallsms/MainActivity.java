package com.androidsample.menu_contextcallsms;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public class NameNumber {
        String name;
        String number;
    }

    NameNumberAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        myAdapter = new NameNumberAdapter();

        ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(myAdapter);

        registerForContextMenu(lv);
    }


    public class NameNumberAdapter extends BaseAdapter {

        List<NameNumber> myList = getDataForListView();

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return myList.size();
        }

        @Override
        public NameNumber getItem(int arg0) {
            // TODO Auto-generated method stub
            return myList.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            if (arg1 == null) {
                LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                arg1 = inflater.inflate(R.layout.row_layout, arg2, false);
            }

            TextView tv1 = (TextView) arg1.findViewById(R.id.textView);
            TextView tv2 = (TextView) arg1.findViewById(R.id.textView2);

            NameNumber nameNumber = myList.get(arg0);
            tv1.setText(nameNumber.name);
            tv2.setText(nameNumber.number);
            return arg1;
        }



    }

    public List<NameNumber> getDataForListView()
    {
        List<NameNumber> myList = new ArrayList<>();

        NameNumber nameNumber =new NameNumber();

        nameNumber.name="Name 1";
        nameNumber.number="Phone Number 1";
        myList.add(nameNumber);

        nameNumber =new NameNumber();
        nameNumber.name="Name 2";
        nameNumber.number="Phone Number 2";
        myList.add(nameNumber);

        nameNumber =new NameNumber();
        nameNumber.name="Name 3";
        nameNumber.number="Phone Number 3";
        myList.add(nameNumber);

        nameNumber =new NameNumber();
        nameNumber.name="Name 4";
        nameNumber.number="Phone Number 4";
        myList.add(nameNumber);

        nameNumber =new NameNumber();
        nameNumber.name="Name 5";
        nameNumber.number="Phone Number 5";
        myList.add(nameNumber);

        return myList;

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }

   /* @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }*/
}


