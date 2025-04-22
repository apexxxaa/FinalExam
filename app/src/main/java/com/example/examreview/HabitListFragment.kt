package com.example.examreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HabitListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var habitAdapter: HabitAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_habit_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        habitAdapter = HabitAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = habitAdapter

        habitAdapter.submitList(loadHabitsFromFile(requireContext()))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val buttonAddHabit = view.findViewById<Button>(R.id.buttonAddHabit)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val defaultButton = view.findViewById<Button>(R.id.btnLoadDefaults)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        habitAdapter = HabitAdapter()
        recyclerView.adapter = habitAdapter

        habitAdapter.submitList(loadHabitsFromFile(requireContext()))

        buttonAddHabit.setOnClickListener {
            findNavController().navigate(R.id.action_habitListFragment_to_addHabitFragment)
        }

        defaultButton.setOnClickListener {
            val defaultHabits = listOf(
                Habit("Drink Water", "08:00", "8 cups/day"),
                Habit("Read Book", "21:00", "30 mins/day"),
                Habit("Sleep", "23:30", "6 Hours")
            )
            saveHabitsToFile(requireContext(), defaultHabits)
            habitAdapter.submitList(defaultHabits)
        }
    }





    }
