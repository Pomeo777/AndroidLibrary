package ua.redTeam.peopleForPeople.utils.ui;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Roman Fedchenko
 * date 05.04.2021
 * author email pomeo77777@gmail.com
 */
public class ViewTouchListener implements View.OnTouchListener{
    private final double LEFT_SIDE_WIDTH_FACTOR = 0.25;
    private final double RIGHT_SIDE_WIDTH_FACTOR= 0.75;
    private final double SWIPE_WIDTH_FACTOR = 0.1;
    private int startPositionX;
    private int  lastPositionX;

    private MyTouchEventListener eventListener;


    public ViewTouchListener(MyTouchEventListener eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch(event.getAction()& MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                startPositionX = (int) event.getX();
                eventListener.pause();
                break;

            case MotionEvent.ACTION_CANCEL:
                break;

            case MotionEvent.ACTION_UP:
                eventListener.resume();
                if(startPositionX < v.getWidth()*LEFT_SIDE_WIDTH_FACTOR && lastPositionX - startPositionX < v.getWidth()*SWIPE_WIDTH_FACTOR) {
                    eventListener.leftClick();
                }else if(startPositionX > v.getWidth()*RIGHT_SIDE_WIDTH_FACTOR && lastPositionX - startPositionX < v.getWidth()*SWIPE_WIDTH_FACTOR){
                    eventListener.rightClick();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                lastPositionX = (int)event.getX();
                break;
        }
        return true;
    }



    public interface MyTouchEventListener{
        void leftClick();
        void rightClick();
        void pause();
        void resume();
    }
}
