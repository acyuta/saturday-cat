package com.tsu.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Gym extends AppCompatActivity {

    int foodCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);
        foodCount = getIntent().getIntExtra(Constants.KEY_FOOD, 0);

        changeFatTextTitle();
    }

    public void changeFatTextTitle() {
        String resultText = "Осталось жирка: " + foodCount;
        TextView fatTextView = findViewById(R.id.fatText);
        fatTextView.setText(resultText);
    }

    public void train(int fatCost) {
        if (foodCount - fatCost < 0) {
            foodCount = 0;
            Toast.makeText(this, "Я усталь и хочу спать", Toast.LENGTH_SHORT).show();
        } else {
            foodCount -= fatCost;
        }
        changeFatTextTitle();

        Intent resultIntent = new Intent();
        resultIntent.putExtra(Constants.KEY_FOOD, foodCount);
        setResult(Activity.RESULT_OK, resultIntent);
    }


    public void onClickTrainBelly(View view) {
//        Toast.makeText(this, "Тренируем животинку", Toast.LENGTH_SHORT).show();
        train(15);
    }

    public void onClickTrainLegs(View view) {
//        Toast.makeText(this, "Я допрыгал Ь", Toast.LENGTH_SHORT).show();
        train(15);
    }

    public void onClickTrainArms(View view) {
//        Toast.makeText(this, "Скрип мыщц", Toast.LENGTH_SHORT).show();
        train(5);
    }
}
