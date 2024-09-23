package br.com.emerson.myhandlertheme.ui.theme

import android.app.Activity
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

private val lightTheme: ColorScheme = lightColorScheme(
    primary = light["PURPLE"]!!,
    onPrimary = light["WHITE"]!!,
    secondary = light["WHITE"]!!
)

private val darkTheme: ColorScheme = darkColorScheme(
    primary = dark["PURPLE"]!!,
    onPrimary = dark["WHITE"]!!,
    secondary = dark["WHITE"]!!
)

private val deepDarkTheme: ColorScheme = darkColorScheme(
    primary = deepDark["BLUE"]!!,
    onPrimary = deepDark["WHITE"]!!,
    secondary = deepDark["WHITE"]!!
)

@Composable
fun AppTheme(
    picked: String,
    content: @Composable () -> Unit
) {
    val colorScheme =  hashMapOf(
        "dark" to darkTheme,
        "light" to lightTheme,
        "deepDark" to deepDarkTheme
    )

    MaterialTheme(
        colorScheme = colorScheme[picked]!!,
        typography = Typography,
        content = content
    )

    val window = (LocalContext.current as? Activity)?.window
    window?.statusBarColor = colorScheme[picked]?.primary!!.toArgb()
}