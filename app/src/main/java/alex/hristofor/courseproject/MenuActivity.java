package alex.hristofor.courseproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import alex.hristofor.courseproject.homework1.Homework1Activity;
import alex.hristofor.courseproject.homework2.Homework2Activity;
import alex.hristofor.courseproject.homework3.Homework3Activity;
import alex.hristofor.courseproject.homework4.Homework4Activity;
import alex.hristofor.courseproject.homework5.Homework5Activity;
import alex.hristofor.courseproject.homework6.Homework6Activity;

public class MenuActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button buttonLesson1 = findViewById(R.id.buttonLesson1);
        Button buttonLesson2 = findViewById(R.id.buttonLesson2);
        Button buttonLesson3 = findViewById(R.id.buttonLesson3);
        Button buttonLesson4 = findViewById(R.id.buttonLesson4);
        Button buttonLesson5 = findViewById(R.id.buttonLesson5);
        Button buttonLesson6 = findViewById(R.id.buttonLesson6);

        buttonLesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Homework1Activity.class);
                startActivity(intent);
            }
        });

        buttonLesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Homework2Activity.class);
                startActivity(intent);
            }
        });

        buttonLesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Homework3Activity.class);
                startActivity(intent);
            }
        });

        buttonLesson4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Homework4Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);
            }
        });
        buttonLesson5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Homework5Activity.class);
                startActivity(intent);

            }
        });
        buttonLesson6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Homework6Activity.class);
                startActivity(intent);

            }
        });
    }
}
