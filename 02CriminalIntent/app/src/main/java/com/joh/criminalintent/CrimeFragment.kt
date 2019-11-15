package com.joh.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

class CrimeFragment : Fragment() {

    private var mCrime: Crime? = null

    private var mTitleField: EditText? = null
    private var mDateButton: Button? = null
    private var mSolvedCheckbox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCrime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        initView(view)

        return view
    }

    private fun initView(view: View) {
        mTitleField = view.findViewById(R.id.crime_title)
        with(mTitleField) {
            this?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    mCrime!!.title = s.toString()
                }

                override fun afterTextChanged(s: Editable) {

                }
            })
        }

        mDateButton = view.findViewById(R.id.crime_date)
        with(mDateButton) {
            this?.text = mCrime!!.data.toString()
            this?.setEnabled(false)
        }

        mSolvedCheckbox = view.findViewById(R.id.crime_solved)
        with(mSolvedCheckbox) {
            this?.setOnCheckedChangeListener { _, isChecked -> mCrime!!.solved = isChecked }
        }
    }


}
