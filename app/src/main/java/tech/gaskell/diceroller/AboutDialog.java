package tech.gaskell.diceroller;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.about_message_title)
                .setView(R.layout.fragment_about_dialog)
                .setPositiveButton(R.string.about_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AboutDialog.this.getDialog().cancel();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

  /*  @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d("tech.gaskell.diceroller", "[Debug1425] Ran AboutDialog.onViewCreated");
        TextView about_text = (TextView) view.findViewById(R.id.about_text);
        about_text.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("tech.gaskell.diceroller", "[Debug1425] AboutDialog.onCreateView ran");
        final View view = inflater.inflate(R.layout.fragment_about_dialog, container);

        TextView about_text = (TextView) view.findViewById(R.id.about_text);
        about_text.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }*/

}

//setMovementMethod(LinkMovementMethod.getInstance())