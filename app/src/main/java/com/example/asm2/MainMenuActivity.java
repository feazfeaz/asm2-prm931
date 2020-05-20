package com.example.asm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    private static final String TAG = MainMenuActivity.class.getSimpleName();
    public static final String NAME_SERVICE_KEY = "name_service";

    private FragmentManager mainFragmentManager;// control main fragment contain

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // dư án được build lại vài lần nên có nhiều chổ thừa ạ :P

        mainFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mainFragmentManager.beginTransaction();
        // load main screne
        fragmentTransaction.replace(R.id.main_fragment,new MainMenuFragment(),MainMenuFragment.class.getSimpleName()).commit();
        
    }
    // method load detail content of service for button
    public void getFragment(View view){
        Fragment fragment = null;
        switch (view.getId()){
            case R.id.btn_hotel:{
                // get fragment service
                fragment = new ListContentServiceFragment(
                        //provide adapter for list fragment
                        creatAdapter(
                                R.array.lst_hotel,
                                R.drawable.ic_hotel));
                Bundle bundle = new Bundle();
                // and name of sevice too
                bundle.putString(NAME_SERVICE_KEY,getString(R.string.service_hotel));
                fragment.setArguments(bundle);
                break;
            }
            case R.id.btn_bus:{
                // too
                fragment = new ListContentServiceFragment(
                        creatAdapter(
                                R.array.lst_bus,
                                R.drawable.ic_bus));
                Bundle bundle = new Bundle();
                bundle.putString(NAME_SERVICE_KEY,getString(R.string.service_bus));
                fragment.setArguments(bundle);
                break;
            }
            case R.id.btn_atm:{
                fragment = new ListContentServiceFragment(
                        creatAdapter(
                                R.array.lst_atm,
                                R.drawable.ic_atm));
                Bundle bundle = new Bundle();
                bundle.putString(NAME_SERVICE_KEY,getString(R.string.service_atm));
                fragment.setArguments(bundle);
                break;
            }
            case R.id.btn_hospital:{
                fragment = new ListContentServiceFragment(
                        creatAdapter(
                                R.array.lst_hospital,
                                R.drawable.ic_hostpital));
                Bundle bundle = new Bundle();
                bundle.putString(NAME_SERVICE_KEY,getString(R.string.service_hospital));
                fragment.setArguments(bundle);
                break;
            }
        }
        FragmentTransaction mFragmentTransaction = mainFragmentManager.beginTransaction();
        // set fragment and replace
        mFragmentTransaction.replace(R.id.main_fragment,
                //content
                fragment,
                //tag
                ListContentServiceFragment.class.getSimpleName())
                // add back stack to return home
                .addToBackStack(fragment.getClass().getName())
                .commit();
    }

    public ContentServiceApdater creatAdapter(int listContet, int icon){
        return new ContentServiceApdater(
                this,
                // list content for adapter
                getResources().getStringArray(listContet),
                // icon with each element content
                icon);
    }

    @Override
    public void onBackPressed() {
        // check to see stack left
        if(mainFragmentManager.getBackStackEntryCount() > 0){
            mainFragmentManager.popBackStack();
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