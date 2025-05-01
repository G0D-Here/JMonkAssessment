package com.example.jmonkassessment.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jmonkassessment.data.Project
import com.example.jmonkassessment.data.Skill
import com.example.jmonkassessment.data.aiMcq
import com.example.jmonkassessment.data.educationList
import com.example.jmonkassessment.data.myProfile

@Composable
fun BasicDetailsScreen() {
    Column(Modifier.fillMaxWidth()) {
        Text(
            myProfile.name,
            Modifier.align(Alignment.CenterHorizontally),
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )
        Text(
            "Android Developer",
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = MaterialTheme.typography.titleMedium.fontSize
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(myProfile.email)
            Text(myProfile.location)
        }
    }
}

@Composable
fun SummaryScreen(modifier: Modifier) {
    var show by remember { mutableStateOf(true) }

    Column(
        modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 4.dp)
    ) {
        CardText("Summary") { show = !show }
        AnimatedVisibility(show) {
            Text(
                myProfile.summary,
                fontFamily = FontFamily.Serif,
                fontSize = MaterialTheme.typography.titleMedium.fontSize
            )
        }
    }
}

@Composable
fun EducationScreen(modifier: Modifier) {
    var show by remember { mutableStateOf(true) }

    Column(
        modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 4.dp)
    ) {
        CardText("Education") { show = !show }
        AnimatedVisibility(show) {
            Card() {
                Column(Modifier.padding(10.dp)) {
                    Text(
                        educationList[0].institution,
                        fontFamily = FontFamily.Serif,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(educationList[0].year, fontFamily = FontFamily.Serif)
                    Text(educationList[0].degree, fontFamily = FontFamily.Serif)
                    Text(educationList[0].grade, fontFamily = FontFamily.Serif)

                    HorizontalDivider(Modifier.padding(10.dp))

                    Text(
                        educationList[1].institution, fontFamily = FontFamily.Serif,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(educationList[1].year, fontFamily = FontFamily.Serif)
                    Text(educationList[1].degree, fontFamily = FontFamily.Serif)
                    Text(educationList[1].grade, fontFamily = FontFamily.Serif)
                }
            }
        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillsSection(skills: List<Skill>) {
    var show by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 4.dp)) {
        CardText("Skills") { show = !show }


        Spacer(modifier = Modifier.height(8.dp))

        AnimatedVisibility(show) {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp), // Space between rows
                horizontalArrangement = Arrangement.spacedBy(8.dp)  // Space between items
            ) {
                skills.forEach { skill ->
                    SkillChip(skill.name)
                }
            }
        }
    }
}

@Composable
fun SkillChip(text: String) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
        tonalElevation = 2.dp
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun ProjectSection() {
    Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 4.dp)) {
        var show by remember { mutableStateOf(true) }
        CardText("Projects") { show = !show }
        AnimatedVisibility(show) {
            Card() {
                Column(Modifier.padding(10.dp)) {
                    SkillCard(aiMcq[0])
                    HorizontalDivider(Modifier.padding(10.dp))
                    SkillCard(aiMcq[1])
                    HorizontalDivider(Modifier.padding(10.dp))
                    SkillCard(aiMcq[2])
                }
            }
        }
    }
}

@Composable
fun SkillCard(project: Project) {
    Text(
        project.title, fontFamily = FontFamily.Serif,
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )
    Text(
        project.role,
        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.SemiBold
    )
    Text(
        project.description,
        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
        fontFamily = FontFamily.Serif
    )
    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        item { Text("Skills used: ") }
        items(project.techStack) {

            ElevatedCard(
                Modifier
                    .padding(2.dp)
            ) {
                Box(
                    Modifier.padding(2.dp)
                ) { Text(it.name) }
            }
        }
    }
}

@Composable
fun CardText(text: String, onClick: () -> Unit) {
    ElevatedCard(
        Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() },
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.elevatedCardColors(Color(0xFF33A91E))
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White

        )
    }
}
