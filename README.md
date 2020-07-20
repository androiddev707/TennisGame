# TennisMnia

### Screenshots
<image src="screenshots/screen_1.png" width="250"> <image src="screenshots/screen_2.png" width="250"> 

<image src="screenshots/screen_3.png" width="250">

##General Information
- A simple couting machine for tennis game. 

### Features

- Quick Play
  - Play a simple game of tennis with an easy to use UI.
- Exit Game
  - Allows Users to exit game as they desire
- Restart Game
  - restart a game at any point  


### Architecture
MVVM  Architecture: Having the buld of code in activities and fragments is problematic for many reason. No separation of concern, Difficult to test,
large classes become difficult to maintain. Therefore I chose one of the popular method MVVM (Model ViewModel Model) android architecture to solve this 
issue. To handle the view updates , I utilized live data class in the Android Component library from Google.

One of the main benefits of using the architecture component in general is that they are life cycle aware, and allow you to avoid the need to add code
to handle configuration changes, such as device roation.

Kotin as a programming language:Since Google annouced that Kotlin was offically supported for Android, Kotlin has taken over the scene doubling the popularity
each year and was also pronounce the most popular lanauge for 2020. I have decided to use Kotlin but also for technical reason as it is more concise and said
to have approximately 40% lesser code to do similar job and aim to elimate so called The billion Dollar mistake : the null references.

Test Driven Development Approach was used as per requirement : RED, GREEN, REFACTOR. 


### To DO
Include more test cases to imporve the rubustness of the game.

Add Animation UI visibility to give the user better understanding of the App. 

Implement Room to save data therefore you can check all the past players history.