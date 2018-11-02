package alex.hristofor.courseproject.homework5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

import alex.hristofor.courseproject.R;

public class ClockView extends View {
    private Context context;
    private Paint paintCircle;
    private Paint paintLine;
    private Paint paintFont;
    private int fontSize;


    public ClockView(Context context) {
        super(context);
        init(null);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintFont = new Paint(Paint.ANTI_ALIAS_FLAG);
        fontSize = 40;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //int halfTransparentWhiteColor = adjustAlpha(Color.BLUE, 1.5f);
        int colorGray = getResources().getColor(R.color.gray);
        int colorBlue = getResources().getColor(R.color.bluew);
        paintCircle.setColor(colorBlue);
        float radius = Math.min(getWidth() / 2, getHeight() / 2);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth() / 2, getHeight() / 2), paintCircle);

        paintFont.setTextSize(fontSize);
        paintFont.setStyle(Paint.Style.STROKE);
        paintFont.setColor(Color.WHITE);

        canvas.drawText("12", getWidth() / 2 - 20, getHeight() / 2 - radius * 2 / 3 - 70, paintFont);
        canvas.drawText("3", getWidth() / 2 + radius * 2 / 3 + 70, getHeight() / 2 + 10, paintFont);
        canvas.drawText("6", getWidth() / 2 - 10, getHeight() / 2 + radius * 2 / 3 + 90, paintFont);
        canvas.drawText("9", getWidth() / 2 - radius * 2 / 3 - 90, getHeight() / 2 + 10, paintFont);

        paintCircle.setColor(colorGray);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth() / 2, getHeight() / 100), paintCircle);
        float xEdge = getHeight() / 2 - radius;
        float xLine = getWidth() / 2;
        float yStartLine = xEdge * 0.9f;
        float yEndLine = xEdge * 1.1f;
        float step = 360 / 12;

        paintLine.setStrokeWidth(3);
        paintCircle.setColor(colorGray); paintLine.setColor(colorGray);
        canvas.drawLine(xLine, yStartLine, xLine, yEndLine, paintLine);
        canvas.save();
        paintLine.setColor(colorGray);
        for (int i = 0; i < 11; i++) {
            canvas.rotate(step, getWidth() / 2, getHeight() / 2);
            canvas.drawLine(xLine, yStartLine, xLine, yEndLine, paintLine);
        }
        canvas.restore();

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        canvas.save();
        paintLine.setColor(colorGray);
        canvas.rotate(step * hour + step / 60 * minutes, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(xLine, getHeight() / 2, xLine, getHeight() / 2 - radius / 3, paintLine);
        canvas.drawLine(xLine - radius / 16, getHeight() / 2 - radius / 4, xLine, getHeight() / 2 - radius / 3, paintLine);
        canvas.drawLine(xLine + radius / 16, getHeight() / 2 - radius / 4, xLine, getHeight() / 2 - radius / 3, paintLine);
        canvas.restore(); //change rotate to canvas.save


        float stepMinutes = 360 / 60;
        canvas.save();
        paintLine.setColor(colorGray);
        canvas.rotate(stepMinutes * minutes, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(xLine, getHeight() / 2, xLine, getHeight() / 2 - radius * 2 / 3, paintLine);
        canvas.drawLine(xLine - radius / 16, getHeight() / 2 - radius * 7 / 12, xLine, getHeight() / 2 - radius * 2 / 3, paintLine);
        canvas.drawLine(xLine + radius / 16, getHeight() / 2 - radius * 7 / 12, xLine, getHeight() / 2 - radius * 2 / 3, paintLine);
        canvas.restore();


    }

//    public static int adjustAlpha(@ColorInt int color, float factor) {
//        int alpha = Math.round(Color.alpha(color) * factor);
//        int red = Color.red(color);
//        int green = Color.green(color);
//        int blue = Color.blue(color);
//        return Color.argb(alpha, red, green, blue);
//    }

}
