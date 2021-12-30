package com.example.cleanarchitecturegraphqlwithcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturegraphqlwithcompose.ui.countries.CountriesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, CountriesFragment.newInstance())
        transaction.disallowAddToBackStack()
        transaction.commit()
    }
}