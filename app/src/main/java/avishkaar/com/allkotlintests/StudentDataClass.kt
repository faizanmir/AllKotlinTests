package avishkaar.com.allkotlintests

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userData")
data class StudentDataClass(
    @ColumnInfo
    val rollNumber: String,
    @ColumnInfo
    val studentclass: String,
    @ColumnInfo
    val studentName: String) {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}



