package com.example.oceancart.ui.components.pesanan

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.oceancart.R
import com.example.oceancart.ui.components.pesanan.StatusPesanan
import com.example.oceancart.ui.components.pesanan.StatusIcon

// composable function utk badge keterangan pesanan
@Composable
fun StatusBadge(status: StatusPesanan) {
    val statusData = when (status) {
        StatusPesanan.dikirim -> StatusIcon(Color(0xffD9EBF4), Color(0xff0077B6), R.drawable.icons_dikirim)
        StatusPesanan.belum_dibayar -> StatusIcon(Color(0xffFFD9D9), Color(0xffFF0000), R.drawable.icons_blm_dibayar)
        StatusPesanan.selesai -> StatusIcon(Color(0xffE2FFD9), Color(0xff3CFF00), R.drawable.icons_selesai)
        StatusPesanan.dibatalkan -> StatusIcon( Color(0xff595959), Color(0xffE6E6E6), R.drawable.icons_dibatalkan)
    }

    Box(
        modifier = Modifier
            .wrapContentWidth()
            .border(
                width = 1.dp,
                color = statusData.borderColor,
                shape = RoundedCornerShape(20.dp)
            )
            .background(statusData.bgColor, RoundedCornerShape(20.dp)) // akses via statusData
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(statusData.icons),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
    }
}