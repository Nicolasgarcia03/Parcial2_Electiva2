package com.example.parcial2_electiva2.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.parcial2_electiva2.R
import kotlinx.android.synthetic.main.dialog_students.*

class StudentDialog(context: Context, val nombre: String, val apellido: String,
                    val cedula: String, val telefono: String,
                    private val callback: (String, String, String, String) -> Unit): Dialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_students)
        nombreEditText.setText(nombre)
        apellidoEditText.setText(apellido)
        cedulaEditText.setText(cedula)
        telefonoEditText.setText(telefono)
        saveButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val apellido = apellidoEditText.text.toString()
            val cedula = cedulaEditText.text.toString()
            val telefono = telefonoEditText.text.toString()
            callback(nombre, apellido, cedula, telefono)
            dismiss()
        }
    }
}