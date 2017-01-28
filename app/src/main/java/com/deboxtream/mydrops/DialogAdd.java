package com.deboxtream.mydrops;

import java.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.deboxtream.mydrops.beans.Drop;
import com.deboxtream.mydrops.widgets.BucketPickerView;

import io.realm.Realm;
import io.realm.RealmConfiguration;

import static io.realm.RealmConfiguration.*;

/**
 * Created by DROID on 19-01-2017.
 */

public class DialogAdd extends DialogFragment {

    private ImageButton mBtnClose;
    private EditText mInputWhat;
    private BucketPickerView mInputWhen;
    private Button mBtnAdd;

    private View.OnClickListener mBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch(id){
                case R.id.btn_add_dialog:
                    addAction();
                    break;
            }
            dismiss();
        }
    };

    private void addAction() {
        //get the value of the 'goal'
        //get the time it was added.

        String what = mInputWhat.getText().toString();
        long now = System.currentTimeMillis();
        Realm realm = Realm.getDefaultInstance();
        Drop drop = new Drop(what, now, mInputWhen.getTime(), false);
        realm.beginTransaction();
        realm.copyToRealm(drop);
        realm.commitTransaction();
        realm.close();
    }

    public DialogAdd() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnClose = (ImageButton) view.findViewById(R.id.btn_close);
        mInputWhat = (EditText) view.findViewById(R.id.add_drop);
        mInputWhen = (BucketPickerView) view.findViewById(R.id.date_picker);
        mBtnAdd = (Button) view.findViewById(R.id.btn_add_dialog);

        mBtnClose.setOnClickListener(mBtnClickListener);
        mBtnAdd.setOnClickListener(mBtnClickListener);
    }
}
