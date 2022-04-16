package com.endeline.mymovie.ui.mymovie.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.endeline.mymovie.ui.mymovie.R

sealed class Screens(
    val route: String,
    var screenTitle: String? = null,
    var icon: ImageResource? = null,
    var params: Any? = null
) {
    object HomeScreen : Screens("HomeScreen", "Home", ImageResource.VectorResource(Icons.Filled.Home))
    object MovieScreen : Screens("MovieScreen", "Movies", ImageResource.DrawableResource(R.drawable.ic_baseline_movie_filter_24))
    object TvScreen : Screens("TvScreen", "Tv", ImageResource.DrawableResource(R.drawable.ic_baseline_live_tv_24))
    object PeopleScreen : Screens("PeopleScreen", "People", ImageResource.VectorResource(Icons.Filled.Person))

    //    Icons.Filled.Face //Todo in account
    object TestScreen : Screens("TestScreen")
}

sealed class ImageResource(var imageVector: ImageVector? = null, var resource: Int? = null) {

    class VectorResource(icon: ImageVector) : ImageResource(imageVector = icon)
    class DrawableResource(resId: Int) : ImageResource(resource = resId)

    @Composable
    fun getIcon(): ImageVector? {
        imageVector?.let { image ->
            return image
        }

        resource?.let { resId ->
            return ImageVector.vectorResource(resId)
        }

        return null
    }
}