package com.ute.phamtranthanhvinh

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ute.phamtranthanhvinh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Khai báo biến binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Nạp layout XML thông qua hàm inflate()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Gọi hàm hiển thị thông tin mẫu để kiểm tra giao diện
        displayStudent("Nguyễn Văn A", 3.8, "nva@gmail.com")

        // Gọi thử tính điểm với also
        calculateAndAudit(8.5)
    }

    // ── 1. Gom nhóm thao tác hiển thị với 'with(binding)' ─────
    private fun displayStudent(name: String, gpa: Double, email: String) {
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

    // ── 3. Kiểm tra Null Safety với Safe Call ?.let ───────────
    private fun processAvatarUri(avatarUri: Uri?) {
        avatarUri?.let { validUri ->
            binding.imgAvatar.setImageURI(validUri)
            binding.tvAvatarStatus.text = "Đã tải ảnh đại diện!"
            toast("Ảnh đã được cập nhật")
        } ?: run {
            // Chạy khi avatarUri == null (dùng ảnh mặc định hệ thống hoặc drawable)
            binding.imgAvatar.setImageResource(android.R.drawable.ic_menu_gallery)
        }
    }

    // ── 4. Chèn hành động phụ (Side-Effects) với 'also' ────────
    private fun calculateAndAudit(rawScore: Double): Double {
        return (rawScore * 10.0 / 4.0)
            .also { finalScore ->
                Log.d("STUDENT_AUDIT", "Điểm hệ 10 quy đổi: $finalScore")
            }
            .also {
                toast("Đã tính xong điểm: $it")
            }
    }

    // Hàm hỗ trợ viết nhanh Toast để tránh lỗi Unresolved reference
    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}