package com.anningtex.excelcontenttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song
 * desc: 实现Excel表格，且表格能左右、上下滑动
 */
public class MainActivity extends AppCompatActivity {

    private NoScrollListView mLeft;
    private LeftAdapter mLeftAdapter;

    private NoScrollListView mData;
    private DataAdapter mDataAdapter;

    private SyncHorizontalScrollView mHeaderHorizontal;
    private SyncHorizontalScrollView mDataHorizontal;

    private List<String> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mLeft = findViewById(R.id.lv_left);
        mData = findViewById(R.id.lv_data);
        mDataHorizontal = findViewById(R.id.data_horizontal);
        mHeaderHorizontal = findViewById(R.id.header_horizontal);

        mDataHorizontal.setScrollView(mHeaderHorizontal);
        mHeaderHorizontal.setScrollView(mDataHorizontal);

        mListData = new ArrayList<>();

        for (int i = 0; mListData.size() < 50; i++) {
            mListData.add(i + "");
        }

        mLeftAdapter = new LeftAdapter();
        mLeft.setAdapter(mLeftAdapter);

        mDataAdapter = new DataAdapter();
        mData.setAdapter(mDataAdapter);
    }

    class LeftAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_left, null);
                holder.tvLeft = convertView.findViewById(R.id.tv_left);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tvLeft.setText("第" + ++position + "行");

            return convertView;
        }

        class ViewHolder {
            TextView tvLeft;
        }
    }

    class DataAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_data, null);
                holder.tvData = convertView.findViewById(R.id.tv_data);
                holder.linContent = convertView.findViewById(R.id.lin_content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            return convertView;
        }

        class ViewHolder {
            TextView tvData;
            LinearLayout linContent;
        }
    }
}
