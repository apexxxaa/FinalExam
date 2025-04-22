package com.example.examreview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AddHabitFragment : Fragment(){

    private lateinit var habitNameEditText: EditText
    private lateinit var habitGoalEditText: EditText
    private lateinit var timePicker: TimePicker
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_habit, container, false)
    }

    @SuppressLint("DefaultLocale")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        habitNameEditText = view.findViewById(R.id.habitNameEditText)
        habitGoalEditText = view.findViewById(R.id.habitGoalEditText)
        timePicker = view.findViewById(R.id.timePicker)
        saveButton = view.findViewById(R.id.saveButton)

        saveButton.setOnClickListener{
            val name = habitNameEditText.text.toString()
            val goal = habitGoalEditText.text.toString()
            val time = String.format("%02d:%02d", timePicker.hour, timePicker.minute)


            if (name.isNotEmpty() && goal.isNotEmpty()) {
                val habit = Habit(name, time, goal)
                val habits = loadHabitsFromFile(requireContext()).toMutableList()
                habits.add(habit)
                saveHabitsToFile(requireContext(), habits)
                Toast.makeText(requireContext(), "Habit saved!", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            }

        }

    }

}