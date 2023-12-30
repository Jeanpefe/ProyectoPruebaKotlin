package com.jesus.androidkotlin.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jesus.androidkotlin.R

class TasksAdapter(private val tasks:List<Task>, private val onTaskSelected: (Int) -> Unit) :RecyclerView.Adapter<TasksViewHolder>() {
    //Cuando vayamos a crear el adapter para pintar el RecyclerView, tenemos que pasarle una lista
    //Es el que nos permite pintar las vistas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        //Crea una vista y la monta para que el onBindViewHolder le pase la info que tiene que mostrar
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view)
    }

    override fun getItemCount() = tasks.size
    /*
    Lo mismo que poner:
    override fun getItemCount(): Int {
        return categories.size
    }
     */

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        holder.itemView.setOnClickListener{onTaskSelected(position)}

    }
}