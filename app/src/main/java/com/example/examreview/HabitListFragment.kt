package com.example.examreview

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examreview.receivers.BatteryReceiver
import com.example.examreview.services.HabitTimerService

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
        val quoteButton = view.findViewById<Button>(R.id.btnShowQuote)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        habitAdapter = HabitAdapter()
        recyclerView.adapter = habitAdapter

        habitAdapter.submitList(loadHabitsFromFile(requireContext()))

        buttonAddHabit.setOnClickListener {
            findNavController().navigate(R.id.action_habitListFragment_to_addHabitFragment)
        }

        quoteButton.setOnClickListener {
            findNavController().navigate(R.id.action_habitListFragment_to_quoteFragment)
        }

        //add this to show sync
      //  val intent = Intent(Intent.ACTION_BATTERY_LOW)
       // BatteryReceiver().onReceive(requireContext(), intent)

        // this is for foreground service meditation
       //val serviceIntent = Intent(requireContext(), HabitTimerService::class.java)
       // ContextCompat.startForegroundService(requireContext(), serviceIntent)


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
