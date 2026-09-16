package com.codeshod.room.wallet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallets")
data class WalletEntity(
    val title: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}