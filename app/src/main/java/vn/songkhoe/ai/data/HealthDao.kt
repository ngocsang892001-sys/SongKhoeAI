package vn.songkhoe.ai.data
import androidx.room.*
import kotlinx.coroutines.flow.Flow
@Dao interface HealthDao {
 @Query("SELECT * FROM DailyHealth ORDER BY date DESC") fun health():Flow<List<DailyHealth>>
 @Query("SELECT * FROM Meal ORDER BY date DESC, id DESC") fun meals():Flow<List<Meal>>
 @Query("SELECT * FROM Profile WHERE id=1") fun profile():Flow<Profile?>
 @Insert(onConflict=OnConflictStrategy.REPLACE) suspend fun saveHealth(v:DailyHealth)
 @Insert suspend fun addMeal(v:Meal)
 @Insert(onConflict=OnConflictStrategy.REPLACE) suspend fun saveProfile(v:Profile)
}
