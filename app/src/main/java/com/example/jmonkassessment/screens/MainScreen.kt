package com.example.jmonkassessment.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jmonkassessment.data.skills

@Composable
fun MainScreen(modifier: Modifier) {
    LazyColumn(modifier.fillMaxSize().padding(10.dp)) {
        item { BasicDetailsScreen() }
        item { SummaryScreen(Modifier) }
        item { EducationScreen(Modifier) }
        item { SkillsSection(skills) }
        item { ProjectSection() }
    }
}