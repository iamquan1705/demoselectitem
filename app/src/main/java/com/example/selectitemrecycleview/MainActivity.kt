package com.example.selectitemrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selectitemrecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var listStudent = arrayListOf<Student>(
            Student(1, "quan"),
            Student(2, "quan"),
            Student(3, "quan"),
            Student(4, "quan"),
            Student(5, "quan"),
            Student(6, "quan"),
            Student(7, "quan"),
        )
        var check: Boolean = false
        var adapter: StudentAdapter = StudentAdapter(listStudent, onClick = onClick())
        binding.rcStudent.adapter = adapter
        binding.rcStudent.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.btnToast.setOnClickListener {
        }
        binding.btnSelect.setOnClickListener {
            adapter.check = !adapter.check
        }

    }

    private fun onClick(): (Student) -> Unit = {
        Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
    }
}