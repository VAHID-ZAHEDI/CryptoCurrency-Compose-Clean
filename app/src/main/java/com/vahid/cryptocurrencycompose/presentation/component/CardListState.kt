package com.vahid.cryptocurrencycompose.presentation.component

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.vahid.cryptocurrencycompose.domain.model.CurrencyPrices
class CardListState( val list: SnapshotStateList<CurrencyPrices>) {
    fun onSelected(isSelected: Boolean, item: CurrencyPrices) {
        Log.d("qqq", "before: ${list[0].isExpanded}")
        Log.d("qqq", "before: ${item.isExpanded}")
        val iterator = list.listIterator()
        while (iterator.hasNext()) {
            val obj = iterator.next()

            if (obj.id != item.id) {
                iterator.set(obj.copy(isExpanded = false))
            } else {
                iterator.set(obj.copy(isExpanded = isSelected))
            }

        }
        Log.d("qqq", "onSelected: ${list[0].isExpanded}")
    }
}