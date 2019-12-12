package avishkaar.com.allkotlintests

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class StudentViewModel(applicationContext: Application) : AndroidViewModel(applicationContext) ,Repository.SetDataForViewModelClass{
    final var TAG =  this.javaClass.canonicalName

    interface CallbackFromViewholder {
        fun callback(list: LiveData<List<StudentDataClass>>)
    }
    lateinit var mListener:CallbackFromViewholder

    fun validateInterface(context: Context)
    {
        if(context is CallbackFromViewholder)
        {
            mListener = context
        }
    }


    var repository: Repository = Repository(applicationContext, this)


    fun getStudentByID(id: Int) {
     repository.getStudentById(id)


    }

    fun getAllUsersFromDatabase(){
      repository.getAllStudents()
    }


     fun insertIntoDatabase(studentDataClass: StudentDataClass) {
        repository.insertStudentIntoDatabase(studentDataClass)
    }

    suspend fun updateStudentData(studentDataClass: StudentDataClass) {
        repository.updateStudentInDatabase(studentDataClass)
    }

    suspend fun deleteStudent(studentDataClass: StudentDataClass) {
        repository.deleteStudentDatafromDatabase(studentDataClass)
    }

    override fun passAllStudentList(list: LiveData<List<StudentDataClass>>){

       mListener.callback(list)
    }

    override fun getStudentById(studentDataClass: StudentDataClass) {
        Log.e(TAG,studentDataClass.studentName)
    }



}