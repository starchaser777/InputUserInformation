package kr.ac.kopo.inputuserinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var textName: TextView
    lateinit var textEmail: TextView
    lateinit var btnDlg: Button
    lateinit var dlgEditName: EditText
    lateinit var dlgEditEmail: EditText
//    lateinit var textToast: TextView - 하단 setNegativeButton 부분 주석 참조.
    lateinit var dlgView: View
    lateinit var toastView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textName = findViewById<TextView>(R.id.textName)
        textEmail = findViewById<TextView>(R.id.textEmail)
        btnDlg = findViewById<Button>(R.id.btnDlg)

        btnDlg.setOnClickListener {
            dlgView = View.inflate(this@MainActivity, R.layout.dialog, null)
            var dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("사용자 정보 입력")
            dialog.setIcon(R.drawable.dialogicon)
            dialog.setView(dlgView)
            dialog.setPositiveButton("확인") { dialogL, which ->
                dlgEditName = dlgView.findViewById<EditText>(R.id.editName)
                dlgEditEmail = dlgView.findViewById<EditText>(R.id.editEmail)

                textName.text = dlgEditName.text.toString()
                textEmail.text = dlgEditEmail.text.toString()
            }
            dialog.setNegativeButton("취소") { dialogL, which ->
                toastView = View.inflate(this@MainActivity, R.layout.toast, null)
                var toast = Toast(this@MainActivity)
//                textToast = toastView.findViewById<TextView>(R.id.textToast) - 이미 텍스트뷰에 문자를 설정해두었으므로 생략.
//                textToast.text = "취소되었습니다."
                toast.view = toastView
                toast.duration = Toast.LENGTH_LONG
                toast.show()
            }
            dialog.show()
        }
    }


}