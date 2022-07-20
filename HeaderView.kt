package ua.redTeam.peopleForPeople.utils.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import ua.redTeam.peopleForPeople.R


/**
 * Created by Roman Fedchenko
 * date 05.08.2021
 * author email pomeo77777@gmail.com
 */
class HeaderView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    lateinit var backButton: ImageView
    lateinit var menuButton: ImageView
    lateinit var bottomDivider: ImageView
    lateinit var title: TextView
    lateinit var subtitle: TextView

    var backBtnResId: Drawable?
    var menuBtnResId: Drawable?
    var titleResId: String? = ""
    var subtitleResId: String? = ""
    var showDivider: Boolean = false

    init {
        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.HeaderView,
                0, 0).apply {

            try {
                backBtnResId = getDrawable(R.styleable.HeaderView_backBtnResId)
                menuBtnResId = getDrawable(R.styleable.HeaderView_menuBtnResId)
                titleResId = getString(R.styleable.HeaderView_titleResId)
                subtitleResId = getString(R.styleable.HeaderView_subtitleResId)
                showDivider = getBoolean(R.styleable.HeaderView_showBottomDivider, false)
            } finally {
                recycle()
            }
        }
        initViews()
    }

    private fun initViews() {
        inflate(context, R.layout.menu_and_back_header,this);

        backButton = findViewById(R.id.btn_back)
        menuButton = findViewById(R.id.btn_menu)
        title = findViewById(R.id.tv_header_title)
        subtitle = findViewById(R.id.tv_header_subtitle)
        bottomDivider = findViewById(R.id.iv_bottom_divider)

        backBtnResId?.also {
            backButton.setImageDrawable(backBtnResId)
            backButton.visibility = View.VISIBLE
        }

        menuBtnResId?.also {
            menuButton.setImageDrawable(menuBtnResId)
            menuButton.visibility = View.VISIBLE
        }

        titleResId?.also {
            title.setText(titleResId)
            title.visibility = View.VISIBLE
        }

        subtitleResId?.also {
            subtitle.setText(subtitleResId)
            subtitle.visibility = View.VISIBLE
        }

        if(showDivider){
            bottomDivider.visibility = View.VISIBLE
        }

    }

    fun setOnBackButtonClickListener(listener: View.OnClickListener){
        backButton.setOnClickListener(listener)

    }

    fun setOnMenuButtonClickListener(listener: View.OnClickListener){
        menuButton.setOnClickListener(listener)
    }

    fun setTitle(tt: String){
        title.text = tt
        title.visibility = View.VISIBLE
    }

    fun setSubtitle(st: String){
        subtitle.text = st
        subtitle.visibility = View.VISIBLE
    }

    fun setBackButtonDrawable(resId: Int){
        backButton.setImageResource(resId)
        backButton.visibility = View.VISIBLE
    }

    fun hideMenuButton(){
        menuButton.visibility = View.INVISIBLE
    }


}