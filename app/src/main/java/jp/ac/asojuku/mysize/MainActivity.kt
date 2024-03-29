package jp.ac.asojuku.mysize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    pushの練習コメント
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editNeck = pref.getString("NECK","")
        val editSleeve = pref.getString("SLEEVE","")
        val editWaist = pref.getString("WAIST","")
        val editInseam = pref.getString("INSEAM","")

        neck.setText(editNeck)
        sleeve.setText(editSleeve)
        waist.setText(editWaist)
        inseam.setText(editInseam)

        save.setOnClickListener{onSaveTapped()}
        heightButton.setOnClickListener {
            val intent = Intent(this,HeightActivity::class.java)
            startActivity(intent)
        }

    }
    private fun onSaveTapped(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit{
            this.putString("NECK",neck.text.toString())
            this.putString("SLEEVE",sleeve.text.toString())
            this.putString("WAIST",waist.text.toString())
            this.putString("INSEAM",inseam.text.toString())
        }
    }
}
