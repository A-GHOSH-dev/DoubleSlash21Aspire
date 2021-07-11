package com.example.krishisahayak;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ngoCorner#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ngoCorner extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView image0,image1,image2;
    CardView card0,card1,card2;

    public ngoCorner() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ngoCorner.
     */
    // TODO: Rename and change types and number of parameters
    public static ngoCorner newInstance(String param1, String param2) {
        ngoCorner fragment = new ngoCorner();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_ngo_corner, container, false);
        card0=v.findViewById(R.id.cardn0);
        card1=v.findViewById(R.id.cardn1);
        card2=v.findViewById(R.id.cardn2);
        image0=v.findViewById(R.id.image0);
        image1=v.findViewById(R.id.image1);
        image2=v.findViewById(R.id.image2);
        image0.setImageResource(R.drawable.streee);
        image1.setImageResource(R.drawable.farm);
        image2.setImageResource(R.drawable.aquaculture);

        try {
            card0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(),streeKrishi.class);
                    i.putExtra("key",2);
                    startActivity(i);
//                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                    StreeeKrishi s= new StreeeKrishi();
//                    fragmentTransaction.replace(R.id.ngo,s);
//                    fragmentTransaction.commit();
                }
            });
        }catch (Exception e){

            Toast.makeText(getContext(),"It failed to load!",Toast.LENGTH_SHORT).show();
        }



        return v;
    }
}