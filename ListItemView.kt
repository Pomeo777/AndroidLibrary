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
 * date 06.08.2021
 * author email pomeo77777@gmail.com
 */
class ListItemView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {


    lateinit var ivImg: ImageView
    lateinit var tvTitle: TextView
    lateinit var tvSubtitle: TextView


    var imgResId: Drawable?
    var titleResId: String? = ""
    var subtitleResId: String? = ""

    var titleStyleId: Int = -1
    var subtitleStyleId: Int = -1

    init {
        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.ListItemView,
                0, 0).apply {

            try {



                titleStyleId = getResourceId(R.styleable.ListItemView_titleStyle, -1)
                subtitleStyleId = getResourceId(R.styleable.ListItemView_subtitleStyle, -1)
                imgResId = getDrawable(R.styleable.ListItemView_imgResId)
                titleResId = getString(R.styleable.ListItemView_tResId)
                subtitleResId = getString(R.styleable.ListItemView_stResId)


//
//
//                val titleAttributeSet = intArrayOf(android.R.attr.textColor, android.R.attr.textSize, android.R.attr.fontFamily)
//                titleTypedArray = context.theme.obtainStyledAttributes(titleStyleId, titleAttributeSet)
//
//                val subtitleAttributeSet = intArrayOf(android.R.attr.textColor, android.R.attr.textSize, android.R.attr.fontFamily)
//                subtitleTypedArray = context.theme.obtainStyledAttributes(subtitleStyleId, subtitleAttributeSet)

            } finally {
                recycle()
            }
        }
        initViews()
    }

    private fun initViews() {
        inflate(context, R.layout.list_item_view, this)


        ivImg = findViewById(R.id.ivImg)
        tvTitle = findViewById(R.id.tvTitle)
        tvSubtitle = findViewById(R.id.tvSubtitle)

        imgResId?.also {
            ivImg.setImageDrawable(it)
            ivImg.visibility = View.VISIBLE
        }

        titleResId?.also {
            tvTitle.setText(it)
            tvTitle.visibility = View.VISIBLE
            TextViewCompat.setTextAppearance(tvTitle, titleStyleId)

        }

        subtitleResId?.also {
            tvSubtitle.setText(it)
            tvSubtitle.visibility = View.VISIBLE
            TextViewCompat.setTextAppearance(tvSubtitle, subtitleStyleId)

        }


    }
}