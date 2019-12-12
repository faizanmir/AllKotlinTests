package avishkaar.com.allkotlintests

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Repository(context: Context, var mListener: SetDataForViewModelClass) {

    var studentDataBase: StudentDataBase = StudentDataBase.getStudentDatabase(context)
    private var allData: MutableLiveData<List<StudentDataClass>> = MutableLiveData()

    interface SetDataForViewModelClass {
        fun passAllStudentList(list: LiveData<List<StudentDataClass>>)
        fun getStudentById(studentDataClass: StudentDataClass)
    }

    fun getAllStudents() {
        CoroutineScope(IO).launch {
            val result = async { studentDataBase.studentDao().getAllStudents() }
            mListener.passAllStudentList(result.await())
        }
    }


    fun getStudentById(id: Int) {
        CoroutineScope(IO).launch {
            val result = async { studentDataBase.studentDao().getStudentByid(id) }
            mListener.getStudentById(result.await())
        }

    }

    fun insertStudentIntoDatabase(studentDataClass: StudentDataClass) {
        CoroutineScope(IO).launch {
            studentDataBase.studentDao().insertStudentIntoDatabase(studentDataClass)
        }
    }


    suspend fun deleteStudentDatafromDatabase(studentDataClass: StudentDataClass) {
        CoroutineScope(IO).launch { studentDataBase.studentDao().deleteStudentFromDatabase(studentDataClass) }

    }

    suspend fun updateStudentInDatabase(studentDataClass: StudentDataClass) {
       CoroutineScope(IO).launch {  studentDataBase.studentDao().updateStudentRecords(studentDataClass) }
    }


}