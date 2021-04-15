package com.example.simplecounterkotlin.views

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.simplecounterkotlin.R
import com.example.simplecounterkotlin.databinding.ActivityMainBinding
import com.example.simplecounterkotlin.viewmodels.CounterViewModels


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var counterViewModels: CounterViewModels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        counterViewModels = ViewModelProvider(this).get(CounterViewModels::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            viewmodels = counterViewModels
        }

        counterViewModels.getCounter().observe(this, {
            binding.counter.text = it.toString()
        })

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        counterViewModels.onClickReset()
        return super.onOptionsItemSelected(item)
    }
}