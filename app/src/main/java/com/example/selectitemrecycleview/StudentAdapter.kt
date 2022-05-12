package com.example.selectitemrecycleview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selectitemrecycleview.databinding.ItemStudentBinding

class StudentAdapter(
    private var listStudent: List<Student>,
    private var onClick: (Student) -> Unit,

    ) :
    RecyclerView.Adapter<StudentAdapter.ViewHodel>() {

    var listCheck = arrayListOf<Student>()
    var check: Boolean = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodel {
        return ViewHodel(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHodel, position: Int) {
        holder.bind(listStudent[position])
        holder.itemView.setOnClickListener {
            holder.clickItem(listStudent[position])
        }
    }

    override fun getItemCount(): Int = listStudent.size


    inner class ViewHodel(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.tvID.text = student.id.toString()
            binding.tvName.text = student.name
            if (check) {
                binding.cbCheck.visibility = View.GONE
            } else {
                binding.cbCheck.visibility = View.VISIBLE
            }
        }

        fun clickItem(student: Student) {
            if (check) {
                binding.cbCheck.isChecked = !binding.cbCheck.isChecked
                if (binding.cbCheck.isChecked) {
                    listCheck.add(student)
                } else {
                    listCheck.remove((student))
                }
            } else {
                onClick(student)
            }
        }
    }
}