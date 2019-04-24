package generator.master.realm.initial.buisiness.soot.com.texttolink

import android.app.SearchManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textEdit = findViewById<EditText>(R.id.editText2)
        textEdit.setOnFocusChangeListener { v, hasFocus ->
            val huga = textEdit.selectionStart
            Log.d("","")
        }

        textEdit.setOnClickListener {
            val carriageStart = textEdit.selectionStart
            val allText = textEdit.text
            val splitTexts = allText.toString().split("\n")


            if(allText.isEmpty()) {
                return@setOnClickListener
            }

            if(carriageStart >= allText.toString().length){
                return@setOnClickListener
            }

            val layout = textEdit.layout
            if(carriageStart != -1){
                val row = layout.getLineForOffset(carriageStart)
                if(!splitTexts[row].isEmpty()) {
                    goGoogle(splitTexts[row])
                }
            }
        }
    }

    fun goGoogle(qury: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.setClassName("com.google.android.googlequicksearchbox", "com.google.android.googlequicksearchbox.SearchActivity")
        intent.putExtra(SearchManager.QUERY, qury)
        startActivity(intent)
    }
}
