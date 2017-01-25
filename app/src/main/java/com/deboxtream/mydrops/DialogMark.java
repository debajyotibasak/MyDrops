package com.deboxtream.mydrops;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.deboxtream.mydrops.adapters.CompleteListener;

/**
 * Created by DROID on 21-01-2017.
 */

public class DialogMark extends DialogFragment {
    private ImageButton mBtnClose;
    private ImageButton mBtnComplete;


    private View.OnClickListener mBtnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_complete:
                    markAsComplete();
                    break;
            }
            dismiss();
        }
    };
    private CompleteListener mListener;

    private void markAsComplete() {
        Bundle arguments = getArguments();
        if(mListener!=null && arguments != null){
            int position = arguments.getInt("POSITION");
            mListener.onComplete(position);
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_mark, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnClose = (ImageButton) view.findViewById(R.id.btn_close);
        mBtnComplete = (ImageButton) view.findViewById(R.id.btn_complete);
        mBtnClose.setOnClickListener(mBtnClickListener);
        mBtnComplete.setOnClickListener(mBtnClickListener);
    }

    public void setCompleteListener(CompleteListener mCompleteListener) {
        mListener = mCompleteListener;
    }
}
