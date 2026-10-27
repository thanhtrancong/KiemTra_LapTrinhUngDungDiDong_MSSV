package vn.edu.vlu.exam_week07

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Bắt buộc: Ánh xạ bằng findViewById
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Nhận chuỗi Email được gửi sang từ LoginActivity qua Intent/Bundle
        val receivedEmail = intent.getStringExtra("EXTRA_EMAIL") ?: "Không có dữ liệu"
        tvUserEmail.text = "Email người dùng: $receivedEmail"

        // Xử lý sự kiện nút Đăng xuất: gọi finish() để quay về màn hình trước
        btnLogout.setOnClickListener {
            finish()
        }
    }
}