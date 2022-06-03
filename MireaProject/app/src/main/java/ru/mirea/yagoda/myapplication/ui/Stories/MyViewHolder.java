package ru.mirea.yagoda.myapplication.ui.Stories;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.mirea.yagoda.myapplication.R;


public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView txtName;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.text_name);
    }
}