package vn.songkhoe.ai.plan
data class WorkoutWeek(val week:Int,val focus:String,val sessions:List<String>,val note:String)
object TwelveWeekPlan{val weeks=(1..12).map{w->val phase=when(w){in 1..4->"Làm quen & kỹ thuật";in 5..8->"Tăng cơ nền tảng";else->"Tăng tiến & củng cố"};WorkoutWeek(w,phase,listOf("Buổi A: Squat, đẩy ngực, kéo lưng, hip hinge, plank","Buổi B: Split squat, đẩy vai, row, hip thrust, dead bug","Buổi C: Goblet squat, incline press, lat pull/row, Romanian deadlift, carry"),if(w%4==0)"Tuần đánh giá kỹ thuật, cân nặng và hồi phục." else "Tăng tải nhỏ khi kỹ thuật tốt.")}}
