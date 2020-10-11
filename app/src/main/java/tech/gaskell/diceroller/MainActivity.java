package tech.gaskell.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    int numOfDie;
    int dieSides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createWelcomeDialog();

        numOfDie = Integer.parseInt(getString(R.string.default_die_num));
        dieSides = Integer.parseInt(getString(R.string.default_die_sides));

        SeekBar count_bar = (SeekBar) findViewById(R.id.die_config_count_bar_main);
        SeekBar sides_bar = (SeekBar) findViewById(R.id.die_config_sides_bar_main);

        count_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("tech.gaskell.diceroller","[Debug1425] onProgressChanged ran");
                int actualValue = progress + 1;
                numOfDie = actualValue;

                TextView value_textview = (TextView) findViewById(R.id.die_config_count_count_main);
                value_textview.setText(String.valueOf(numOfDie));

                TextView die_textview = (TextView) findViewById(R.id.dice_num);

                StringBuilder die_text = new StringBuilder();
                if (numOfDie <= 2) {
                    for (int i = 0; i < numOfDie; i++) {
                        die_text.append("--\n");
                    }
                } else {
                    for (int i = 0; i < numOfDie; i++) {
                        if (i % 2 == 0) {
                            die_text.append("\n--");
                        } else {
                            die_text.append(" --");
                        }
                    }
                }

                die_textview.setText(die_text.toString().trim());
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

                TextView value_textview = (TextView) findViewById(R.id.die_config_sides_count_main);
                value_textview.setText(String.valueOf(actualValue));

                dieSides = actualValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                createAboutDialog();
                return true;
            case R.id.menu_settings:
                // TODO open settings activity
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void createWelcomeDialog() {
        DialogFragment newFragment = new WelcomeDialog();
        newFragment.show(getSupportFragmentManager(), "welcome");
    }

    public void createAboutDialog() {
        DialogFragment newFragment = new AboutDialog();

        newFragment.show(getSupportFragmentManager(), "about");
    }

    public void rollDice(View view) {
        StringBuilder die_text = new StringBuilder();
        String random_num_str;
        if (numOfDie <= 2) {
            for (int i = 0; i < numOfDie; i++) {
                int random_num = random.nextInt(dieSides) + 1;
                random_num_str = String.valueOf(random_num);
                if (random_num < 10) {
                    random_num_str = "0" + random_num_str;
                }
                die_text.append("\n").append(random_num_str);
            }
        } else {
            for (int i = 0; i < numOfDie; i++) {
                int random_num = random.nextInt(dieSides) + 1;
                random_num_str = String.valueOf(random_num);
                if (random_num < 10) {
                    random_num_str = "0" + random_num_str;
                }
                if (i % 2 == 0) {
                    die_text.append("\n").append(random_num_str);
                } else {
                    die_text.append(" ").append(random_num_str);
                }
            }
        }

        TextView die_textview = (TextView)findViewById(R.id.dice_num);
        die_textview.setText(die_text.toString().trim());
    }

    public void runDieConfig(View view) {
        DialogFragment newFragment = new DieConfig();
        newFragment.show(getSupportFragmentManager(), "dieconfig");
    }
}