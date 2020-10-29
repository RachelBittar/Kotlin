package bittar.rachel.aboutme

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import bittar.rachel.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var biding: ActivityMainBinding
    private var myName: MyName = MyName("Rachel")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        biding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        biding.myName = myName

        biding.doneButton.setOnClickListener{
            addNickName(it)
        }

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickName(it)
//        }
    }

    @SuppressLint("ServiceCast")
    fun addNickName(view: View) {


    biding.apply {
        nicknameText.text = biding.nicknameEdit.text
        invalidateAll()
        nicknameEdit.visibility = View.GONE
        doneButton.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    }

}
