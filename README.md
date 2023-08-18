# News App

## Introduction
A clean MVVM (Model-View-ViewModel) structured kotlin android app for fetching news for the user and a few additional features to make the app more useful.<br>
Tech Stack used while developing the app:<br>
1. Kotlin
2. Clean MVVM Architecture
3. ROOM Database
4. Retrofit<br>
API used for fetching news:<br>
https://newsapi.org/

## App WorkFlow
The app follows a simple yet well-structured workflow.<br>
The app first loads up the `BreakingNews` Fragment.<br>
![Breaking_News]() <br>
Then the user can click any article to load up the `Article` Fragment.<br>
![Article]()<br>
The user can choose to save the current news article in the ROOM database for offline access by clicking on the save button.<br>
![Article_Saved]()<br>
The user can view all the saved news articles in the `SavedNews` Fragment.<br>
![Saved_News]()<br>
Further the user can delete any saved news articles by swiping left or right on the article itself.<br>
![Article_Deleted]()<br>
Lastly, the user can enter a custom search keyword in the `SearchNews` Fragment to search for news of their interest.<br>
![Search_News]()<br>
