package com.richmondprojects.newapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageContent(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = "https://picsum.photos/seed/${Random.nextInt()}/300/200"),
            contentDescription = "content Image",
            modifier = Modifier
                .aspectRatio(3f / 2f)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.large)
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, style = MaterialTheme.typography.bodyMedium)

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                mainAxisSpacing = 8.dp,
                mainAxisSize = SizeMode.Wrap
            ) {
                AssistChip(
                    onClick = { },
                    colors = AssistChipDefaults.assistChipColors(MaterialTheme.colorScheme.surfaceVariant),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Fav Chip"
                        )
                    }, label = {
                        Text(text = "Mark as Favourite")
                    }
                )
                AssistChip(
                    onClick = { },
                    colors = AssistChipDefaults.assistChipColors(MaterialTheme.colorScheme.surfaceVariant),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = "Share Chip"
                        )
                    }, label = {
                        Text(text = "Share with others")
                    }
                )
            }
        }
    }
}