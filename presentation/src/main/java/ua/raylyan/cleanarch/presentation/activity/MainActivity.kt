package ua.raylyan.cleanarch.presentation.activity

import android.os.Bundle
import ua.raylyan.cleanarch.presentation.DaggerAppCompatActivity
import ua.raylyan.cleanarch.presentation.ListFragment
import ua.raylyan.cleanarch.presentation.R

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
        supportFragmentManager.beginTransaction().replace(R.id.container, ListFragment.newInstance()).commit()
    }
}