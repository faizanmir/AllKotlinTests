package avishkaar.com.allkotlintests

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TestAdapter(private val dataList: ArrayList<Int>, private var onStudentSelected:OnStudentSelected) : RecyclerView.Adapter<TestAdapter.TestAdapterViewholder>() {
    interface OnStudentSelected{
        fun onAlphabetSelected(position :Int)
    }

    class TestAdapterViewholder(itemView: View, var mListener: OnStudentSelected) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        var textViewForTest: TextView = itemView.findViewById(R.id.textForRecyclerView)
        override fun onClick(p0: View?) {

            mListener.onAlphabetSelected(adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestAdapterViewholder {
        return TestAdapterViewholder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_test_recyclerview,parent,false),onStudentSelected)
    }

    override fun getItemCount(): Int {

         return dataList.size
    }

    override fun onBindViewHolder(holder: TestAdapterViewholder, position: Int) {
        holder.textViewForTest.text = dataList[position].toChar().toString()

    }


}