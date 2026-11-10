# GPA Calculator 🎓

A simple Android application project for calculating the average of five entered course-grade values.

## Features represented in the source

- Input fields for five course grades
- Validation that all five fields are populated
- Calculates the arithmetic average of the entered values
- Displays the calculated result in the app

## Tech Stack

- Java
- Android SDK (compile / target SDK 34; minimum SDK 24)
- AndroidX AppCompat
- Material Components
- ConstraintLayout
- JUnit and Espresso test dependencies

## Calculation

The current implementation adds the five entered values and divides the total by five:

`GPA = (Grade 1 + Grade 2 + Grade 3 + Grade 4 + Grade 5) / 5`

This is an arithmetic average; it does not currently demonstrate credit-hour weighting or a configurable letter-grade conversion scale.

## Run Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/SRIKALYANBHAVANTHI/GPACalculator.git
   ```
2. Open the project in Android Studio.
3. Sync Gradle.
4. Run the **app** configuration on an Android emulator or device.

Build a debug APK:

```bash
./gradlew assembleDebug
```

Windows:

```bat
gradlew.bat assembleDebug
```

---

Created by [Srikalyan Bhavanthi](https://github.com/SRIKALYANBHAVANTHI).
