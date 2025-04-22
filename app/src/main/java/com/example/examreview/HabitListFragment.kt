package com.example.examreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HabitListFragment : Fragment() {

    private lateinit var habitAdapter: HabitAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_habit_list, container, false  )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        habitAdapter = HabitAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = habitAdapter

        val habits = listOf(
            Habit("Meditation", "10 minutes daily", "7:00 AM"),
            Habit("Workout", "30 minutes daily", "6:00 AM"),
            Habit("Reading", "15 minutes daily", "9:00 PM")
        )
        habitAdapter.submitList(habits)

        return view
    }
}