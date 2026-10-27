package vn.edu.vlu.exam_week07

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
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
        val lvCourses = findViewById<ListView>(R.id.lvCourses)

        // Nhận chuỗi Email được gửi sang từ LoginActivity qua Intent/Bundle
        val receivedEmail = intent.getStringExtra("EXTRA_EMAIL") ?: "Không có dữ liệu"
        tvUserEmail.text = "Email người dùng: $receivedEmail"

        // Xử lý sự kiện nút Đăng xuất: gọi finish() để quay về màn hình trước
        btnLogout.setOnClickListener {
            finish()
        }
        // 4. Khởi tạo mảng dữ liệu môn học mẫu (ít nhất 5 phần tử)
        val courseList = listOf(
            "Lập trình Kotlin cơ bản",
            "Thiết kế Layout XML & ConstraintLayout",
            "Quản lý phiên bản mã nguồn Git/GitHub",
            "Điều hướng Activity qua Intent & Bundle",
            "Kiến trúc ứng dụng Android Native"
        )

        // 5. Sử dụng ArrayAdapter đưa dữ liệu lên ListView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            courseList
        )
        lvCourses.adapter = adapter

        // 6. Xử lý sự kiện click vào item trong ListView hiển thị Toast
        lvCourses.setOnItemClickListener { _, _, position, _ ->
            val selectedCourse = courseList[position]
            Toast.makeText(this, "Bạn đã chọn: $selectedCourse", Toast.LENGTH_SHORT).show()
        }
    }
}