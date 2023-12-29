package com.jesus.androidkotlin.todoapp

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jesus.androidkotlin.R

class TodoActivity : AppCompatActivity() {
    private val categories = listOf(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other
    )

    private val tasks = mutableListOf<Task>(
        Task("PruebaBusiness", TaskCategory.Business),
        Task("PruebaPersonal", TaskCategory.Personal),
        Task("PruebaOther", TaskCategory.Other),
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    private lateinit var fabAddTask: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener{ showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) //Para que no se vea fondo blanco detras del cardView al tener borde
        val btnAddTask:Button = dialog.findViewById<Button>(R.id.btnAddTask)
        val edTask:EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val radioButtonSelectedId = rgCategories.checkedRadioButtonId
            val selectedRadioButton:RadioButton = dialog.findViewById(radioButtonSelectedId)
            val currentCategory:TaskCategory = when(selectedRadioButton.text) {
                "Negocios" -> TaskCategory.Business
                "Personal" -> TaskCategory.Personal
                else -> TaskCategory.Other //Si se poner "Otro" da error por no cubrir todos los casos
            }
            tasks.add(Task(edTask.text.toString(), currentCategory))
            updateTasks()
            dialog.hide()
        }
        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun updateTasks(){
        //tasksAdapter.notifyItemInserted(tasks.size) <- Forma mas optima, pero nos iteresa usar el DataSetChanged para despues
        tasksAdapter.notifyDataSetChanged()
    }
}