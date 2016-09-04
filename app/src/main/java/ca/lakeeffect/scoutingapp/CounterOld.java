package ca.lakeeffect.scoutingapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

@SuppressWarnings("unused")
public class CounterOld extends TextView {

    int count;

    char up = '\u2303';
    char down = '\u2304';

    Paint font = new Paint();

    public CounterOld(Context context) {
        this(context, null);
    }

    public CounterOld(Context context, AttributeSet attrs) {
        super(context, attrs);
        font.setTextSize(this.getHeight()/3);
    }

    @Override
    public void onDraw(Canvas canvas){
        canvas.drawText(up+"", 0, 0, font);
        canvas.drawText(count+"", 0, getHeight()/3, font);
        canvas.drawText(down+"",  0, getHeight() - getHeight()/3, font);

    }

    @Override
    public boolean onTouchEvent(MotionEvent e){

        if(e.getAction() == MotionEvent.ACTION_UP){
            if(e.getY()<getHeight()/2) {
                count++;
            }else{
                count--;
            }
        }

        return e.getAction() == MotionEvent.ACTION_UP;
    }
}
