package pucsim4.caterpillar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window

class game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_game)
    }
}