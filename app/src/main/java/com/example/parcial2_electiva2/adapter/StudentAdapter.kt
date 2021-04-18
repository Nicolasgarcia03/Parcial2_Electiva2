package com.example.parcial2_electiva2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2_electiva2.R
import com.example.parcial2_electiva2.model.Student
import kotlinx.android.synthetic.main.item_students.view.*

class StudentAdapter(val students: MutableList<Student>, val callback: (Student) -> Unit): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    class StudentViewHolder(itemView: View, val callback: (Student) -> Unit): RecyclerView.ViewHolder(itemView){
        fun bind(item: Student){
            itemView.nombreTextView.text = item.nombre
            itemView.apellidoTextView.text = item.apellido
            itemView.cedulaTextView.text = item.cedula
            itemView.telefonoTextView.text = item.telefono

            itemView.deleteButton.setOnClickListener {
                callback(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_students, parent, false)
        return StudentViewHolder(view, callback)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    fun addStudent(student: Student){
        students.add(student)
    }

    fun deleteStudent(student: Student){
        students.remove(student)
    }

}