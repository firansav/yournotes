package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

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

            val dialog = builder.create()
            dialog.show()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this.applicationContext,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_DENIED
            ) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                ) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(
                            this,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        )
                    ) {

                        val builder = android.app.AlertDialog.Builder(this.applicationContext)
                        builder.setMessage("Permission to access the external storage is needed")
                            .setTitle("Permission Needed")

                        builder.setPositiveButton("OK") { dialog, id ->
                            ActivityCompat.requestPermissions(
                                this,
                                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                                1001
                            )
                        }

                        val dialog = builder.create()
                        dialog.show()
                    }
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        1001
                    )
                }
            }
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
