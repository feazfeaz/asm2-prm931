package com.example.asm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

public class detail_contain_service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contain_service);

        Bundle mBundle = getIntent().getExtras();

        TextView mTextView = (TextView)this.findViewById(R.id.name_service);
        mTextView.setText(mBundle.getString("name_service"));

        mAdapter myAdapter = new mAdapter(this,
                //content
                mBundle.getStringArray("lst_content_service"),
                //icon
                mBundle.getInt("icon_service"));

        // get frgmTransaction to impact fragment
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction
                // place of fragment, and content fragment(but lstFragment has adapter as param)
                .add(R.id.detail_frameLayout, new ListContentServiceFragment(myAdapter))
                .commit();

//        ((ListView)this.findViewById(R.id.list_content_detail)).setAdapter(myAdapter);

    }
}
