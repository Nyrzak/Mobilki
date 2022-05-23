package ru.mirea.yagoda.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

public class MyProgressDialogFragment {
    Context context;
    Dialog dialog;

    public MyProgressDialogFragment(Context context){
        this.context = context;
    }

    public void ShowDialog(String title) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView titleTextView = dialog.findViewById(R.id.textView3);
        titleTextView.setText(title);
        dialog.create();
        dialog.show();
    }
    public void HideDialog()
    {
        dialog.dismiss();
    }
}
