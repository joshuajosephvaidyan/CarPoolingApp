package com.example.carpoolingapp

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.carpoolingapp.ui.theme.CarPoolingAppTheme
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions
import com.google.android.libraries.maps.model.PolylineOptions
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ContentsShareRidePage() {
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {
        val (vehicle, setvehicle) = remember { mutableStateOf("") }
        customTextFieldSh(content = "Choose Vehicle", value = vehicle, onValueChanged = setvehicle)
        val (from,setfrom) = remember{ mutableStateOf("")}
        customTextFieldSh(content = "From", value = from, onValueChanged = setfrom)
        val (to,setto)= remember { mutableStateOf("")}
        customTextFieldSh(content = "To", value = to, onValueChanged = setto)
        val (time,settime)= remember { mutableStateOf("")}
        customTextFieldSh(content = "Time", value = time, onValueChanged = settime)
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(ratio = 1f)
            .clip(shape = RoundedCornerShape(10.dp))){
            GoogleMap()
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(start=5.dp,end=5.dp).fillMaxWidth()){
            Text(text="11 kms",fontSize = 30.sp,color = MaterialTheme.colors.primary)
            Text(text="48Rs",fontSize = 30.sp,color = MaterialTheme.colors.primary)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(20.dp))
                .background(color = Color.DarkGray)
                .clip(shape = RoundedCornerShape(50.dp))
                .padding(top = 5.dp, bottom = 5.dp, start = 20.dp, end = 20.dp)
                .clickable {}, contentAlignment = Alignment.Center
        ) {
            Text(text = "Share", fontSize = 25.sp, color = Color.White,modifier = Modifier.clickable { navController.navigate(Screens.SSsharedsuccess.route) })
        }

    }
}

@Composable
fun customTextFieldSh(content: String,
                     V: VisualTransformation = VisualTransformation.None,
                     value: String,
                     onValueChanged: (String )->Unit
){
    Column(Modifier.padding(2.dp)) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            placeholder ={ Text(text = content,fontSize = 20.sp,color = MaterialTheme.colors.secondary) },
            shape = RoundedCornerShape(50.dp),
            visualTransformation = V,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun GoogleMap() {
    val mapView = rememberMapViewWithLifeCycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AndroidView(
            {mapView}
        ) { mapView ->
            CoroutineScope(Dispatchers.Main).launch {
                val map = mapView.awaitMap()
                map.uiSettings.isZoomControlsEnabled = true
                val pickUp = LatLng(28.7041, 77.1025) //Delhi
                val destination = LatLng(12.9716, 77.5946) //Bangalore
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(destination, 6f))
                val markerOptions =  MarkerOptions()
                    .title("Delhi")
                    .position(pickUp)
                map.addMarker(markerOptions)
                val markerOptionsDestination = MarkerOptions()
                    .title("Bangalore")
                    .position(destination)
                map.addMarker(markerOptionsDestination)

                map.addPolyline(
                    PolylineOptions().add(
                        pickUp,
                        LatLng(22.2587, 71.1924), //Root of Gujarat
                        LatLng(19.7515, 75.7139), //Root of Maharashtra
                        destination
                    )
                ).color = R.color.purple_500 //Polyline color
            }
        }
    }
}

@Composable
fun rememberMapViewWithLifeCycle(): MapView {
    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
            id = com.google.maps.android.ktx.R.id.map_frame
        }
    }
    val lifeCycleObserver = rememberMapLifecycleObserver(mapView)
    val lifeCycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifeCycle) {
        lifeCycle.addObserver(lifeCycleObserver)
        onDispose {
            lifeCycle.removeObserver(lifeCycleObserver)
        }
    }

    return mapView
}

@Composable
fun rememberMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
    remember(mapView) {
        LifecycleEventObserver { _, event ->
            when(event) {
                Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                else -> throw IllegalStateException()
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun ShareRidePreview() {
    CarPoolingAppTheme {
        ContentsShareRidePage()
    }
}