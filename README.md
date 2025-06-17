# Android Assessment Application

## Project Overview
This Android application demonstrates proficiency in API integration, user interface design, and Android development best practices. The app features three main screens: Login, Dashboard, and Details, interacting with the 'vu-nit3213-api' for authentication and data retrieval.

## Features
- **Login Screen**
    - User authentication using first name and student ID
    - Secure API integration
    - Error handling and user feedback

- **Dashboard Screen**
    - Displays list of entities using RecyclerView
    - Modern Material Design UI
    - Efficient data loading and display

- **Details Screen**
    - Comprehensive entity information display
    - Clean and intuitive layout
    - Navigation back to dashboard

## Technical Implementation

### Architecture
- MVVM (Model-View-ViewModel) Architecture
- Clean Architecture principles
- Repository pattern for data management

### Technologies Used
- Kotlin
- Android Jetpack Components
- Hilt for Dependency Injection
- Retrofit for API Integration
- Navigation Component
- ViewBinding
- Coroutines for asynchronous operations
- LiveData for reactive programming

### API Integration
Base URL: https://nit3213api.onrender.com/

#### Endpoints
1. Login: `/footscray/auth` or `/sydney/auth` or `/ort/auth`
    - Method: POST
    - Body: `{ "username": "YourFirstName", "password": "sYourStudentID" }`

2. Dashboard: `/dashboard/{keypass}`
    - Method: GET
    - Returns: List of entities with details

## Project Structure
\`\`\`
app/
├── data/
│   ├── api/
│   ├── model/
│   └── repository/
├── di/
├── ui/
│   ├── dashboard/
│   ├── details/
│   ├── login/
│   └── viewmodel/
└── utils/
\`\`\`

## Setup and Installation
1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Run the application on an emulator or physical device

## Testing
- Unit tests for ViewModels
- Repository layer tests
- API service tests

## Dependencies
- AndroidX Core KTX
- Material Design Components
- Hilt for Dependency Injection
- Retrofit for API calls
- Coroutines for async operations
- Navigation Component
- ViewBinding

## Author
Greesma Adhikari

## License
This project is created for educational purposes as part of the Android Development assessment.