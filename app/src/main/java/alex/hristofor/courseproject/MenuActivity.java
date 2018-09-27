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

public class MenuActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button buttonLesson1 = findViewById(R.id.buttonLesson1);
        Button buttonLesson2 = findViewById(R.id.buttonLesson2);
        Button buttonLesson3 = findViewById(R.id.buttonLesson3);

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
    }
}
