package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class mood extends AppCompatActivity {

    private TextView excitedNote, boredNote, nervousNote, tiredNote, anxietyNote, frustratedNote, happyNote, sadNote, calmNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        SeekBar seekBarExcited = findViewById(R.id.seekBarExcited);
        seekBarExcited.setVisibility(View.GONE);
        seekBarExcited.setOnSeekBarChangeListener(seekBarExcitedChangeListener);
        excitedNote = findViewById(R.id.textExcitedNote);
        excitedNote.setVisibility(View.GONE);

        SeekBar seekBarBored = findViewById(R.id.seekBarBored);
        seekBarBored.setVisibility(View.GONE);
        seekBarBored.setOnSeekBarChangeListener(seekBarBoredChangeListener);
        boredNote = findViewById(R.id.textBoredNote);
        boredNote.setVisibility(View.GONE);

        SeekBar seekBarNervous = findViewById(R.id.seekBarNervous);
        seekBarNervous.setVisibility(View.GONE);
        seekBarNervous.setOnSeekBarChangeListener(seekBarNervousChangeListener);
        nervousNote = findViewById(R.id.textNervousNote);
        nervousNote.setVisibility(View.GONE);

        SeekBar seekBarTired = findViewById(R.id.seekBarTired);
        seekBarTired.setVisibility(View.GONE);
        seekBarTired.setOnSeekBarChangeListener(seekBarTiredChangeListener);
        tiredNote = findViewById(R.id.textTiredNote);
        tiredNote.setVisibility(View.GONE);

        SeekBar seekBarAnxiety = findViewById(R.id.seekBarAnxiety);
        seekBarAnxiety.setVisibility(View.GONE);
        seekBarAnxiety.setOnSeekBarChangeListener(seekBarAnxietyChangeListener);
        anxietyNote = findViewById(R.id.textAnxietyNote);
        anxietyNote.setVisibility(View.GONE);

        SeekBar seekBarFrustrated = findViewById(R.id.seekBarFrustrated);
        seekBarFrustrated.setVisibility(View.GONE);
        seekBarFrustrated.setOnSeekBarChangeListener(seekBarFrustratedChangeListener);
        frustratedNote = findViewById(R.id.textFrustratedNote);
        frustratedNote.setVisibility(View.GONE);

        SeekBar seekBarHappy = findViewById(R.id.seekBarHappy);
        seekBarHappy.setVisibility(View.GONE);
        seekBarHappy.setOnSeekBarChangeListener(seekBarHappyChangeListener);
        happyNote = findViewById(R.id.textHappyNote);
        happyNote.setVisibility(View.GONE);

        SeekBar seekBarSad = findViewById(R.id.seekBarSad);
        seekBarSad.setVisibility(View.GONE);
        seekBarSad.setOnSeekBarChangeListener(seekBarSadChangeListener);
        sadNote = findViewById(R.id.textSadNote);
        sadNote.setVisibility(View.GONE);

        SeekBar seekBarCalm = findViewById(R.id.seekBarCalm);
        seekBarCalm.setVisibility(View.GONE);
        seekBarCalm.setOnSeekBarChangeListener(seekBarCalmChangeListener);
        calmNote = findViewById(R.id.textCalmNote);
        calmNote.setVisibility(View.GONE);

    }

    SeekBar.OnSeekBarChangeListener seekBarExcitedChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            excitedNote.setText(progress + "/5");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    SeekBar.OnSeekBarChangeListener seekBarBoredChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            boredNote.setText(progress + "/5");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    SeekBar.OnSeekBarChangeListener seekBarNervousChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            nervousNote.setText(progress + "/5");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    SeekBar.OnSeekBarChangeListener seekBarTiredChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            tiredNote.setText(progress + "/5");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    SeekBar.OnSeekBarChangeListener seekBarAnxietyChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            anxietyNote.setText(progress + "/5");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    SeekBar.OnSeekBarChangeListener seekBarFrustratedChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            frustratedNote.setText(progress + "/5");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    SeekBar.OnSeekBarChangeListener seekBarHappyChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            happyNote.setText(progress + "/5");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    SeekBar.OnSeekBarChangeListener seekBarSadChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            sadNote.setText(progress + "/5");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    SeekBar.OnSeekBarChangeListener seekBarCalmChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            calmNote.setText(progress + "/5");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

}
