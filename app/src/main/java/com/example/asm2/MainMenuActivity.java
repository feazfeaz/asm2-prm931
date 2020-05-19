package com.example.asm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    private static final String TAG = MainMenuActivity.class.getSimpleName();
    public static final String NAME_SERVICE_KEY = "name_service";

    private FragmentManager mfragmentManager;// control main fragment contain

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // dư án được build lại vài lần nên có nhiều chổ dư thừa

        mfragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mfragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.main_fragment,new Main_menu(),Main_menu.class.getSimpleName()).commit();
    }

    public void getFragment(View view){
        Fragment mfragment = null;
        switch (view.getId()){
            case R.id.btn_hotel:{
                // get fragment service
                mfragment = new ListContentServiceFragment(
                        //provide adapter for list fragment
                        creatAdapter(
                                R.array.lst_hotel,
                                R.drawable.ic_hotel));
                Bundle bundle = new Bundle();
                // and name of sevice too
                bundle.putString(NAME_SERVICE_KEY,getString(R.string.service_hotel));
                mfragment.setArguments(bundle);
                break;
            }
            case R.id.btn_bus:{
                mfragment = new ListContentServiceFragment(
                        creatAdapter(
                                R.array.lst_bus,
                                R.drawable.ic_bus));
                Bundle bundle = new Bundle();
                bundle.putString(NAME_SERVICE_KEY,getString(R.string.service_bus));
                mfragment.setArguments(bundle);
                break;
            }
            case R.id.btn_atm:{
                mfragment = new ListContentServiceFragment(
                        creatAdapter(
                                R.array.lst_atm,
                                R.drawable.ic_atm));
                Bundle bundle = new Bundle();
                bundle.putString(NAME_SERVICE_KEY,getString(R.string.service_atm));
                mfragment.setArguments(bundle);
                break;
            }
            case R.id.btn_hospital:{
                mfragment = new ListContentServiceFragment(
                        creatAdapter(
                                R.array.lst_hospital,
                                R.drawable.ic_hostpital));
                Bundle bundle = new Bundle();
                bundle.putString(NAME_SERVICE_KEY,getString(R.string.service_hospital));
                mfragment.setArguments(bundle);
                break;
            }
        }
        FragmentTransaction mFragmentTransaction = mfragmentManager.beginTransaction();
        // set fragment and replace
        mFragmentTransaction.replace(R.id.main_fragment,
                //content
                mfragment,
                //tag
                ListContentServiceFragment.class.getSimpleName())
                // add back stack to return home
                .addToBackStack(mfragment.getClass().getName())
                .commit();

    }

    public mAdapter creatAdapter(int listContet, int icon){
        return new mAdapter(
                this,
                // list content for adapter
                getResources().getStringArray(listContet),
                // icon with each element content
                icon);
    }

    @Override
    public void onBackPressed() {
        // check to see stack left
        if(mfragmentManager.getBackStackEntryCount() > 0){
            mfragmentManager.popBackStack();
        }else {
            super.onBackPressed();
        }
    }
    // just a Toast
    void alert(String a){
        Toast.makeText(this,a,Toast.LENGTH_LONG).show();
    }
}


//??? replace rồi mà vẵn visible && !hidden ????
//        alert((mfragmentManager.findFragmentByTag(Main_menu.class.getSimpleName()) != null) + "\n"
//                + (mfragmentManager.findFragmentByTag(Main_menu.class.getSimpleName())).isVisible() + " visible\n"
//                + (mfragmentManager.findFragmentByTag(Main_menu.class.getSimpleName())).isHidden() + " hidden   ");