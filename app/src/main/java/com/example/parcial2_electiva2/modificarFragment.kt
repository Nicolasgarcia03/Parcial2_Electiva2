package com.example.parcial2_electiva2

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_modificar.*

class modificarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_modificar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pickButton: Button = pickerButton

        pickButton.setOnClickListener {
            val dialog = TimePickerDialog(requireContext(), { dialog,hour,minute ->
                editarTextView.setText(hour.toString().plus(":").plus(minute.toString()))
            }, 9, 28, false)
            dialog.show()
        }
    }
}