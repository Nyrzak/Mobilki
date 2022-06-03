package ru.mirea.yagoda.myapplication.ui.Stories;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.yagoda.myapplication.R;

public class StoriesFragment extends Fragment {

    RecyclerView rv;
    String strCatName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stories, null);
        FloatingActionButton fab = v.findViewById(R.id.fab_action);

        final EditText editText = v.findViewById(R.id.editText);

        rv = v.findViewById(R.id.rv);
        List<String> name = new ArrayList<>();

        editText.setOnKeyListener((v12, keyCode, event) -> {
            if(event.getAction() == KeyEvent.ACTION_DOWN &&
                    (keyCode == KeyEvent.KEYCODE_ENTER))
            {
                strCatName = editText.getText().toString();
                return true;
            }
            return false;
        });
        ((FloatingActionButton)v.findViewById(R.id.fab_action)).setOnClickListener(v1 -> {

            if(editText.getText().toString().length() != 0)
            {
                name.add(strCatName);
            }
            rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            MyAdapter adapter = new MyAdapter(getActivity(),name);
            rv.setAdapter(adapter);
        });

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapter adapter = new MyAdapter(getActivity(),name);
        rv.setAdapter(adapter);
        return v;
    }
}