package com.redesign.mtix.ui.components.other

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.redesign.mtix.ui.theme.Dimens
import kotlinx.coroutines.delay

const val AUTO_SLIDE_DURATION = 6000L

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyCarousel(
    modifier: Modifier = Modifier,
    autoSlideDuration: Long = AUTO_SLIDE_DURATION,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    isAutoSlide:Boolean = true,
    isIndicatorVisible:Boolean = true,
    itemContent: @Composable (index: Int) -> Unit,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    if(isAutoSlide) {
        LaunchedEffect(pagerState.currentPage) {
            delay(autoSlideDuration)
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % itemsCount)
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalPager(pageCount = itemsCount, state = pagerState) { page ->
            itemContent(page)
        }
        if(isIndicatorVisible) {
            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            DotsIndicator(
                modifier = Modifier.padding(
                    horizontal = Dimens.spacing_8,
                    vertical = Dimens.spacing_6
                ),
                totalDots = itemsCount,
                selectedIndex = if (isDragged) pagerState.currentPage else pagerState.targetPage,
            )
        }
    }
}


@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                width = if (index == selectedIndex) Dimens.spacing_16 else Dimens.spacing_8
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
private fun IndicatorDot(
    modifier: Modifier = Modifier,
    width: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .width(width)
            .height(Dimens.spacing_8)
            .clip(CircleShape)
            .background(color)
    )
}