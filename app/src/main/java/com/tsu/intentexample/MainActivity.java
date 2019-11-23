package com.tsu.intentexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 100;

    TextView feedCatText;
    int foodCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feedCatText = findViewById(R.id.feedCatText);
    }

    public void onClickToFeedCat(View view) {
        foodCount++;
        updateFeedCountText();
    }

    public void updateFeedCountText() {
        String resultFeedText = "Еда котика: " + foodCount;
        if (foodCount == 0) {
            resultFeedText = resultFeedText + "\n T_T";
        } else {
            resultFeedText = resultFeedText + "\n ^_^";
        }

        feedCatText.setText(resultFeedText);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (data != null) {
                foodCount = data.getIntExtra(Constants.KEY_FOOD, foodCount);
            }
            updateFeedCountText();
        }
    }

    public void onClickGoToGym(View view) {
        Intent goToGymIntent = new Intent(this, Gym.class);
        goToGymIntent.putExtra(Constants.KEY_FOOD, foodCount);

        startActivityForResult(goToGymIntent, REQUEST_CODE);
    }

}
