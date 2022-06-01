package ru.mirea.yagoda.myapplication.ui.Permission;

import static ru.mirea.yagoda.myapplication.ui.Music.FragmentMusic.hasPermissions;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import ru.mirea.yagoda.myapplication.R;

public class FragmentPermissions extends Fragment {

    int permissionsCode = 42;
    String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_permission, null);

        if (!hasPermissions(getActivity(), permissions)) {
            ActivityCompat.requestPermissions(getActivity(), permissions, permissionsCode);
        }
        else
        {
            Toast.makeText(getActivity(), "Все разрешения получены!", Toast.LENGTH_SHORT).show();
        }
        return v;
    }

}
