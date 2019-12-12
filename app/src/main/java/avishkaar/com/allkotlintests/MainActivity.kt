package avishkaar.com.allkotlintests

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), AddStudentFragment.OnFragmentInteractionListener,StudentViewModel.CallbackFromViewholder {
    companion object {
        val TAG = ""
    }

    lateinit var studentViewModel: StudentViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        studentViewModel.validateInterface(this)
        studentViewModel.getAllUsersFromDatabase()

    }

    override fun onStudentSubmitted(student: StudentDataClass) {
        studentViewModel.insertIntoDatabase(student)
    }
    override fun callback(list: LiveData<List<StudentDataClass>>) {
        CoroutineScope(Dispatchers.Main).launch {
            list.observe(this@MainActivity, Observer {
                Log.e(TAG, it.toString())
            })
        }

        }


}
