package vn.edu.vlu.exam_week07

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // BẮT BUỘC: Ánh xạ View bằng findViewById (không dùng ViewBinding)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        // Xử lý sự kiện nhấn nút Đăng nhập
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            // 1. Kiểm tra trường dữ liệu bị bỏ trống
            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.setTextColor(Color.parseColor("#C53030"))
                tvStatus.text = "Vui lòng nhập đầy đủ Email và Mật khẩu!"
                return@setOnClickListener
            }

            // 2. Kiểm tra định dạng Email chuẩn
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.setTextColor(Color.parseColor("#C53030"))
                tvStatus.text = "Email không đúng định dạng!"
                return@setOnClickListener
            }

            // 3. Kiểm tra độ dài Mật khẩu tối thiểu 6 ký tự
            if (password.length < 6) {
                tvStatus.setTextColor(Color.parseColor("#C53030"))
                tvStatus.text = "Mật khẩu phải từ 6 ký tự trở lên!"
                return@setOnClickListener
            }

            // 4. Dữ liệu hợp lệ
            tvStatus.setTextColor(Color.parseColor("#2E7D32"))
            tvStatus.text = "Xác thực thành công!"
        }
    }
}