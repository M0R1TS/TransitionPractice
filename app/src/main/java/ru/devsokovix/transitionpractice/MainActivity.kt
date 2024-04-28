package ru.devsokovix.transitionpractice

import android.graphics.*
import android.os.Bundle
import android.transition.*
import android.util.TypedValue
import android.view.ViewGroup
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
        var expanded = false
        val transitionSet = TransitionSet()
            .addTransition(ChangeBounds())
            .addTransition(ChangeImageTransform())

        binding.img.setOnClickListener{
            expanded = !expanded
            TransitionManager.beginDelayedTransition(binding.root, transitionSet)
            val params: ViewGroup.LayoutParams = binding.img.layoutParams
            params.height = if (expanded) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT
            binding.img.layoutParams = params

            binding.img.scaleType = if (expanded) ImageView.ScaleType.CENTER_CROP else ImageView.ScaleType.FIT_CENTER
        }
    }
}
