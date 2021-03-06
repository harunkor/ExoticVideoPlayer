package com.erlab.exoticvideoplayer.View;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.erlab.exoticvideoplayer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentVideo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentVideo extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageButton playButton;
    private TextView Desc;

    public FragmentVideo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentVideo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentVideo newInstance(String param1, String param2) {
        FragmentVideo fragment = new FragmentVideo();
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
        // Inflate the layout for this fragment
        View fragmentView =inflater.inflate(R.layout.fragment_video, container, false);
        playButton=fragmentView.findViewById(R.id.btn_play);
        playButton.setOnClickListener(this);
        Desc=fragmentView.findViewById(R.id.txt_desc);
        Desc.setMovementMethod(new ScrollingMovementMethod());





        return fragmentView;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case  R.id.btn_play:
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                        .navigate(R.id.action_fragmentVideo_to_fragmentPlayer);
                    break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}