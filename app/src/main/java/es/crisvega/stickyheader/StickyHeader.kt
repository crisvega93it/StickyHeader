package es.crisvega.stickyheader

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeader(modifier: Modifier) {
    val contactos: Map<Char, List<Model>> = getContacts().groupBy { it.nombre.first() }
    LazyColumn(modifier = modifier.fillMaxSize()) {
        contactos.forEach { (nombre, contactos) ->
            stickyHeader{
                Text(text = nombre.toString())
            }
            items(contactos){
                contacto -> ItemConcacto(model = contacto) {}
            }
        }
    }

}

@Composable
fun ItemConcacto(model: Model,onItemSelected: (Model) -> Unit) {
    Card(border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {onItemSelected(model)  }){
        Column(Modifier.padding(5.dp)) {
            Text(text = model.nombre  +" " + model.apellidos, fontSize = 15.sp)
            Text(text = model.telefono, fontSize = 15.sp)
            Text(text = model.email, fontSize = 15.sp)
        }
    }
}

fun getContacts(): List<Model>{
    return listOf(
        Model("Cristian","Vega","crisvega@gmail.com","66664254566"),
        Model("Juan","Perez","jperez@gmail.com","662755666"),
        Model("Maria","Lopez","mlopez@gmail.com","66662406"),
        Model("Laura","Garcia","lgarcia@gmail.com","66654666"),
        Model("Pedro","Martin","pmartin@gmail.com","66663366"),
        Model("Ana","Fernandez","afernandez@gmail.com","660246666"),
        Model("Carlos","Sanchez","csanchez@gmail.com","66755566"),
        Model("Sofia","Ramirez","sramirez@gmail.com","6665256"),
        Model("Antonio","Gonzalez","agonzalez@gmail.com","66653666"),
        Model("Isabel","Torres","itorres@gmail.com","66664566"),
        Model("David","Jimenez","djimenez@gmail.com","66458966"),
        Model("Elena","Ruiz","eruiz@gmail.com","6645654366"),
        Model("Javier","Diaz","jdiaz@gmail.com","6666554566"),
        Model("Marta","Hernandez","mhernandez@gmail.com","66666474665"),
        Model("Daniel","Lopez","dlopez@gmail.com","6666465435"),
        Model("Lucia","Gutierrez","lgutierrez@gmail.com","3425246"),
        Model("Pablo","Molina","pmolina@gmail.com","664556666"),
        Model("Carmen","Sanz","csanz@gmail.com","66668776"),
        Model("Fernando","Castro","fcastro@gmail.com","66342243666"),
        Model("Natalia","Navarro","nnavarro@gmail.com","6665676"),
        Model("Raul","Ortiz","rortiz@gmail.com","663543366"),
        Model("Beatriz","Vargas","bvargas@gmail.com","66675666")
    )
}