package com.example.appproject.Models.DialogBox;

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

public class DialogFindUserBox extends AppCompatDialogFragment {

    private EditText EditFindName;
    private EditText EditFindLastName;
    private EditText EditFindId;
    private DialogFindUserBox.DialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialogfind, null);
        builder.setView(view).setTitle("Find User").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("Find", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = EditFindName.getText().toString();
                String last = EditFindLastName.getText().toString();
                String id = EditFindId.getText().toString();
                listener.applyTexts(name,last,id);
            }
        });
        EditFindName = view.findViewById(R.id.EditFindName);
        EditFindLastName = view.findViewById(R.id.EditFindLastName);
        EditFindId = view.findViewById(R.id.EditFindId);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DialogFindUserBox.DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+ "must implement ExampleDialogListener");
        }
    }
    public interface DialogListener{

        void applyTexts(String name, String last, String id);

    }




}
