package com.example.oceancart.presentation.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.oceancart.data.model.StoreCart
import com.example.oceancart.ui.theme.DarkBlue

@Composable
fun StoreSection(
    store: StoreCart,
    onItemChecked: (Int) -> Unit,
    onStoreChecked: (Boolean) -> Unit,
    onIncreaseQty: (Int) -> Unit,
    onDecreaseQty: (Int) -> Unit
) {

    val storeChecked = store.items.all { it.isChecked }

    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = storeChecked,
                onCheckedChange = onStoreChecked,
                colors = CheckboxDefaults.colors( checkedColor = DarkBlue)
            )

            Text(
                store.storeName,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        store.items.forEach { item ->

            CartItemRow(
                item = item,
                onCheckedChange = {
                    onItemChecked(item.id)
                },
                onIncrease = {
                    onIncreaseQty(item.id)
                },
                onDecrease = {
                    onDecreaseQty(item.id)
                }
            )
        }
    }
}