package vn.songkhoe.ai.plan
data class MealItem(val meal:String,val foods:String,val kcal:Int,val protein:Int)
data class DayMenu(val day:Int,val meals:List<MealItem>){val kcal get()=meals.sumOf{it.kcal};val protein get()=meals.sumOf{it.protein}}
object VietnameseMealPlan{private val t=listOf(MealItem("Sáng","Phở bò + trứng + chuối",620,32),MealItem("Phụ sáng","Sữa chua + yến mạch + hạt",320,14),MealItem("Trưa","Cơm + thịt nạc + rau + canh",760,42),MealItem("Phụ chiều","Sữa + bánh mì bơ đậu phộng",390,18),MealItem("Tối","Cơm + cá + rau + đậu phụ",700,40),MealItem("Trước ngủ","Sữa ấm",160,8));val days=(1..30).map{d->DayMenu(d,t)}}
