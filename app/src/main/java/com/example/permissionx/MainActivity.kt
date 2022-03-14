package com.example.permissionx

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.library.PermissionX
import java.lang.Exception
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    lateinit var makeCallBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeCallBtn = findViewById(R.id.makeCallBtn)
        makeCallBtn.setOnClickListener{
            PermissionX.request(this, android.Manifest.permission.CALL_PHONE){ allGranted, deniedList ->
                if(allGranted){
                    call()
                }else{
                    Toast.makeText(this,"you denied $deniedList", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
    private fun call(){
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}