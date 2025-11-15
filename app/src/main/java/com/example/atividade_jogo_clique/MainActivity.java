package com.example.atividade_jogo_clique;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView ivFoto;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ivFoto = findViewById(R.id.tomato);
        ivFoto.setOnClickListener(v -> {
            Log.d("CLIQUE", "O tomate 1 foi clicado");
            counter++;

            if(counter == 10) {
                ivFoto.setImageResource(getTomatoDrawable(Tomatoes.TOMATE2));
            }
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
}