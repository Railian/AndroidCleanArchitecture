package ua.raylyan.cleanarch.presentation

import android.os.Bundle

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
        supportFragmentManager.beginTransaction().replace(R.id.container, ListFragment.newInstance()).commit()
    }
}