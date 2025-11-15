package com.example.atividade_jogo_clique;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView ivFoto;
    TextView txtTitle;
    Button btnReset;
    int counter;
    TextView txtHistory;

    public static String PREFS = "prefs";
    public static String CHAVE_CLIQUES = "cliques";
    public static String CHAVE_IMG = "img";
    int lastImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ivFoto = findViewById(R.id.tomato);
        txtTitle = findViewById(R.id.gameTitle);
        btnReset = findViewById(R.id.btnReset);
        txtHistory = findViewById(R.id.gameTotalClicks);

        ivFoto.setOnClickListener(v -> {
//            Log.d("CLIQUE", "O tomate 1 foi clicado");
            counter++;

            lastImg = getTomatoDrawable(Tomatoes.TOMATE1);

            if(counter > 10) {
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE2));
                lastImg = getTomatoDrawable(Tomatoes.TOMATE2);
            }

            if (counter > 20) {
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE3));
                lastImg = getTomatoDrawable(Tomatoes.TOMATE3);
            }

            if (counter > 30) {
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE4));
                lastImg = getTomatoDrawable(Tomatoes.TOMATE4);
            }
            if (counter > 40) {
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE5));
                lastImg = getTomatoDrawable(Tomatoes.TOMATE5);
            }
            if (counter > 50) {
                txtTitle.setText("");
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE6));
                lastImg = getTomatoDrawable(Tomatoes.TOMATE6);
            }
            if (counter > 60) {
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE7));
                lastImg = getTomatoDrawable(Tomatoes.TOMATE7);
            }
            if (counter > 70) {
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE8));
                lastImg = getTomatoDrawable(Tomatoes.TOMATE8);
            }
            if (counter > 80) {
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE9));
                lastImg = getTomatoDrawable(Tomatoes.TOMATE9);
            }
            if (counter > 90) {
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE10));
                lastImg = getTomatoDrawable(Tomatoes.TOMATE10);
            }

            txtHistory.setText("Você já tomatizou: " + counter + " cliques!");
            save();
        });

        read();

        btnReset.setOnClickListener(v -> {
            Toast.makeText(this, "Resetando...", Toast.LENGTH_SHORT).show();
            ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE1));
            lastImg = getTomatoDrawable(Tomatoes.TOMATE1);
            counter = 0;
            txtHistory.setText("Você já tomatizou: 0 cliques!");
            txtTitle.setText("Tomato Clicker");
            save();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static int getTomatoDrawable(Tomatoes t) {
        switch (t) {
            case TOMATE1: return R.drawable.tomate1;
            case TOMATE2: return R.drawable.tomate2;
            case TOMATE3: return R.drawable.tomate3;
            case TOMATE4: return R.drawable.tomate4;
            case TOMATE5: return R.drawable.tomate5;
            case TOMATE6: return R.drawable.tomate6;
            case TOMATE7: return R.drawable.tomate7;
            case TOMATE8: return R.drawable.tomate8;
            case TOMATE9: return R.drawable.tomate9;
            case TOMATE10: return R.drawable.tomate10;
        }
        return R.drawable.tomate1;
    }

    private void save() {
        SharedPreferences preferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(CHAVE_CLIQUES, counter);
        editor.putInt(CHAVE_IMG, lastImg);
        editor.apply();
//        Toast.makeText(this, "Salvou", Toast.LENGTH_LONG).show();
    }

    private void read() {
        SharedPreferences preferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        int cliques = preferences.getInt(CHAVE_CLIQUES, 0);
        int img = preferences.getInt(CHAVE_IMG, R.drawable.tomate1);

        counter = cliques;

        if(counter > 50) {
            txtTitle.setText("");
        }

        lastImg = img;
        ivFoto.setImageResource(img);

        txtHistory.setText("Você já tomatizou: " + cliques + " cliques!");
    }
}