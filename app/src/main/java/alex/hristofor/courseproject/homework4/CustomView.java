package alex.hristofor.courseproject.homework4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;


public class CustomView extends View {

    private Paint paint;
    private RectF rectF;
    private ArrayList<Integer> arrayInt;
    private int radius;

    public void setNumbers(String startText) throws NumberFormatException {
        arrayInt.removeAll(arrayInt);

        String middleText = startText.replaceAll("[^0-9\\s]", "");
        String endText = middleText.replaceAll("\\s+", " ");
        String finishText = endText.trim();

        for (String elem : finishText.split(" ")) {
            arrayInt.add(Integer.parseInt(elem));
        }
    }

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        arrayInt = new ArrayList<Integer>();
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        radius = Math.min(getWidth(), getHeight()) / 3;
        rectF = new RectF(
                getWidth() / 2 - radius,
                getHeight() / 2 - radius,
                getWidth() / 2 + radius,
                getHeight() / 2 + radius);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //окантовка круга
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawArc(
                rectF,
                0,
                360,
                true,
                paint);

        int numberSum = 0;
        int currentSum = 0;
        float currentAngle = 270;
        float sweepAngle;
        for (int i : arrayInt) {
            numberSum += i;
        }
        paint.setStyle(Paint.Style.FILL);
        for (int i : arrayInt) {
            currentSum += i;
            paint.setColor(getRandomColor());
            if (currentSum == numberSum) {
                if (currentAngle < 270) {
                    sweepAngle = 270 - currentAngle;
                } else
                    sweepAngle = 270 + 360 - currentAngle;
            } else {
                sweepAngle = 360 * i / numberSum;
            }
            canvas.drawArc(
                    rectF,
                    currentAngle,
                    sweepAngle,
                    true,
                    paint);
            currentAngle += sweepAngle;
            if (currentAngle >= 360) {
                currentAngle -= 360;
            }

            paint.setColor(Color.BLACK);
            canvas.save();
            canvas.rotate(currentAngle - 270, getWidth() / 2, getHeight() / 2);
            canvas.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight() / 2 - radius, paint);
            canvas.restore();
        }
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
