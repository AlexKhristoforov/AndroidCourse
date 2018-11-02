package alex.hristofor.courseproject.homework4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import alex.hristofor.courseproject.R;

public class Homework4Activity extends Activity{
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.sova);
        animationDrawable = (AnimationDrawable) imageView.getBackground();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animationDrawable.isRunning()) {
                    animationDrawable.start();
                } else {
                    animationDrawable.stop();
                }
            }
        });

        final EditText editText = findViewById(R.id.editText);
        final CustomView customView = findViewById(R.id.diagram);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.setNumbers(String.valueOf(editText.getText()));
                customView.invalidate();
                customView.setVisibility(View.VISIBLE);
            }
        });



    }
}
