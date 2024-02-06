package com.example.superhero

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.repository.HeroesRepository
import com.example.superhero.ui.theme.SuperheroTheme

@Composable
fun SuperheroCard(
    modifier: Modifier = Modifier,
    hero: Hero
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.card_elevation))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .height(dimensionResource(id = R.dimen.card_content_size))
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))

            Box(modifier = Modifier.size(dimensionResource(id = R.dimen.card_content_size))) {
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = null,
                    Modifier.clip(shape = MaterialTheme.shapes.small)
                )
            }
        }
    }
}


@Preview
@Composable
fun SuperheroCardPreview() {
    SuperheroTheme {
        SuperheroCard(
            hero = HeroesRepository.heroes.get(0)
        )
    }
}