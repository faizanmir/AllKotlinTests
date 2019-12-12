package avishkaar.com.allkotlintests

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(StudentDataClass::class),version = 1,exportSchema = false)

abstract class StudentDataBase :RoomDatabase() {
    companion object{
        @Volatile var instance: StudentDataBase? = null
        fun getStudentDatabase(context: Context): StudentDataBase {
            if(instance == null)
            {
                instance =  Room.databaseBuilder(context,
                    StudentDataBase::class.java,"StudentDatabase").build()
            }
            return instance as StudentDataBase
        }


    }

    abstract fun studentDao() :StudentDao
}