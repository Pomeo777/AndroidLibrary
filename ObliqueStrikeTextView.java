package ua.redTeam.peopleForPeople.utils.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import ua.redTeam.peopleForPeople.R;

/**
 * Created by Roman Fedchenko
 * date 25.08.2020
 * author email pomeo77777@gmail.com
 */
public class ObliqueStrikeTextView  extends androidx.appcompat.widget.AppCompatTextView {
    private Paint paint;

    public ObliqueStrikeTextView(Context context)
    {
        super(context);
        init(context);
    }

    public ObliqueStrikeTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    public ObliqueStrikeTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        //replace with your color
        int dividerColor = resources.getColor(R.color.primary_text_lightTheme);

        paint = new Paint();
        paint.setColor(dividerColor);
        //replace with your desired width
        paint.setStrokeWidth(this.getWidth());
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawLine(0, getHeight(), getWidth(), 0, paint);
    }
}
