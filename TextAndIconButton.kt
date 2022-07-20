package ua.redTeam.peopleForPeople.utils.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.TextViewCompat
import ua.redTeam.peopleForPeople.R


/**
 * Created by Roman Fedchenko
 * date 24.08.2021
 * author email pomeo77777@gmail.com
 */
class TextAndIconButton(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private lateinit var ivIcon: ImageView
    private lateinit var tvText: TextView
    private lateinit var container: ConstraintLayout


    private var bg: Drawable?
    private var textColor: Int = 0
    private var iconDrawable: Drawable?
    private var textResId: String? = ""
    private var titleStyleId: Int = -1
    private var padding: Int = 8
    private var iconSize: Int = 0
    private var showIconStart: Boolean = true


    init {
        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.TextAndIconButton,
                0, 0).apply {

            try {
                iconDrawable = getDrawable(R.styleable.TextAndIconButton_icon)
                textResId = getString(R.styleable.TextAndIconButton_text)
                bg = getDrawable(R.styleable.TextAndIconButton_bg)
                textColor = getColor(R.styleable.TextAndIconButton_textColor, 17170432)
                showIconStart = getBoolean(R.styleable.TextAndIconButton_showIconStart, true)
                titleStyleId = getResourceId(R.styleable.TextAndIconButton_bTextStyle, -1)
                padding  = getDimensionPixelOffset(R.styleable.TextAndIconButton_bPadding, 0)
                iconSize  = getDimensionPixelOffset(R.styleable.TextAndIconButton_iconSize, 0)
//                paddingV  = getDimensionPixelOffset(R.styleable.TextAndIconButton_android_paddingVertical, 0)
            } finally {
                recycle()
            }
        }
        initViews()
    }

    private fun initViews() {
        if(showIconStart){
            inflate(context, R.layout.start_icon_and_text_button_view, this)
        }else{
            inflate(context, R.layout.end_icon_and_text_button_view, this)
        }


        container = findViewById(R.id.cl_container)
        tvText = findViewById(R.id.tv_text)
        ivIcon = findViewById(R.id.iv_icon)

        iconDrawable?.also {
            setIcon(it)
        }

        bg?.also {
            container.background = bg
            container.setPadding(padding, padding, padding, padding )
        }

        textResId?.also {
            setText(it)
        }



    }

    fun setText(text: String){
        tvText.text = text
        tvText.visibility = View.VISIBLE
        TextViewCompat.setTextAppearance(tvText, titleStyleId)
        tvText.setTextColor(textColor)
    }

    fun setIcon(icon: Drawable){
        ivIcon.setImageDrawable(icon)
        ivIcon.visibility = View.VISIBLE
        if(iconSize > 0){
            ivIcon.layoutParams.height = iconSize
            ivIcon.layoutParams.width = iconSize
        }
    }


}