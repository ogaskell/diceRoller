package tech.gaskell.diceroller;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WelcomeDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.welcome_message_title)
               .setMessage(R.string.welcome_message)
               .setPositiveButton(R.string.welcome_ok, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       WelcomeDialog.this.getDialog().cancel();
                   }
               });
               /*.setNegativeButton(R.string.welcome_dismiss, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       WelcomeDialog.this.getDialog().cancel();
                   }
               });*/
        // Create the AlertDialog object and return it
        return builder.create();
    }
}