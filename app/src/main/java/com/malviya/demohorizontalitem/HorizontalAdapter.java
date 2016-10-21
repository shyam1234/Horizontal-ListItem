package com.malviya.demohorizontalitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 23508 on 10/20/2016.
 */

public class HorizontalAdapter extends ArrayAdapter {

    private ArrayList<HorizontalDataModel> mArrayList;
    private Context mContext;


    public HorizontalAdapter(Context pCotnext, ArrayList<HorizontalDataModel> pArrayList) {
        super(pCotnext, -1, pArrayList);
        mContext = pCotnext;
        mArrayList = pArrayList;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = (View) inflater.inflate(R.layout.item_row, parent, false);
            mHolder = new ViewHolder(convertView);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        initView(mHolder,position);
        return mHolder.getView();
    }

    private void initView(ViewHolder mHolder, int position) {
        mHolder.mImgViewItem.setImageResource(R.mipmap.ic_launcher);
        mHolder.mTextViewItem.setText(mArrayList.get(position).getName());
    }

    private class ViewHolder {
        private View view;
        public ImageView mImgViewItem;
        public TextView mTextViewItem;

        public ViewHolder(View v) {
            view = v;
            mImgViewItem = (ImageView) view.findViewById(R.id.image_item);
            mTextViewItem = (TextView) view.findViewById(R.id.text_item);
        }

        public View getView() {
            return view;
        }
    }

    public int getCount() {
        return mArrayList.size();
    }
}

