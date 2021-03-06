package com.caminosantiago.socialway.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.caminosantiago.socialway.R;

public class MainFragment extends Fragment {

    private FragmentTabHost mTabHost;
    Activity activity;
    private OnFragmentInteractionListener mListener;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }
    public MainFragment() {
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tabs,container, false);
        final FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.containerMain, HomeFragment.newInstance()) .commit();

        RadioGroup radioButtonGroup=(RadioGroup)rootView.findViewById(R.id.radioButtonGroup);
        radioButtonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               if (checkedId==R.id.radioButton){
                   fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                   fragmentManager.beginTransaction().replace(R.id.containerMain, HomeFragment.newInstance()) .commit();
               } else if (checkedId==R.id.radioButton2){
                     fragmentManager.beginTransaction().replace(R.id.containerMain, TuCaminoFragment.newInstance()) .commit();

               }/*else if (checkedId==R.id.radioButton3){
                   fragmentManager.beginTransaction().replace(R.id.containerMain, HomeFollowingsFragment.newInstance()) .commit();

               }*/
            }
        });

        FloatingActionButton addPublication=(FloatingActionButton)rootView.findViewById(R.id.addPublication);
        addPublication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToPublish();
            }
        });

        return rootView;
    }

    public interface OnFragmentInteractionListener {
        void goToPublish();
    }

}
