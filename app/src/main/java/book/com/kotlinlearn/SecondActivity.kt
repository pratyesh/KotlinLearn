package book.com.kotlinlearn

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var second_textView: TextView
    var count: Int = 0
    lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        second_textView = findViewById(R.id.second_textView)

        initArguments()
        second_textView.text = "${second_textView.text}$title  $count"
//        second_textView.text = second_textView.text.toString() + title +"  "+ count
//        Log.d("SecondActivity", second_textView.text)
    }

    private fun initArguments() {
        val bundle : Bundle = intent.extras
        title = bundle.getString(TITLE)
        count = bundle.getInt(COUNT)
    }

    companion object {
        var TITLE: String = "TITLE"
        var COUNT: String = "COUNT"

        fun getInstance(context: Context, count: Int, title: String): Intent {
            val intent = Intent(context, SecondActivity::class.java);

            val bundle = Bundle();

            bundle.putInt(COUNT, count)
            bundle.putString(TITLE, title)

            intent.putExtras(bundle)

            return intent;
        }
    }
}