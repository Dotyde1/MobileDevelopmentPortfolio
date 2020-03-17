package com.example.l4t2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.l4t2.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM games")
    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Query("DELETE FROM games")
    suspend fun deleteAllGames()

    @Query("SELECT COUNT(*) FROM games WHERE result = 'win'")
    suspend fun getNumberOfWins(): Int

    @Query("SELECT COUNT(*) FROM games WHERE result = 'draw'")
    suspend fun getNumberOfDraws(): Int

    @Query("SELECT COUNT(*) FROM games WHERE result = 'loss'")
    suspend fun getNumberOfLosses(): Int
}