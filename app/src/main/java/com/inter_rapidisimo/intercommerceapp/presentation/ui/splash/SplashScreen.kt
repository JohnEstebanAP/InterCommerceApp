package com.inter_rapidisimo.intercommerceapp.presentation.ui.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import com.inter_rapidisimo.intercommerceapp.presentation.ui.widgets.IsometricBoxIcon
import com.inter_rapidisimo.intercommerceapp.presentation.ui.widgets.LoadingArcIcon
@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit = {}
) {
    var step1Completed by remember { mutableStateOf(false) }
    var step2Completed by remember { mutableStateOf(false) }
    var step3Completed by remember { mutableStateOf(false) }
    var progress by remember { mutableFloatStateOf(0.1f) }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 600),
        label = "SplashProgress"
    )

    LaunchedEffect(Unit) {
        delay(400)
        step1Completed = true
        progress = 0.4f
        delay(500)
        step2Completed = true
        progress = 0.75f
        delay(600)
        step3Completed = true
        progress = 1.0f
        delay(500)
        onSplashFinished()
    }

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
            // Header Top
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 28.dp)
            ) {
                // Plain Tagline Text
                Text(
                    text = "COMPRAS QUE SIGUEN TU RITMO",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF1A1A1A),
                    letterSpacing = 1.4.sp
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Logo + App Name
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(18.dp))
                            .background(Color(0xFF1A1A1A)),
                        contentAlignment = Alignment.Center
                    ) {
                        IsometricBoxIcon(
                            modifier = Modifier.size(30.dp),
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

                Spacer(modifier = Modifier.height(36.dp))

                // Hero Titles
                Text(
                    text = "Lo que quieres.",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF1A1A1A),
                    lineHeight = 42.sp
                )
                Text(
                    text = "Más cerca.",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF1A1A1A),
                    lineHeight = 42.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Tu próxima compra empieza aquí. Nosotros nos encargamos del camino.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF1A1A1A),
                    lineHeight = 24.sp
                )
            }

            // Bottom Card & Disclaimers
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ) {
                // White Loading Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(18.dp)
                    ) {
                        // Step 1
                        StepRow(
                            title = "Verificando conexión",
                            isDone = step1Completed,
                            isActive = !step1Completed
                        )

                        // Step 2
                        StepRow(
                            title = "Cargando caché local",
                            isDone = step2Completed,
                            isActive = step1Completed && !step2Completed
                        )

                        // Step 3
                        StepRow(
                            title = "Preparando catálogo",
                            isDone = step3Completed,
                            isActive = step2Completed && !step3Completed
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        // Progress bar
                        LinearProgressIndicator(
                            progress = { animatedProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(CircleShape),
                            color = Color(0xFF1A1A1A),
                            trackColor = Color(0xFFF0F0F0),
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Footer Disclaimers
                Text(
                    text = "Concepto independiente para prueba técnica",
                    fontSize = 12.sp,
                    color = Color(0xFF1A1A1A).copy(alpha = 0.85f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Bottom Home Bar Indicator
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
private fun StepRow(
    title: String,
    isDone: Boolean,
    isActive: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (isDone) {
            CheckmarkOutlineIcon(
                modifier = Modifier.size(22.dp),
                color = Color(0xFF146C36)
            )
        } else if (isActive) {
            LoadingArcIcon(
                modifier = Modifier.size(22.dp),
                color = Color(0xFF1A1A1A)
            )
        } else {
            // Pending step circle
            Box(
                modifier = Modifier
                    .size(22.dp)
                    .clip(CircleShape)
                    .background(Color.Transparent)
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal,
            color = Color(0xFF1A1A1A)
        )
    }
}

@Composable
private fun CheckmarkOutlineIcon(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF146C36)
) {
    Canvas(modifier = modifier) {
        val strokeWidth = 1.8.dp.toPx()
        val radius = size.minDimension / 2f - strokeWidth
        val center = Offset(size.width / 2f, size.height / 2f)

        // Circle outline
        drawCircle(
            color = color,
            radius = radius,
            center = center,
            style = Stroke(width = strokeWidth)
        )

        // Checkmark path
        val path = Path().apply {
            moveTo(size.width * 0.30f, size.height * 0.50f)
            lineTo(size.width * 0.44f, size.height * 0.64f)
            lineTo(size.width * 0.70f, size.height * 0.36f)
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )
    }
}





@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
