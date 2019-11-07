package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Activity
import android.Manifest
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.core.content.ContextCompat.checkSelfPermission
import kotlinx.android.synthetic.main.activity_create_notes.*

class CreateNoteActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE =
            "d.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.EXTRA_TITLE"
        const val EXTRA_DESCRIPTION =
            "d.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.EXTRA_DESCRIPTION"

        private val IMAGE_PICK_CODE = 1000;
        private val PERMISSION_CODE = 1001;

        private val image = false;
    }

    var id = 0;
    private lateinit var viewModel: NotesViewModel
    private var imageList = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_notes)

        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
//        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)


        button_createnote.setOnClickListener {
            if (addnote_title.text.toString().trim().isBlank() || addnote_description.text.toString().trim().isBlank()) {
                Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
            } else {
                saveNote()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        imageview_note_photo.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (this.getApplicationContext()?.let { it1 ->
                        checkSelfPermission(
                            it1,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        )
                    } != PackageManager.PERMISSION_GRANTED) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                } else {
                    //permission already granted
                    pickImageFromGallery();
                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }
    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    private fun saveNote() {

        val newNote = Notes(
            imageList,
            addnote_title.text.toString(),
            addnote_description.text.toString()
        )

        viewModel.insert(newNote)
        Toast.makeText(this, "Note created", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery()
                } else {
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            imageList = (data?.data).toString()
            imageview_note_photo.setImageURI(data?.data)
        }
    }

}