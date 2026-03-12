package com.example.oceancart.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.R
import com.example.oceancart.data.model.NavItem
import com.example.oceancart.ui.theme.Inter


@Composable
fun NavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    val items =
        listOf(
            NavItem(R.drawable.icons_home, "Beranda"),
            NavItem(R.drawable.icons_edukasi, "Edukasi"),
            NavItem(R.drawable.icons_cart, "Keranjang"),
            NavItem(R.drawable.icons_order, "Pesanan"),
            NavItem(R.drawable.icons_group, "Profil")
        )


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        items.forEachIndexed { index, item ->

            val selected = index == selectedIndex
            val color = if (selected) Color(0xFF2A7FFF) else Color.Gray

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onItemSelected(index) }
            ) {

                Icon(
                    painter = painterResource(item.icon),
                    contentDescription = item.label,
                    tint = color
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.label,
                    fontSize = 12.sp,
                    fontFamily = Inter,
                    color = color
                )
            }
        }
    }
}