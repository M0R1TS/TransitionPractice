package ru.devsokovix.transitionpractice

import android.graphics.*
import android.os.Bundle
import android.transition.*
import android.util.TypedValue
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.devsokovix.transitionpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.img.scaleX = 0.5F
        binding.img.scaleY = 0.5F
        var i = 0
        binding.img.setOnClickListener{
            TransitionManager.beginDelayedTransition(binding.root, ChangeImageTransform())
            binding.img.scaleType = ImageView.ScaleType.values()[i % ImageView.ScaleType.values().size]
            i++
            Toast.makeText(this, binding.img.scaleType.name, Toast.LENGTH_LONG).show()
        }
    }
}
