package vn.songkhoe.ai
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import vn.songkhoe.ai.ai.NutritionEngine
import vn.songkhoe.ai.plan.*
class MainActivity:ComponentActivity(){override fun onCreate(b:Bundle?){super.onCreate(b);setContent{MaterialTheme{HealthApp()}}}}
@Composable fun HealthApp(){var tab by remember{mutableIntStateOf(0)};val target=NutritionEngine.targets(37,"male",170.0,55.0,1.4);Scaffold(bottomBar={NavigationBar{listOf("Hôm nay","Thực đơn","12 tuần","Tiến triển","AI").forEachIndexed{i,s->NavigationBarItem(selected=tab==i,onClick={tab=i},icon={},label={Text(s)})}}}){pad->Box(Modifier.padding(pad)){when(tab){0->Dashboard(target.kcal,target.proteinG);1->Menus();2->Training();3->Progress();else->Assistant()}}}}
@Composable fun Header(){Row(verticalAlignment=Alignment.CenterVertically){Surface(shape=CircleShape,tonalElevation=3.dp,modifier=Modifier.size(68.dp)){Box(contentAlignment=Alignment.Center){Text("S",style=MaterialTheme.typography.headlineMedium)}};Spacer(Modifier.width(12.dp));Column{Text("Tạ Ngọc Sáng",style=MaterialTheme.typography.titleLarge);Text("02/02/1989 • 170 cm • 55 kg");Text("Mục tiêu: tăng cân • tăng cơ • khỏe hơn")}}}
@Composable fun Dashboard(kcal:Int,protein:Int)=LazyColumn(Modifier.fillMaxSize().padding(18.dp),verticalArrangement=Arrangement.spacedBy(12.dp)){item{Header()};item{Text("Hôm nay",style=MaterialTheme.typography.headlineMedium)};item{Card{Column(Modifier.padding(16.dp)){Text("Mục tiêu dinh dưỡng");Text("$kcal kcal/ngày • $protein g protein/ngày");Text("Mức khởi đầu, điều chỉnh theo xu hướng cân nặng.")}}};item{Card{Column(Modifier.padding(16.dp)){Text("Tiến độ cân nặng");Text("Hiện tại 55,0 kg");LinearProgressIndicator(progress={0.25f},modifier=Modifier.fillMaxWidth());Text("Theo dõi trung bình 7 ngày.")}}};item{Card{Column(Modifier.padding(16.dp)){Text("Hôm nay");Text("✓ Ăn đủ bữa\n✓ Protein mỗi bữa\n✓ Uống nước đều\n✓ Tập hoặc phục hồi\n✓ Ngủ đủ")}}}}
@Composable fun Menus()=LazyColumn(Modifier.padding(16.dp),verticalArrangement=Arrangement.spacedBy(10.dp)){item{Text("Thực đơn Việt 30 ngày",style=MaterialTheme.typography.headlineMedium)};items(VietnameseMealPlan.days.size){i->val d=VietnameseMealPlan.days[i];Card{Column(Modifier.padding(14.dp)){Text("Ngày ${d.day} • ${d.kcal} kcal • ${d.protein} g protein");d.meals.forEach{Text("${it.meal}: ${it.foods}")}}}}}
@Composable fun Training()=LazyColumn(Modifier.padding(16.dp),verticalArrangement=Arrangement.spacedBy(10.dp)){item{Text("Giáo án tăng cơ 12 tuần",style=MaterialTheme.typography.headlineMedium)};items(TwelveWeekPlan.weeks.size){i->val w=TwelveWeekPlan.weeks[i];Card{Column(Modifier.padding(14.dp)){Text("Tuần ${w.week} • ${w.focus}");w.sessions.forEach{Text("• $it")};Text(w.note)}}}}
@Composable fun Progress()=LazyColumn(Modifier.padding(18.dp),verticalArrangement=Arrangement.spacedBy(12.dp)){item{Header()};item{Text("Dashboard sức khỏe",style=MaterialTheme.typography.headlineMedium)};item{Card{Column(Modifier.padding(16.dp)){Text("Cân nặng");Text("55,0 kg")}}};item{Card{Column(Modifier.padding(16.dp)){Text("Giấc ngủ");Text("Chưa có dữ liệu hôm nay")}}};item{Card{Column(Modifier.padding(16.dp)){Text("Vận động");Text("Chưa có dữ liệu hôm nay")}}}}
@Composable fun Assistant()=LazyColumn(Modifier.padding(18.dp),verticalArrangement=Arrangement.spacedBy(12.dp)){item{Header()};item{Text("Trợ lý sức khỏe",style=MaterialTheme.typography.headlineMedium)};item{Card{Column(Modifier.padding(16.dp)){Text("Gợi ý");Text("Ăn đủ năng lượng và protein. Đánh giá xu hướng cân nặng sau 2–3 tuần để điều chỉnh khẩu phần.")}}};item{Text("Ứng dụng hỗ trợ theo dõi sức khỏe, không thay thế chẩn đoán y khoa.")}}
