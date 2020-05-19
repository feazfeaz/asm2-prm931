package com.example.asm2;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class mAdapter extends BaseAdapter {

    private static final String TAG = mAdapter.class.getSimpleName() ;
    String[] mStrings;
    Activity mActivity;
    int mresID_ic;

    public mAdapter(Activity Activity, String[] Strings, int resID_ic){
        this.mActivity = Activity;
        this.mStrings = Strings;
        this.mresID_ic = resID_ic;
    }

    @Override
    public int getCount() {
        return mStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return mStrings[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        //
        LayoutInflater mLayoutInflater = mActivity.getLayoutInflater();
        convertView = mLayoutInflater.inflate(R.layout.activity_recontent,null);
        Log.e(TAG, "getView: ");
        // get layout
        LinearLayout vLinearLayout = (LinearLayout) convertView.findViewById(R.id.detail_par_linear);
        // set value for each layout is ic + txt
        ImageView vImageView = (ImageView) vLinearLayout.findViewById(R.id.detail_ic);
        vImageView.setImageResource(mresID_ic);
        TextView vtextView = (TextView) vLinearLayout.findViewById(R.id.detail_txt);
        vtextView.setText(mStrings[i]);

        return vLinearLayout;
    }
}
