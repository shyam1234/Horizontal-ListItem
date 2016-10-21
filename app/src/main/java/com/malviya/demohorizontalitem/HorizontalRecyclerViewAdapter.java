package com.malviya.demohorizontalitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 23508 on 10/21/2016.
 */
public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<HorizontalDataModel> mArrayList;
    private boolean mResource;


    public HorizontalRecyclerViewAdapter(Context pContext, ArrayList<HorizontalDataModel> pArrayList , boolean resource) {
        mContext = pContext;
        mArrayList = pArrayList;
        mResource = resource;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = null;
        if(mResource)
            view = inflater.inflate(R.layout.item_row, parent, false);
        else
            view = inflater.inflate(R.layout.item_row1, parent, false);

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        int widthPixels=dm.widthPixels;
        int heightPixels=dm.heightPixels;
        Log.d("DisplayMetrics ","widthPixels "+widthPixels);
        Log.d("DisplayMetrics ","heightPixels "+heightPixels);
        switch (getItemCount()){
            case 1:
                view.setLayoutParams(new  RecyclerView.LayoutParams(widthPixels, ViewGroup.LayoutParams.WRAP_CONTENT));
                break;
            case 2:
                view.setLayoutParams(new  RecyclerView.LayoutParams(widthPixels/2, ViewGroup.LayoutParams.WRAP_CONTENT));
                break;
            default:
                //view.setLayoutParams(new  RecyclerView.LayoutParams(widthPixels/2, ViewGroup.LayoutParams.WRAP_CONTENT));
                break;
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mImgViewItem.setImageResource(R.mipmap.ic_launcher);
        holder.mTextViewItem.setText(mArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 3;//mArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImgViewItem;
        public TextView mTextViewItem;

        public MyViewHolder(View v) {
            super(v);
            mImgViewItem = (ImageView) v.findViewById(R.id.image_item);
            mTextViewItem = (TextView) v.findViewById(R.id.text_item);
        }

    }
}
