# News App

## Introduction
A clean MVVM (Model-View-ViewModel) structured kotlin android app for fetching news for the user and a few additional features to make the app more useful.<br>
Tech Stack used while developing the app:<br>
1. Kotlin
2. Clean MVVM Architecture
3. ROOM Database
4. Retrofit<br><br>
API used for fetching news:<br>
https://newsapi.org/<br><br>
<img src= "https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/News_API.png" alt= "News_API" width= "600" height= "300">

## App WorkFlow
The app follows a simple yet well-structured workflow:<br><br>
The app first loads up the `BreakingNews` Fragment.<br><br>
<img src= "https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Breaking_News.png" alt= "Breaking_News" width= "300" height= "600"><br><br>
Then the user can click any article to load up the `Article` Fragment.<br><br>
<img src= "https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Article.png" alt= "Article" width= "300" height= "600"><br><br>
The user can choose to save the current news article in the ROOM database for offline access by clicking on the save button.<br><br>
<img src= "https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Article_Saved.png" alt= "Article_Saved" width= "300" height= "600"><br><br>
The user can view all the saved news articles in the `SavedNews` Fragment.<br><br>
<img src= "https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Saved_News.png" alt= "Saved_News" width= "300" height= "600"><br><br>
Further the user can delete any saved news articles by swiping left or right on the article itself.<br><br>
<img src= "https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Article_Deleted.png" alt= "Article_Deleted" width= "300" height= "600"><br><br>
Lastly, the user can enter a custom search keyword in the `SearchNews` Fragment to search for news of their interest.<br><br>
<img src="https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Search_News.png" alt= "Search-News" width= "300" height= "600"><br><br>
