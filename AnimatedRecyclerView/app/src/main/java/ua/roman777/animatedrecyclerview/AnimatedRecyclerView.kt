package ua.roman777.animatedrecyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import java.util.jar.Attributes


/**
 * Created by Roman Fedchenko
 * date 12.04.2021
 * author email pomeo77777@gmail.com
 */
class AnimatedRecyclerView @JvmOverloads constructor(context: Context,
                                                     attributes: AttributeSet? = null,
                                                     defStyleAttr: Int = 0 ) : RecyclerView(context, attributes, defStyleAttr) {

    private val startAnimationMargin: Float

    init {
        context.theme.obtainStyledAttributes(attributes, R.styleable.AnimatedRecyclerView, 0, 0)
            .apply {
                try{
                    startAnimationMargin = getDimension(R.styleable.AnimatedRecyclerView_startAnimationOffset, 100f)
                }finally {
                    recycle()
                }
            }
    }



    private val topMarginY: Float by lazy { startAnimationMargin}
    private val bottomMarginY: Float by lazy { height - startAnimationMargin}

    private val holders: MutableList<AnimatedItemHolder> = mutableListOf()


    override fun onScrolled(dx: Int, dy: Int) {
        super.onScrolled(dx, dy)
        holders.forEach {
            val  itemView = it.itemView
            when{
                itemView.didEnterFromTop(dy) -> it.onEnterFromTop()
                itemView.didEnterFromBottom(dy) -> it.onEnterFromBottom()
                itemView.didExitToTop(dy) -> it.onExitToTop()
                itemView.didExitToBottom(dy) -> it.onExitToBottom()
            }
        }
    }

    fun onAddViewHolder(animatedItemHolder: AnimatedItemHolder){
        holders.add(animatedItemHolder)
    }

    fun onRemoveViewHolder(animatedItemHolder: AnimatedItemHolder){
        holders.remove(animatedItemHolder)
    }


    private fun View.didEnterFromTop(dy: Int): Boolean =
        bottom >= topMarginY && bottom + dy < topMarginY

    private fun View.didEnterFromBottom(dy: Int): Boolean =
        top <= bottomMarginY && top + dy > bottomMarginY

    private fun View.didExitToTop(dy: Int): Boolean =
        bottom <= topMarginY && bottom + dy > topMarginY

    private fun View.didExitToBottom(dy: Int): Boolean =
        top >= bottomMarginY && top + dy < bottomMarginY
}