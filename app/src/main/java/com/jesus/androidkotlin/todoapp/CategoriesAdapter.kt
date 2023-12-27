package com.jesus.androidkotlin.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jesus.androidkotlin.R

class CategoriesAdapter(private val categories:List<TaskCategory>) :RecyclerView.Adapter<CategoriesViewHolder>() {
    //Cuando vayamos a crear el adapter para pintar el RecyclerView, tenemos que pasarle una lista
    //Es el que nos permite pintar las vistas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        //Crea una vista y la monta para que el onBindViewHolder le pase la info que tiene que mostrar
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount() = categories.size
    /*
    Lo mismo que poner:
    override fun getItemCount(): Int {
        return categories.size
    }
     */

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position])
    }
}