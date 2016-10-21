package com.malviya.demohorizontalitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * @author Prafulla Malviya
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private HorizontalRecyclerViewAdapter mAdapter;
    private HorizontalAdapter mAdapter1;
    private ArrayList<HorizontalDataModel> mArrayList;
    private FeatureCoverFlow mCoverFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        scrollableHorizontalItem();
        singleItemInRow();
        multipleItemInRow();
    }

    private void init() {
        mArrayList = new ArrayList<>();

        //for testing
        for (int i = 0; i < 11; i++) {
            HorizontalDataModel holder = new HorizontalDataModel();
            holder.setName("Item" + i);
            //holder.setImgURL("http://icons.iconarchive.com/icons/martz90/circle/512/android-icon.png");
            mArrayList.add(holder);
            holder = null;
        }
    }

    private void scrollableHorizontalItem() {
        mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        mAdapter1 = new HorizontalAdapter(MainActivity.this, mArrayList);
        mCoverFlow.setAdapter(mAdapter1);
    }

    private void singleItemInRow() {
        //single item in a col
        mRecyclerView = (RecyclerView) findViewById(R.id.offer_row_recyclerview_id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new HorizontalRecyclerViewAdapter(MainActivity.this, mArrayList, true);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void multipleItemInRow() {
        mRecyclerView = (RecyclerView) findViewById(R.id.offer_row_recyclerview_id1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new HorizontalRecyclerViewAdapter(MainActivity.this, mArrayList, false);
        mRecyclerView.setAdapter(mAdapter);

    }


}
