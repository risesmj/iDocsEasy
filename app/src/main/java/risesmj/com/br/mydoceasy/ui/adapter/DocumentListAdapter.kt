package risesmj.com.br.mydoceasy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import risesmj.com.br.mydoceasy.MainActivity
import risesmj.com.br.mydoceasy.R.*
import risesmj.com.br.mydoceasy.data.model.DocumentPersonal

class DocumentListAdapter(private val dataSet: List<DocumentPersonal>) :
    RecyclerView.Adapter<DocumentListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(id.title)
        val icon: ImageView = view.findViewById(id.icon)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(layout.view_item_document, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = dataSet[position].title
        viewHolder.icon.setImageResource(dataSet[position].icon)

        viewHolder.itemView.setOnClickListener{
            (it.context as MainActivity).openUpdate(dataSet[position]) }
    }

    override fun getItemCount() = dataSet.size

}