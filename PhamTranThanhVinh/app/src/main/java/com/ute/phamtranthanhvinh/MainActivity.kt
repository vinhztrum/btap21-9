package com.ute.phamtranthanhvinh

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ute.phamtranthanhvinh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Bước 1: Khai báo biến binding với lateinit var
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bước 2: Nạp layout XML thông qua hàm inflate()
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Bước 3: Truyền root view vào setContentView
        setContentView(binding.root)

        // Gọi hàm hiển thị thông tin mẫu để kiểm tra giao diện
        displayStudent("Nguyễn Văn A", 3.8, "nva@gmail.com")
    }

    // ── 1. Gom nhóm thao tác hiển thị với 'with(binding)' ─────
    private fun displayStudent(name: String, gpa: Double, email: String) {
        // Đã tách with(binding) xuống dòng để không bị dính dấu ghi chú
        with(binding) {
            tvName.text = name
            tvGpa.text = "Điểm tích lũy: $gpa"
            tvEmail.text = email
            btnUpdate.isEnabled = true
            progressBar.visibility = View.GONE
        }
    }

    // ── 2. Cấu hình Intent chuyển trang với 'apply' ──────────
    private fun openDetailActivity(studentId: String) {
        val detailIntent = Intent(this, DetailActivity::class.java).apply {
            putExtra("KEY_STUDENT_ID", studentId)
            putExtra("KEY_TIMESTAMP", System.currentTimeMillis())
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        startActivity(detailIntent)
    }
}