package com.example.dialogwindowact

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val showButton: Button = findViewById(R.id.showButton)
        showButton.setOnClickListener {
            showAlertDialog()
        }
        }
    private fun showAlertDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Uninstall")
            .setMessage("Do you want to uninstall the app?")
            .setPositiveButton("Yes"){ dialog, which ->
                Toast.makeText(this, "The app is successfully uninstalled", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){dialog, which ->
                dialog.dismiss()
            }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}
