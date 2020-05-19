package com.example.asm2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ListContentServiceFragment extends Fragment {

    private static final String TAG = ListContentServiceFragment.class.getSimpleName();
    private ListAdapter Adapter;

    public ListContentServiceFragment (ListAdapter adapter){
        // this type of fragment include 1 listView so i need 1 instance adapter
        this.Adapter = adapter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //set content fragment
        View fragmentView = inflater.inflate(R.layout.list_style_fragment,container,false);

        //take argument from MainActivity and set title of fragment view
        Bundle mBundle = getArguments();
        ((TextView)fragmentView.findViewById(R.id.name_service)).setText(
                mBundle.getString(MainMenuActivity.NAME_SERVICE_KEY)
        );

        if(Adapter != null){
            // listView need adapter
            ((ListView) fragmentView.findViewById(R.id.list_content_fragment)).setAdapter(Adapter);
        }
        return fragmentView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Log.e(TAG, "onAttach: ");
        super.onAttach(context);
    }
    @Override
    public void onStart() {
        Log.e(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG, "onDestroyView: ");
        super.onDestroyView();
    }
}
