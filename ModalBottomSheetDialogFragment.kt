package ua.redTeam.peopleForPeople.utils.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ua.redTeam.peopleForPeople.R


/**
 * Created by Roman Fedchenko
 * date 10.11.2021
 * author email pomeo77777@gmail.com
 */
class ModalBottomSheetDialogFragment() : BottomSheetDialogFragment() {


    private var fImgResId: Drawable? = null
    private var fTitleResId: String? = null
    private var fSTitleResId: String? = null
    private var fFirstBtnText: String? = null
    private var fSecBtnText: String? = null
    private var fFooterText: String? = null

    private lateinit var icon: ImageView
    private lateinit var title: TextView
    private lateinit var subtitle: TextView
    private lateinit var btnFirst: TextAndIconButton
    private lateinit var btnSecond: TextAndIconButton
    private lateinit var footerTxt: TextView

    lateinit var listener: ModalBottomSheetDialogFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        super.onInflate(context, attrs, savedInstanceState)
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ModalBtSheetFragment,
            0, 0).apply {

            try {
                fImgResId = getDrawable(R.styleable.ModalBtSheetFragment_fImgResId)
                fTitleResId = getString(R.styleable.ModalBtSheetFragment_fTitleResId)
                fSTitleResId = getString(R.styleable.ModalBtSheetFragment_fSTitleResId)
                fFirstBtnText = getString(R.styleable.ModalBtSheetFragment_fFirstBtnText)
                fSecBtnText = getString(R.styleable.ModalBtSheetFragment_fSecBtnText)
                fFooterText = getString(R.styleable.ModalBtSheetFragment_fFooterText)
            } finally {
                recycle()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.run {
            fTitleResId = getString("fTitleResId")
            fSTitleResId = getString("fSTitleResId")
            fFirstBtnText = getString("fFirstBtnText")
            fSecBtnText = getString("fSecBtnText")
            fFooterText = getString("fFooterText")
            if(this.getInt("fImgResId") > 0){
                fImgResId = ResourcesCompat.getDrawable(resources, this.getInt("fImgResId"), null)
            }

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.modal_bottom_sheet_dialog_fragment, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)

    }

    private fun initView(v: View) {

        icon = v.findViewById(R.id.icon)
        title = v.findViewById(R.id.title)
        subtitle = v.findViewById(R.id.subtitle)
        btnFirst = v.findViewById(R.id.btn_first)
        btnSecond = v.findViewById(R.id.btn_second)
        footerTxt = v.findViewById(R.id.tv_footer)


        fImgResId?.let{
            icon.setImageDrawable(it)
            icon.visibility = View.VISIBLE
        }

        fTitleResId?.let{
            title.text = it
            title.visibility = View.VISIBLE
        }

        fSTitleResId?.let{
            subtitle.text = it
            subtitle.visibility = View.VISIBLE
        }

        fFirstBtnText?.let{
            btnFirst.setText(it)
            btnFirst.visibility = View.VISIBLE
            btnFirst.setOnClickListener(300){listener.firstBtnClick()}
        }

        fSecBtnText?.let{
            btnSecond.setText(it)
            btnSecond.visibility = View.VISIBLE
            btnSecond.setOnClickListener(300){listener.secondBtnClick()}
        }

        fFooterText?.let{
            footerTxt.text = it
            footerTxt.visibility = View.VISIBLE
        }

    }


    companion object Builder {
        private val arguments: Bundle = Bundle()
        lateinit var ls: ModalBottomSheetDialogFragmentListener
        fun setIcon(iconResId: Int): Builder {
            arguments.putInt("fImgResId", iconResId)
            return this
        }

        fun setTitle(title: String?): Builder {
            title?.let {
                arguments.putString("fTitleResId", title)
            }
            return this
        }

        fun setSubTitle(subTitle: String?): Builder {
            subTitle?.let {
                arguments.putString("fSTitleResId", subTitle)
            }
            return this
        }

        fun setFirstBtn(firstBtnText: String?): Builder {
            firstBtnText?.let {
                arguments.putString("fFirstBtnText", firstBtnText)
            }
            return this
        }

        fun setSecondButton(secondBtnText: String?): Builder {
            secondBtnText?.let {
                arguments.putString("fSecBtnText", secondBtnText)
            }
            return this
        }

        fun setFooterText(footerText: String?): Builder {
            footerText?.let {
                arguments.putString("fFooterText", footerText)
            }
            return this
        }

        fun setListener(listener: ModalBottomSheetDialogFragmentListener): Builder {
            this.ls = listener
            return this
        }


        fun build(): ModalBottomSheetDialogFragment {
            val fragment = ModalBottomSheetDialogFragment()
            fragment.arguments = arguments
            fragment.listener = this.ls
            return fragment
        }

    }


}

interface ModalBottomSheetDialogFragmentListener{
    fun firstBtnClick()
    fun secondBtnClick()
}