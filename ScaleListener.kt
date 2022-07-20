package ua.redTeam.peopleForPeople.utils.ui

import android.view.ScaleGestureDetector
import android.widget.ImageView
import kotlin.math.max
import kotlin.math.min


/**
 * Created by Roman Fedchenko
 * date 05.01.2021
 * author email pomeo77777@gmail.com
 */
class ScaleListener(var scaleFactor : Float, val imageView : ImageView) : ScaleGestureDetector.SimpleOnScaleGestureListener() {

    override fun onScale(detector: ScaleGestureDetector?): Boolean {
        if(detector != null){
            scaleFactor *= detector.scaleFactor
            scaleFactor = max(0.1f,
                    min(scaleFactor, 10.0f))

            imageView.scaleX = scaleFactor;
            imageView.scaleY = scaleFactor;
            return true
        }


        return false
    }
}