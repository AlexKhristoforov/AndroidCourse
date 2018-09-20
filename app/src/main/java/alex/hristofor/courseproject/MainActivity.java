package alex.hristofor.courseproject;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private TextView strFirst;
    private TextView strSecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button2);
        strFirst = (TextView) findViewById(R.id.textView);
        strSecond = (TextView) findViewById(R.id.textView2);

        strFirst.setOnClickListener(this);
        strSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAttributes();
            }
        });
    }

    public void viewBtn(View view) {
        swapAttributes();
    }

    @Override
    public void onClick(View v) {
        swapAttributes();
    }

    public void swapAttributes() {
        String temp = (String) strFirst.getText();
        strFirst.setText(strSecond.getText());
        strSecond.setText(temp);

        Drawable colorView = strFirst.getBackground();
        strFirst.setBackground(strSecond.getBackground());
        strSecond.setBackground(colorView);
    }
}
