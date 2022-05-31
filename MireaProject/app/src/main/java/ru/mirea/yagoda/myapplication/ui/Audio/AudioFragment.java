package ru.mirea.yagoda.myapplication.ui.Audio;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.mirea.yagoda.myapplication.R;


public class AudioFragment extends Fragment {
    Button playButton;
    boolean musicPlay = false;

    public AudioFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);
        playButton = view.findViewById(R.id.button);
        playButton.setOnClickListener(view1 -> PlayOrStopMusic());
        return view;
    }

    public void onClickPlayMusic() {
        getActivity().startService(
                new Intent(getActivity(), AudioService.class));
    }
    public void onClickStopMusic() {
        getActivity().stopService(
                new Intent(getActivity(), AudioService.class));
    }
    public  void  PlayOrStopMusic(){
        if (!musicPlay){
            onClickPlayMusic();
            musicPlay = true;
            playButton.setText("Stop");
        }
        else{
            onClickStopMusic();
            musicPlay = false;
            playButton.setText("Play");
        }
    }
}