package com.inter_rapidisimo.intercommerceapp.presentation.splash

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inter_rapidisimo.intercommerceapp.presentation.common.widgets.IsometricBoxIcon

@Composable
fun OfflineSplashScreen(
    lastUpdatedText: String = "hoy, 9:32 a. m.",
    onExploreOfflineCatalog: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC72C))
            .padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top Section (Header + Hero)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 28.dp)
            ) {
                // Header Logo + App Name
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF1A1A1A)),
                        contentAlignment = Alignment.Center
                    ) {
                        IsometricBoxIcon(
                            modifier = Modifier.size(28.dp),
                            color = Color(0xFFFFC72C)
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Text(
                        text = "InterCommerce",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A1A1A)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Hero Card Box Icon
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .clip(RoundedCornerShape(28.dp))
                        .background(Color(0xFF1A1A1A)),
                    contentAlignment = Alignment.Center
                ) {
                    IsometricBoxWithCheckIcon(
                        modifier = Modifier.size(52.dp),
                        color = Color(0xFFFFC72C)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Hero Titles
                Text(
                    text = "Sin señal.",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF1A1A1A),
                    lineHeight = 42.sp
                )
                Text(
                    text = "Sin perder el ritmo.",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF1A1A1A),
                    lineHeight = 42.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Puedes seguir explorando los productos que guardamos para ti.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF1A1A1A),
                    lineHeight = 24.sp
                )
            }

            // Bottom Section (Offline Info Card + Button + Footer)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ) {
                // Cream Card for Offline Status
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF2C6)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        WifiOffIcon(
                            modifier = Modifier.size(28.dp),
                            color = Color(0xFF1A1A1A)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = "Continuamos con tu catálogo guardado",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1A1A1A)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Última actualización: $lastUpdatedText",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF1A1A1A).copy(alpha = 0.8f)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // White Action Button
                Surface(
                    onClick = onExploreOfflineCatalog,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = CircleShape,
                    color = Color.White,
                    shadowElevation = 0.dp
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "Explorar catálogo guardado",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Footer Notice
                Text(
                    text = "Revisaremos precios y disponibilidad cuando vuelva la conexión.",
                    fontSize = 13.sp,
                    color = Color(0xFF1A1A1A),
                    lineHeight = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Bottom Navigation Handle
                Box(
                    modifier = Modifier
                        .width(134.dp)
                        .height(4.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF1A1A1A))
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
private fun IsometricBoxWithCheckIcon(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFFFC72C)
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val strokeWidth = 1.8.dp.toPx()

        val centerX = w / 2f
        val centerY = h / 2f

        val topX = centerX
        val topY = centerY - h * 0.36f

        val leftX = centerX - w * 0.34f
        val leftY = centerY - h * 0.16f

        val rightX = centerX + w * 0.34f
        val rightY = centerY - h * 0.16f

        val midX = centerX
        val midY = centerY + h * 0.04f

        val botX = centerX
        val botY = centerY + h * 0.38f

        val botLeftX = leftX
        val botLeftY = leftY + (botY - midY)

        val botRightX = rightX
        val botRightY = rightY + (botY - midY)

        // Outer polygon boundary
        val outerPath = Path().apply {
            moveTo(topX, topY)
            lineTo(rightX, rightY)
            lineTo(botRightX, botRightY)
            lineTo(botX, botY)
            lineTo(botLeftX, botLeftY)
            lineTo(leftX, leftY)
            close()
        }

        // Inner isometric lines
        val innerPath = Path().apply {
            moveTo(midX, midY)
            lineTo(topX, topY)

            moveTo(midX, midY)
            lineTo(botX, botY)

            moveTo(midX, midY)
            lineTo(leftX, leftY)

            moveTo(midX, midY)
            lineTo(rightX, rightY)
        }

        drawPath(
            path = outerPath,
            color = color,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )

        drawPath(
            path = innerPath,
            color = color,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )

        // Checkmark badge
        val checkPath = Path().apply {
            moveTo(w * 0.52f, h * 0.70f)
            lineTo(w * 0.65f, h * 0.82f)
            lineTo(w * 0.88f, h * 0.58f)
        }

        drawPath(
            path = checkPath,
            color = color,
            style = Stroke(width = strokeWidth * 1.3f, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )
    }
}

@Composable
private fun WifiOffIcon(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF1A1A1A)
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val strokeWidth = 1.8.dp.toPx()

        // Concentric Wifi Arcs
        val center = Offset(w * 0.5f, h * 0.75f)

        drawArc(
            color = color,
            startAngle = 210f,
            sweepAngle = 120f,
            useCenter = false,
            topLeft = Offset(center.x - w * 0.40f, center.y - h * 0.58f),
            size = Size(w * 0.80f, h * 0.80f),
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
        )

        drawArc(
            color = color,
            startAngle = 220f,
            sweepAngle = 100f,
            useCenter = false,
            topLeft = Offset(center.x - w * 0.25f, center.y - h * 0.38f),
            size = Size(w * 0.50f, h * 0.50f),
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
        )

        // Center dot
        drawCircle(
            color = color,
            radius = strokeWidth * 1.1f,
            center = center
        )

        // Slash line across wifi
        drawLine(
            color = color,
            start = Offset(w * 0.10f, h * 0.10f),
            end = Offset(w * 0.90f, h * 0.90f),
            strokeWidth = strokeWidth * 1.2f,
            cap = StrokeCap.Round
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OfflineSplashScreenPreview() {
    OfflineSplashScreen()
}
