package com.example.dipeshlamapersistancestorageassignment2.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.dipeshlamapersistancestorageassignment2.R
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
    }

    override fun onClick(view: View?) {
        when (view) {
            btnWriteQuestions ->{
                writeContentToFile()
            }
        }
    }

    @Throws(FileNotFoundException:: class,IOException::class)
    private fun writeToFile (sourceText : String){
        val fileOutputStream: FileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE)
        val outputStreamWriter = OutputStreamWriter(fileOutputStream)
        outputStreamWriter.write(sourceText)
        outputStreamWriter.flush()
        outputStreamWriter.close()
    }

    private fun writeContentToFile (){
        val string : String = edtWriteQuestions.text.toString()
        if(!checkEmpty(string)){
            try {
                writeToFile(string)
            } catch (exception: java.lang.Exception){
                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkEmpty (string : String?) : Boolean {
        return string.isNullOrEmpty() || string.isNullOrBlank()
    }


//    private fun writeQuestions (){
//        val sourceText = edtWriteQuestions.text.toString()
//        if(isValid()){
//            val fileOutputStream : FileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE)
//            val outputStreamWriter = OutputStreamWriter(fileOutputStream)
//            outputStreamWriter.write(sourceText)
//            outputStreamWriter.flush()
//            outputStreamWriter.close()
//        }
//    }



//    private fun isValid () : Boolean {
//        when{
//            edtWriteQuestions.text.isEmpty() == true ->{
//                edtWriteQuestions.error = "please enter the question"
//                edtWriteQuestions.requestFocus()
//                return false
//            }
//        }
//        return true
//    }
}
