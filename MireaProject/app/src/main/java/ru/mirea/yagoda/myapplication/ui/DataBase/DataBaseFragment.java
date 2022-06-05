package ru.mirea.yagoda.myapplication.ui.DataBase;

import android.content.ContentValues;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;

        import androidx.fragment.app.Fragment;

import ru.mirea.yagoda.myapplication.R;


public class DataBaseFragment extends Fragment implements View.OnClickListener {

    Button btnAdd, btnRead, btnClear;
    EditText etName, etEmail;
    DBHelper dbHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_database, null);

        btnAdd = (Button) v.findViewById(R.id.btnAdd);
        ((Button)v.findViewById(R.id.btnAdd)).setOnClickListener(this);

        btnRead = (Button) v.findViewById(R.id.btnRead);
        ((Button)v.findViewById(R.id.btnRead)).setOnClickListener(this);

        btnClear = (Button) v.findViewById(R.id.btnClear);
        ((Button)v.findViewById(R.id.btnClear)).setOnClickListener(this);


        etName = (EditText) v.findViewById(R.id.etName);
        etEmail = (EditText) v.findViewById(R.id.etEmail);

        dbHelper = new DBHelper(getActivity());

        return v;
    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {

            case R.id.btnAdd:
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_MAIL, email);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                break;

            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
                    do {
                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                ", name = " + cursor.getString(nameIndex) +
                                ", email = " + cursor.getString(emailIndex));
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog","0 rows");

                cursor.close();
                break;

            case R.id.btnClear:
                database.delete(DBHelper.TABLE_CONTACTS, null, null);
                break;
        }
        dbHelper.close();
    }
}
