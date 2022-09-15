package com.example.apicall
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class DemoAdapter (val context: Context, val userList: List<DemoDataModelItem>):RecyclerView.Adapter<DemoAdapter.ViewHolder>() {
class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var userId:TextView
    var title:TextView
    init {
        userId=itemView.userId
        title=itemView.title
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      var itemView=LayoutInflater.from(context).inflate(R.layout.row_item,parent,false)
   return ViewHolder((itemView))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   holder.userId.text=userList[position].id.toString()
        holder.title.text=userList[position].title.toString()
    }

    override fun getItemCount(): Int {
       return userList.size
    }
}