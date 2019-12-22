package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewpager_main.adapter = ViewPagerAdapter(supportFragmentManager, applicationContext)
        tabs.setupWithViewPager(viewpager_main)

        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        if (!wifiManager.isWifiEnabled) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("YourNotes requires internet connection to maximize the functionality of the application, please turn on the wifi connection.").setTitle("Wi-Fi Required")
            builder.setPositiveButton("Enable Wi-Fi") { _, _ ->
                wifiManager.isWifiEnabled = true
            }
            builder.setNegativeButton("No, Thanks") {_, _ ->

            }

            val dialog = builder.create()
            dialog.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return when (item.itemId) {
            R.id.language -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
