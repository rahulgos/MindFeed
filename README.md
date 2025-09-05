# MindFeed

MindFeed is a **Jetpack Compose Android app** that displays categorized tweets fetched from a JSON API. Users can browse categories and see tweets in a clean, responsive UI. The app uses **MVVM architecture**, **Hilt** for dependency injection, **Retrofit** for API calls, and **StateFlow** for reactive UI updates.

---

## Features

- Fetch and display categories dynamically from API  
- Show tweets for each category  
- Clean UI built with **Jetpack Compose**  
- Uses **MVVM architecture** with **ViewModel** and **Repository**  
- **Hilt** for dependency injection  
- **Retrofit** for network requests  
- **StateFlow** for reactive UI  

---

## Screenshots

![Category Screen](https://github.com/user-attachments/assets/a8f476a6-0126-4f43-992e-c1ae5fc76c68)  
![Tweet Screen](https://github.com/user-attachments/assets/ff5eb0a1-3a08-4160-8f70-899fc7143955)  

---

## Tech Stack

- Kotlin  
- Jetpack Compose  
- Hilt (Dependency Injection)  
- Retrofit (Networking)  
- StateFlow (Reactive UI)  
- Android Studio
- Postman

---

## API & Tools

- **JSONBin.io** – Hosted JSON API for tweets and categories  
- **Postman** – Tested API requests and responses before integrating in the app  
- **Retrofit** – Consumed API data in the Android app

---

## Project Structure

com.rahulgoswami.mindfeed
├─ api         → Retrofit API interface
├─ di          → Hilt modules
├─ models      → Data classes
├─ repository  → Repository for API calls
├─ viewmodels  → MVVM ViewModels
├─ views       → Jetpack Compose UI screens
├─ MainActivity.kt
└─ MindFeed.kt → Application class

---

## How to Run 

- Clone the repository: 
- git clone https://github.com/<username>/MindFeed.git 
- Open the project in Android Studio. 
- Sync Gradle and build the project. 
- Run on an emulator or physical device.

---

## License 

This project is for learning and demonstration purposes.
