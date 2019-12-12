package avishkaar.com.allkotlintests

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudentIntoDatabase(student:StudentDataClass)
    @Delete
    suspend fun deleteStudentFromDatabase(student: StudentDataClass)

    @Query("Select * from userData")
     fun getAllStudents():LiveData<List<StudentDataClass>>

    @Query("Select * from userData where id = :id")
    suspend fun getStudentByid(id:Int):StudentDataClass

    @Update
    suspend fun updateStudentRecords(student: StudentDataClass)

    @Query("Select * from userData where studentName  LIKE :name")
    suspend fun getStudentsByName(name:String):List<StudentDataClass>

}