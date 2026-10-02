package vn.songkhoe.ai.data
import android.content.Context
import androidx.room.*
@Database(entities=[DailyHealth::class,Meal::class,Profile::class],version=1,exportSchema=false)
abstract class AppDatabase:RoomDatabase(){
 abstract fun dao():HealthDao
 companion object{@Volatile private var I:AppDatabase?=null;fun get(c:Context)=I?:synchronized(this){I?:Room.databaseBuilder(c,AppDatabase::class.java,"song_khoe_ai.db").build().also{I=it}}}
}
