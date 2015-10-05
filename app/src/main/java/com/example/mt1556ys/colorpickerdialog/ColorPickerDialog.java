package com.example.mt1556ys.colorpickerdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

/**
 * Created by mt1556ys on 10/5/15.
 */
public class ColorPickerDialog extends DialogFragment {

    final CharSequence[] COLOR_CHOICES = { "Red", "Magenta", "Green"};

    final int[] COLOR_VALUES = { Color.RED, Color.MAGENTA, Color.GREEN};

    interface ColorDialogListener {
        void onNewColorSelected(int color);
    }

    ColorDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (ColorDialogListener) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a new background color")
                .setItems(COLOR_CHOICES, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onNewColorSelected(COLOR_VALUES[which]);
                    }
                });

        return builder.create();
    }


}
