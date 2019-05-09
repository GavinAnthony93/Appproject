package com.example.appproject.Models;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.appproject.R;

//reference: https://www.youtube.com/watch?v=ARezg1D9Zd0

public class DialogBox extends AppCompatDialogFragment {

    private EditText EditName;
    private EditText EditHeight;
    private EditText EditWeight;
    RadioGroup radioGroup;
    RadioButton radioButton;


    private DialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);
        builder.setView(view).setTitle("Add User").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = EditName.getText().toString();
                String height = EditHeight.getText().toString();
                String weight = EditWeight.getText().toString();
                listener.applyTexts(name,height, weight);
            }
        });
        EditName = view.findViewById(R.id.EditName);
        EditHeight = view.findViewById(R.id.EditHeight);
        EditWeight = view.findViewById(R.id.EditMainWeight);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+ "must implement ExampleDialogListener");
        }

    }


    public interface DialogListener{

        void applyTexts(String name, String height, String weight);


    }
}
