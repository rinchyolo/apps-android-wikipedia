package org.wikipedia.lesson06.homework

import androidx.appcompat.widget.AppCompatImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object Theme : KScreen<Theme>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val textSettingsCategory = KTextView {
        withId(R.id.textSettingsCategory)
    }

    val textSize = KTextView {
        withId(R.id.text_size_percent)
    }

    val buttonDecrease = KButton {
        withId(R.id.buttonDecreaseTextSize)
    }

    val buttonIncrease = KButton {
        withId(R.id.buttonIncreaseTextSize)
    }

    val textSizeSeekBar = KView {
        withId(R.id.text_size_seek_bar)
    }

    val buttonFontFamilySansSerif = KView {
        withId(R.id.button_font_family_sans_serif)
    }

    val buttonFontFamilySerif = KView {
        withId(R.id.button_font_family_serif)
    }

    val imageFocusMode = KImageView {
        withParent { withId(R.id.readingFocusModeContainer) }
        isInstanceOf(AppCompatImageView::class.java)
    }

    val checkBoxFocusMode = KSwitch {
        withId(R.id.theme_chooser_reading_focus_mode_switch)
    }

    val textDescriptionFocusMode = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }

    val textTheme = KTextView {
        withText(R.string.color_theme_select)
    }

    val buttonThemeLight = KButton {
        withId(R.id.button_theme_light)
    }

    val buttonThemeSepia = KButton {
        withId(R.id.button_theme_sepia)
    }

    val buttonThemeDark = KButton {
        withId(R.id.button_theme_dark)
    }

    val buttonThemeBlack = KButton {
        withId(R.id.button_theme_black)
    }

    val switchMatchSystemTheme = KSwitch {
        withId(R.id.theme_chooser_match_system_theme_switch)
    }

    val switchImageDimming = KSwitch {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }
}