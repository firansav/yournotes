package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_fact.view.*

class FactAdapter : RecyclerView.Adapter<FactAdapter.FactHolder>() {
    private var facts: List<Fact> = ArrayList()

    class FactHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactHolder {
        val inflater = LayoutInflater.from(parent.context)
        //@TODO: ubah layout recycler view
        val view = inflater.inflate(R.layout.recyclerview_fact, parent, false)
        return FactHolder(view)
    }

    override fun onBindViewHolder(holder: FactHolder, position: Int) {
        val currentFact = facts[position]
        holder.view.fact.text = currentFact.fact
    }

    override fun getItemCount(): Int {
        return facts.size
    }

    fun setFact(fact: List<Fact>) {
        this.facts = fact
        notifyDataSetChanged()
    }
}