package com.example.solve

import android.os.Bundle

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import info.hoang8f.widget.FButton

import android.content.Intent
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_home.*
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount





class MainMenuActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    //private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> { //HOME
                //textMessage.setText(R.string.title_home)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> { //EXPLORE
                //textMessage.setText(R.string.title_explore)
                //supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ExploreFragment() ).commit()
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    TopicSelectFragment()
                ).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> { //SETTINGS
                //textMessage.setText(R.string.title_notifications)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SettingsFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_account -> {
                //textMessage.setText(R.string.title_account)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AccountFragment()).commit()
                return@OnNavigationItemSelectedListener true

            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.angela_activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        //textMessage = findViewById(R.id.)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, HomeFragment()).commit()
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        //auth

    }

    public override fun onStart() {
        super.onStart()
//        val account = GoogleSignIn.getLastSignedInAccount(this)
//        updateUI(account)
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        var fragmentAccount = getSupportFragmentManager().findFragmentById(R.id.navigation_account)
//        (fragmentAccount as AccountFragment).setCurrentUser(currentUser)

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.


        //updateUI(currentUser) //you log in as someone
    }



}
