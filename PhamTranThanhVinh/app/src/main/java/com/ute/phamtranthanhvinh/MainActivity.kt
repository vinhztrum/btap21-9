package com.ute.phamtranthanhvinh
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentprofile.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    // Bước 1: Khai báo biến binding với lateinit var
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// Bước 2: Nạp layout XML thông qua hàm inflate()
        binding = ActivityMainBinding.inflate(layoutInflater)
// Bước 3: Truyền root view vào setContentView
        setContentView(binding.root)
// Bước 4: Thao tác View trực tiếp, không lo Null!
        binding.tvWelcome.text = "Chào mừng bạn đến với ViewBinding!"
    }
}