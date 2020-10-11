package tech.gaskell.diceroller;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class DieConfig extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.die_config_title)
                .setView(R.layout.fragment_die_config)
                .setPositiveButton(R.string.die_config_done, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /* TODO: Save Config Options */

                        DieConfig.this.getDialog().cancel();
                    }
                });
        Log.d("tech.gaskell.diceroller","[Debug1425] Ran onCreate");
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("tech.gaskell.diceroller","[Debug1425] onCreateView ran");
        final View view = inflater.inflate(R.layout.fragment_die_config, container);

        SeekBar count_bar = (SeekBar) view.findViewById(R.id.die_config_count_bar);
        SeekBar sides_bar = (SeekBar) view.findViewById(R.id.die_config_sides_bar);
        TextView sometext = (TextView) view.findViewById(R.id.die_config_count_label);
        sometext.setText("Text Edited Successfully");

        count_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("tech.gaskell.diceroller","[Debug1425] onProgressChanged ran");
                int actualValue = progress + 1;

                TextView value_textview = (TextView) getView().findViewById(R.id.die_config_count_count);
                value_textview.setText(String.valueOf(actualValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        sides_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("tech.gaskell.diceroller","[Debug1425] onProgressChanged ran");
                int actualValue = progress + 2;

                TextView value_textview = (TextView) getView().findViewById(R.id.die_config_sides_count);
                value_textview.setText(String.valueOf(actualValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        Log.d("tech.gaskell.diceroller","[Debug1425] about to return from onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("tech.gaskell.diceroller", "[Debug1425] Ran onViewCreated");

        TextView sometext = view.findViewById(R.id.die_config_count_label);
        sometext.setText("Edited Text Successfully");
    }
}