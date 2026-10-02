package vn.songkhoe.ai.data
import androidx.room.*
@Entity data class DailyHealth(@PrimaryKey val date:String,val weightKg:Double?=null,val sleepHours:Double?=null,val steps:Int=0,val waterMl:Int=0,val exerciseMinutes:Int=0)
@Entity data class Meal(@PrimaryKey(autoGenerate=true) val id:Long=0,val date:String,val mealType:String,val foodName:String,val portion:String,val kcal:Int,val proteinG:Double,val imagePath:String?=null,val aiConfidence:Double?=null)
@Entity data class Profile(@PrimaryKey val id:Int=1,val age:Int=37,val sex:String="male",val heightCm:Double=170.0,val weightKg:Double=55.0,val targetWeightKg:Double=62.0,val activityFactor:Double=1.4)
