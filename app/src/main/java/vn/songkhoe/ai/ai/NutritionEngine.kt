package vn.songkhoe.ai.ai
import kotlin.math.roundToInt
data class Targets(val kcal:Int,val proteinG:Int)
object NutritionEngine{fun targets(age:Int,sex:String,heightCm:Double,weightKg:Double,activity:Double):Targets{val base=10*weightKg+6.25*heightCm-5*age+if(sex=="male")5 else -161;return Targets((base*activity+350).roundToInt(),(weightKg*1.6).roundToInt())}}
