package com.example.asm2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MainMenuFragment extends Fragment {
    // có vài thứ nó tạo sẵn em củng chưa hiểu nó nó tác dụng gì nên em ko có gì để note
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = MainMenuFragment.class.getSimpleName();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Main_menu.
     */
    // TODO: Rename and change types and number of parameters
    public static MainMenuFragment newInstance(String param1, String param2) {
        MainMenuFragment fragment = new MainMenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    // mấy này lúc tạo tự động
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //haaaaaaaaaaaa
        Log.e(TAG, "onCreateView: ");

        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        Spinner spinner = (Spinner)view.findViewById(R.id.countrys);
        // create adapter for dropout list (countrys)
        ArrayAdapter<String> mStringArrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.countrys)
        );
        mStringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set adapter for spinner country
        spinner.setAdapter(mStringArrayAdapter);

        Button btn_hotel = (Button)view.findViewById(R.id.btn_hotel);
        Button btn_bus = (Button)view.findViewById(R.id.btn_bus);
        Button btn_atm = (Button)view.findViewById(R.id.btn_atm);
        Button btn_hospital = (Button)view.findViewById(R.id.btn_hospital);

        // take amount items of service
        int lenght_of_list = getResources().getStringArray(R.array.lst_hotel).length;
        //creat text with amount var
        String mstringformat = getResources().getString(R.string.show_number_available_items, lenght_of_list);
        // set text for btn
        btn_hotel.setText(mstringformat);
        //same but sorter
        btn_bus.setText(getResources().getString(
                R.string.show_number_available_items,
                (getResources().getStringArray(R.array.lst_bus)).length));
        btn_atm.setText(getResources().getString(
                R.string.show_number_available_items,
                (getResources().getStringArray(R.array.lst_atm)).length));
        btn_hospital.setText(getResources().getString(
                R.string.show_number_available_items,
                (getResources().getStringArray(R.array.lst_hospital)).length));
        //
        return view;
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
