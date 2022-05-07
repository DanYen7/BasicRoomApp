package com.example.basicroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicroomapp.database.DatabaseManager
import com.example.basicroomapp.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*mainViewModel.saveUser(User(
            "Userid0001",
            "name0001",
            1.71,
            71.1,
            "user001@email.com",
        "passworduser0001"
        ))*/


        mainViewModel.getUsers()
        //conragment es con viewLifecycleOer
        mainViewModel.savedUsers.observe(this, {usersList ->
            if(!usersList.isNullOrEmpty()){
                for (user in usersList)
                Log.d("theusers", user.user_name)
            }else{
                Log.d("theusers","null or empty" )
            }
        })

}
}