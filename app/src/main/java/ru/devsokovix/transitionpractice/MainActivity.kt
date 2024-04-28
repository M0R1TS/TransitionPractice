package ru.devsokovix.transitionpractice

import android.graphics.*
import android.os.Bundle
import android.transition.*
import android.util.TypedValue
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
        val width =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 420F, resources.displayMetrics)
                .toInt()
        val height =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 280F, resources.displayMetrics)
                .toInt()
        val rect1 = Rect(0, 0, width / 2, height / 2)
        val rect2 = Rect(0, 0, width, height)
        binding.img.clipBounds = rect1
        binding.img.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.root, ChangeClipBounds())
            binding.img.clipBounds = if (binding.img.clipBounds == rect1) rect2 else rect1
        }
    }
}
