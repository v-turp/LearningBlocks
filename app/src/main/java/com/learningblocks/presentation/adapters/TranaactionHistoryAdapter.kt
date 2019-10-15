package com.learningblocks.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.learningblocks.R
import com.learningblocks.presentation.activities.TransactionHistoryActivity
import kotlinx.android.synthetic.main.item_transaction_details.view.*

class TransactionHistoryAdapter( private val transactionDataList: ArrayList<Map<String, String>>):
    RecyclerView.Adapter<TransactionHistoryAdapter.TransHistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransHistoryViewHolder {
        val itemPriceInfo = LayoutInflater.from(parent.context).
                inflate(R.layout.item_transaction_details, parent, false) as ConstraintLayout
        return TransHistoryViewHolder(itemPriceInfo)
    }

    override fun onBindViewHolder(holder: TransHistoryViewHolder, position: Int) {
        holder.txtTransactionHash.text = transactionDataList.get(position).get(TransactionHistoryActivity.TRANSACTION_HASH)
        holder.txtTransactionDate.text = transactionDataList.get(position).get(TransactionHistoryActivity.TRANSACTION_DATE)
        holder.txtTransactionSendReceive.text = transactionDataList.get(position).get(TransactionHistoryActivity.TRANSACTION_SENT_RECEIVED)
    }

    override fun getItemCount(): Int {
        return transactionDataList.size
    }

    inner class TransHistoryViewHolder(constraintLayout: ConstraintLayout): RecyclerView.ViewHolder(constraintLayout){

//        val imgTransactionStatus: ImageView = constraintLayout.img_price_info
        val txtTransactionDate: TextView =    constraintLayout.txt_transaction_date
        val txtTransactionHash: TextView =    constraintLayout.txt_transaction_hash
        val txtTransactionSendReceive: TextView = constraintLayout.txt_transaction_send_receive
    }

}