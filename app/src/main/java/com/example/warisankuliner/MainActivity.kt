package com.example.warisankuliner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.warisankuliner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {

    private lateinit var binding : ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController : NavController

//    private val list = ArrayList<Kuliner>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        // Set top-level fragments (the ones without back button)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.listKulinerBlank,  // Top-level destinations (no back button)
                R.id.aboutFragment      // Add all top-level fragments here
            ), binding.drawerlayout
        )

        binding.navigationView.setupWithNavController(navController)

        // Set toolbar as ActionBar
        setSupportActionBar(binding.materialToolbar)

        // Setup ActionBar with NavController and AppBarConfiguration
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Ensure the drawer is always unlocked, no back button
        navController.addOnDestinationChangedListener { _, _, _ ->
            binding.drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    //        binding.recyclerKuliner.setHasFixedSize(true)
//        list.addAll(getListKuliner())
//        showRecyclerKuliner()
    //    private fun showRecyclerKuliner(){
//        binding.recyclerKuliner.layoutManager = LinearLayoutManager(this)
//        val kulinerAdapter = KulinerAdapter(list)
//        binding.recyclerKuliner.adapter = kulinerAdapter
//
//
//    }
//
//
//
}