package com.example.appproject.Models;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.appproject.R;

//reference: https://www.youtube.com/watch?v=ARezg1D9Zd0

public class DialogBox extends AppCompatDialogFragment {

    private EditText EditName;
    private EditText EditId;
    private EditText EditHeight;
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
                String id = EditId.getText().toString();
                listener.applyTexts(name,id);
            }
        });
        EditName = view.findViewById(R.id.EditName);
        EditId = view.findViewById(R.id.EditId);
        EditHeight = view.findViewById(R.id.EditHeight);

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

        void applyTexts(String username, String password);


    }
}
