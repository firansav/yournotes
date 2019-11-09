package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_drawer.*

class DrawerActivity : AppCompatActivity() {

    @Override
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(drawer_layout)

        setSupportActionBar(toolbar_drawer)
    }

}