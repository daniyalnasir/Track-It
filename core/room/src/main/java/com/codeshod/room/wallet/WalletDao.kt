package com.codeshod.room.wallet

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface WalletDao {

    @Insert
    suspend fun addWallet(walletEntity: WalletEntity)

    @Delete
    suspend fun deleteWallet(walletEntity: WalletEntity)

    @Query("SELECT * FROM wallets")
    suspend fun getAllWallet(): List<WalletEntity>

    @Query("DELETE FROM wallets")
    suspend fun deleteAllWallet()
}