package dev.rrohaill.shimmerloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.rrohaill.shimmerloading.ui.theme.ShimmerLoadingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShimmerLoadingTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier, color = MaterialTheme.colorScheme.background) {
                    Greeting("Android", isLoading = true)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, isLoading: Boolean) {
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        name.repeat(10).map {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                ) {
                    Icon(
                        modifier = Modifier.placeholder(isLoading = isLoading),
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = ""
                    )
                    Column(
                        modifier = Modifier.padding(start = 12.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = name, modifier = Modifier
                                .placeholder(isLoading = isLoading)
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(
                            text = name, modifier = Modifier
                                .placeholder(isLoading = isLoading)
                                .fillMaxWidth()
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ShimmerLoadingTheme {
        Greeting("Android", true)
    }
}