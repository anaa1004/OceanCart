package com.example.oceancart.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.oceancart.R
import com.example.oceancart.common.model.UserRole
import com.example.oceancart.ui.theme.DarkBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun RoleSelector(
    selectedRole: UserRole?,
    onRoleSelected: (UserRole) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val roles = UserRole.values()

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {expanded = !expanded}
    ) {
        OutlinedTextField(
            value = selectedRole?.name ?: "",
            onValueChange = { },
            readOnly = true,
            placeholder = { Text("Pilih role") },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.person_rounded),
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            shape = RoundedCornerShape(50.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = DarkBlue,
                unfocusedBorderColor = DarkBlue
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false}
        ) {
            roles.forEach {
                role ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = if (role == UserRole.NELAYAN) "Nelayan" else "Pelanggan"
                        )
                    },
                    onClick = {
                        onRoleSelected(role)
                        expanded = false
                    }
                )
            }
        }
    }
}