package pucsim4.caterpillar

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.Window
import kotlinx.coroutines.*
import pucsim4.caterpillar.databinding.ActivityGameBinding

class game : AppCompatActivity() {
    lateinit var binding: ActivityGameBinding
    lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_game)
        binding=ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.start.isEnabled = true

        binding.start.setOnClickListener(object:View.OnClickListener {
            override fun onClick(p0: View?){
                job= GlobalScope.launch(Dispatchers.Main) {
                    while(job.isActive) {
                        binding.start.isEnabled = false
                        binding.start.visibility = INVISIBLE
                        delay(25)
                        val canvas: Canvas = binding.mysv.holder.lockCanvas()
                        binding.mysv.drawSomething(canvas)
                        binding.mysv.holder.unlockCanvasAndPost(canvas)
                    }
                }
            }
        })
        binding.resume.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                job = GlobalScope.launch(Dispatchers.Main) {
                    while(job.isActive) {
                        binding.resume.visibility=INVISIBLE
                        delay(25)
                        val canvas: Canvas = binding.mysv.holder.lockCanvas()
                        binding.mysv.drawSomething(canvas)
                        binding.mysv.holder.unlockCanvasAndPost(canvas)
                    }
                }
            }
        })
    }
    override fun onPause() {
        super.onPause()
        job.cancel()
    }

    override fun onResume() {
        super.onResume()
        if (binding.start.isEnabled == false){
            binding.resume.visibility=VISIBLE
        }
    }
}