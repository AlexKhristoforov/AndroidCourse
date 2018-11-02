package alex.hristofor.courseproject.homework3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import alex.hristofor.courseproject.R;


public class Homework3Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3);

        Button button = findViewById(R.id.buttonBot);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);

                final ProgressBar progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
                ImageView imageView = findViewById(R.id.imageView);
                String url =  editText.getText().toString();
                Picasso.get()
                        .load(url)
                       // .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.internet_error)
                        .transform(new Circle())
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {
                                progressBar.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onError(Exception e) {

                            }
                        });


            }
        });
    }
}
