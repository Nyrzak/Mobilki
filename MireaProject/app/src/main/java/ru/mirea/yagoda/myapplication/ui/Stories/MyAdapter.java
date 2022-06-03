package ru.mirea.yagoda.myapplication.ui.Stories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import ru.mirea.yagoda.myapplication.R;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    List<String> mdata;

    public MyAdapter(Context c, List<String> mdata) {
        this.c = c;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txtName.setText(mdata.get(position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
}