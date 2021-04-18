package com.example.parcial2_electiva2

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial2_electiva2.adapter.StudentAdapter
import com.example.parcial2_electiva2.dialog.StudentDialog
import com.example.parcial2_electiva2.model.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AddStudents()
        StudentsList()
        nextButton.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            this.startActivity(intent)
        }
    }

    private fun AddStudents(){
        addButton.setOnClickListener{
            val dialog = StudentDialog(this, "", "","",""){ nombre, apellido, cedula, telefono ->
                addstudent(nombre, apellido, cedula, telefono)
            }
            dialog.show()
        }
    }

    private fun StudentsList() {
        val students = mutableListOf(Student("Osler Nicolas", "Garcia Muñoz", "1020304050","3203456789"),
                Student("Rafael", "Pereira Aria", "34567890", "3145678908"),
                Student("Cesar", "Canabal", "78234567", "3132234567"),
                Student("Diego", "Amador", "1017234567", "3203456789"))

        adapter = StudentAdapter(students) { item ->
            deleteStudent(item)
        }
        productRecyclerView.adapter = adapter
        productRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun addstudent(nombre: String, apellido: String, cedula: String, telefono: String) {
        val student = Student(nombre, apellido, cedula, telefono)
        adapter.addStudent(student)
        adapter.notifyDataSetChanged()
    }

    private fun deleteStudent(student: Student) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar registro")
        builder.setMessage("¿Esta seguro que desea eliminar el registro?")
        builder.setPositiveButton("Aceptar") { _, _ ->
            adapter.deleteStudent(student)
            adapter.notifyDataSetChanged()
        }
        builder.setNegativeButton("Cancelar") { _,_ ->
            Toast.makeText(this, "No se ha eliminado el registro", Toast.LENGTH_LONG).show()
        }
        builder.setCancelable(false)
        builder.show()

    }
}