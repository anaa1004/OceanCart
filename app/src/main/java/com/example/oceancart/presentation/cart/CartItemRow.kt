package com.example.oceancart.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.oceancart.R
import com.example.oceancart.data.model.CartItem
import com.example.oceancart.ui.theme.DarkBlue

@Composable
fun CartItemRow(
    item: CartItem,
    onCheckedChange: (Boolean) -> Unit,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = item.isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors( checkedColor = DarkBlue)
        )

        Image(
            painter = painterResource(item.image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
        ) {

            Text(item.name)

            Text(item.weight)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = onDecrease) {
                Icon(
                    painter = painterResource(R.drawable.icon_minus),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }

            Text("${item.quantity}")

            IconButton(onClick = onIncrease) {
                Icon(
                    painter = painterResource(R.drawable.icon_plus),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
    }
}