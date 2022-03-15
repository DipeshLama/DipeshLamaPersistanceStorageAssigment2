package com.example.dipeshlamapersistancestorageassignment2.Ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dipeshlamapersistancestorageassignment2.R
import com.example.dipeshlamapersistancestorageassignment2.Utils.ErrorConstants
import kotlinx.android.synthetic.main.activity_read_write.*
import java.io.*

class ReadWriteActivity : AppCompatActivity(),View.OnClickListener {
    private val FILE_NAME = "assignment.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_write)
        initListener()
    }

    private fun initListener(){
        btnWriteQuestions.setOnClickListener(this)
        btnReadQuestions.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btnWriteQuestions ->{
                writeContentToFile()
            }
            btnReadQuestions ->{
                populateDataFromFile()
            }
        }
    }

    private fun populateDataFromFile(){
        try {
            txtViewQuestions.text = readFromFile(FILE_NAME)
            txtViewQuestions.visibility = View.VISIBLE
        } catch (exception : Exception) {
            Toast.makeText(applicationContext, ErrorConstants.exceptionError, Toast.LENGTH_SHORT).show()
            txtViewQuestions.visibility = View.GONE
        }
    }

    @Throws(FileNotFoundException::class,IOException::class)
    private fun readFromFile (filename :String) : String? {
        var readString : String? = ""
        val fileInputStream : FileInputStream = openFileInput(filename)
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder = StringBuilder(readString)
        while (bufferedReader.readLine().also { readString = it } != null){
            stringBuilder.append(readString)
        }
        inputStreamReader.close()
        return stringBuilder.toString()
    }

    @Throws(FileNotFoundException:: class,IOException::class)
    private fun writeToFile (file : File, sourceText : String) : File?{
        val fileWriter = FileWriter(file, true)
        fileWriter.write("$sourceText \n")
        fileWriter.flush()
        fileWriter.close()
        return file
    }

    private fun writeContentToFile (){
        val string : String = edtWriteQuestions.text.toString()
        val dir = getFilesDir()
        if(isValid()){
            try {
                writeToFile(File(dir,FILE_NAME),string)
            } catch (exception: Exception){
                Toast.makeText(applicationContext, ErrorConstants.exceptionError, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValid () : Boolean {
        when{
            edtWriteQuestions.text.isEmpty() == true ->{
                edtWriteQuestions.error = "please enter the question"
                edtWriteQuestions.requestFocus()
                return false
            }
        }
        return true
    }

    //    @Throws(FileNotFoundException:: class,IOException::class)
//    private fun writeToFile (sourceText : String){
//        val fileOutputStream: FileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE)
//        val outputStreamWriter = OutputStreamWriter(fileOutputStream)
//        outputStreamWriter.write("$sourceText  \n")
//        outputStreamWriter.flush()
//        outputStreamWriter.close()
//    }

}
