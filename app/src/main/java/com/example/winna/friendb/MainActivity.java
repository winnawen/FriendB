package com.example.winna.friendb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.friendLv);
        lv.setAdapter(adapter);
    }
    private BaseAdapter adapter = new BaseAdapter() {


        private customlistcelldata[] data = new customlistcelldata[]{
                new customlistcelldata("fir1", "1", R.drawable.me_icon_head),
                new customlistcelldata("fir2", "2", R.drawable.me_icon_head),
                new customlistcelldata("fir3", "3", R.drawable.me_icon_head),

        };
        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public customlistcelldata getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            LinearLayout ll = null;
            if (convertView != null) {
                ll = (LinearLayout) convertView;
            } else {
                ll = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_custom_listcell, null);
            }
            customlistcelldata data = getItem(position);
            ImageView icon = (ImageView) ll.findViewById(R.id.imgv);
            TextView name = (TextView) ll.findViewById(R.id.tvname);
            TextView dec = (TextView) ll.findViewById(R.id.tvnum);

            icon.setImageResource(data.iconId);
            name.setText(data.name);
            dec.setText(data.dec);

            return ll;

        }
    };
}
