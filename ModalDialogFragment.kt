package ua.redTeam.peopleForPeople.utils.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import ua.redTeam.peopleForPeople.R


/**
 * Created by Roman Fedchenko
 * date 12.01.2022
 * author email pomeo77777@gmail.com
 */
class ModalDialogFragment(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var fTitleResId: String? = null
    private var fSTitleResId: String? = null
    private var fFirstBtnText: String? = null
    private var fSecBtnText: String? = null
    private var fFooterText: String? = null

    private lateinit var title: TextView
    private lateinit var subtitle: TextView
    private lateinit var btnFirst: TextAndIconButton
    private lateinit var btnSecond: TextAndIconButton
    private lateinit var footerTxt: TextView

    private var listener: ModalDialogFragmentListener? = null

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ModalFragment,
            0, 0).apply {

            try {
                fTitleResId = getString(R.styleable.ModalFragment_dTitleResId)
                fSTitleResId = getString(R.styleable.ModalFragment_dSTitleResId)
                fFirstBtnText = getString(R.styleable.ModalFragment_dFirstBtnText)
                fSecBtnText = getString(R.styleable.ModalFragment_dSecBtnText)
                fFooterText = getString(R.styleable.ModalFragment_dFooterText)
            } finally {
                recycle()
            }
        }
        initViews()
    }

    private fun initViews() {
        inflate(context, R.layout.modal_dialog_fragment,this)

        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        btnFirst = findViewById(R.id.btn_first)
        btnSecond = findViewById(R.id.btn_second)
        footerTxt = findViewById(R.id.tv_footer)



        fTitleResId?.let{
            title.text = it
            title.visibility = View.VISIBLE
        }

        fSTitleResId?.let{
            subtitle.text = it
            subtitle.visibility = View.VISIBLE
        }

        fFirstBtnText?.let{
            setFirstBtn(it)
        }

        fSecBtnText?.let{
           setSecondButton(it)

        }

        fFooterText?.let{
            footerTxt.text = it
            footerTxt.visibility = View.VISIBLE
        }
    }

    fun setTitle(tt: String){
        title.text = tt
        title.visibility = View.VISIBLE
    }

    fun setSubtitle(st: String){
        subtitle.text = st
        subtitle.visibility = View.VISIBLE
    }

    fun setFirstBtn(firstBtnText: String) {
        btnFirst.setText(firstBtnText)
        btnFirst.visibility = View.VISIBLE
        btnFirst.setOnClickListener(300){
            listener?.firstBtnClick()
        }
    }

    fun setSecondButton(secondBtnText: String){
        btnSecond.setText(secondBtnText)
        btnSecond.visibility = View.VISIBLE
        btnSecond.setOnClickListener(300){
            listener?.secondBtnClick()
        }
    }

    fun setFooterText(footerText: String){
        footerTxt.text = footerText
        footerTxt.visibility = View.VISIBLE
    }

    fun setButtonsListener(listener: ModalDialogFragmentListener){
        this.listener = listener
    }
}

interface ModalDialogFragmentListener{
    fun firstBtnClick()
    fun secondBtnClick()
}