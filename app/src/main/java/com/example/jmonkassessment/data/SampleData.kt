package com.example.jmonkassessment.data

data class Profile(
    val name: String,
    val email: String,
    val location: String,
    val summary: String
)

val myProfile = Profile(
    name = "Suryansh Shukla",
    email = "suryanshukla08gmail.com",
    location = "Bhopal, MP",
    summary = "Passionate and detail-oriented Android Developer with strong skills in Kotlin, Jetpack Compose, and modern Android architecture. Experienced in building intuitive, responsive, and visually engaging mobile applications. Eager to contribute to innovative projects and continuously grow in mobile development by solving real-world problems through clean and efficient code."
)

data class Education(
    val degree: String,
    val institution: String,
    val year: String,
    val grade: String
)

val educationList = listOf(
    Education(
        degree = "Bachelor of Technology in Computer Science",
        institution = "ABC Institute of Technology",
        year = "2021 - 2025",
        grade = "CGPA: 8.5/10"
    ),
    Education(
        degree = "Higher Secondary (12th)",
        institution = "XYZ Senior Secondary School",
        year = "2019 - 2021",
        grade = "Percentage: 91%"
    )
)

data class Skill(val name: String)

val skills = listOf(
    Skill("Kotlin"),
    Skill("Jetpack Compose"),
    Skill("Firebase"),
    Skill("Room DB"),
    Skill("RxKotlin"),
    Skill("Git & GitHub"),
    Skill("MVVM Architecture")
)

val AiPoweredTechStack = listOf(
    Skill("Speech-to-text"),
    Skill("Auto Language Detection"),
    Skill("Language translation"),
    Skill("Text-to-Speech"),
    Skill("Clipboard functionality"),
    Skill("seamless user experience"),
)

val AiMcqTechStack = listOf(
    Skill("Sign-In/Sign-Up Screen"),
    Skill("Text Input and Camera Input for Prompt Generation"),
    Skill("AI-based MCQ Generation"),
    Skill("Quiz Display with Scoring"),
    Skill("Difficulty Selection"),
    Skill("Real-time Firestore Saving")
)


val AiLandmarkTechStack = listOf(
    Skill("Sign-In/Sign-Up Screen"),
    Skill("Text Input and Camera Input for Prompt Generation"),
    Skill("AI-based MCQ Generation"),
    Skill("Quiz Display with Scoring"),
    Skill("Difficulty Selection"),
    Skill("Real-time Firestore Saving"),
    Skill("Capture Camera Frames"),
    Skill("Process Images in Real Time"),
    Skill("Classify Landmarks using AI"),
    Skill("Display Recognition Results Instantly")
)


data class Project(
    val title: String,
    val role: String, // e.g., "Solo Developer", "Backend Lead"
    val description: String,
    val techStack: List<Skill>,
)

val aiMcq = listOf(
    Project(
        title = "AI Powered MCQs",
        role = "Android Developer",
        description = "Description: Designed and developed an AI-powered app that generates multiple-choice quizzes from user input or\n" +
                "camera-captured content. Integrated difficulty level selection and dynamic quiz UI with real-time scoring.",
        techStack = AiMcqTechStack
    ),
    Project(
        title = "AI powered Translator",
        role = "Android Developer",
        description = "Description: Developed an AI-powered language translator app that offers real-time speech-to-text conversion, auto\n" +
                "language detection, and text translation.Enabling users to speak in one language and get translated text in another.\n" +
                "Precise translations using ML Kit’s NLP, improving accuracy in translation and speech recognition.",
        techStack = AiPoweredTechStack
    ),
    Project(
        title = "AI Landmark Recognizer",
        role = "Android Developer",
        description = "Description: An AI-powered landmark recognition app can identify landmarks in real-time using a pre-trained AI\n" +
                "model, displaying results instantly.",
        techStack = AiLandmarkTechStack
    )
)