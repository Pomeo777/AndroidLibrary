package ua.roman777.animatedrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Roman Fedchenko
 * date 12.04.2021
 * author email pomeo77777@gmail.com
 */
abstract class AnimatedItemHolder (view: View): RecyclerView.ViewHolder(view){

    abstract fun onEnterFromTop()
    abstract fun onExitToTop()
    abstract fun onEnterFromBottom()
    abstract fun onExitToBottom()
}