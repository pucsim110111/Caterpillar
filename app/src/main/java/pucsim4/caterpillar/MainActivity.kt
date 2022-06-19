package pucsim4.caterpillar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button =findViewById(R.id.gamestart)
        //val btn2: Button =findViewById(R.id.btn1)
        val about: Button =findViewById(R.id.about)

        btn1.setOnClickListener{
            val intent = Intent(this,game::class.java)
            startActivity(intent);
        }
        about.setOnClickListener{
            val view=View.inflate(this@MainActivity,R.layout.dialog_view,null)
            val builder=AlertDialog.Builder(this@MainActivity)
            builder.setView(view)

            val dialog=builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        }
    }
}