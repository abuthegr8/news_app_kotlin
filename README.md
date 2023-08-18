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
![News_API](https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/News_API.png)

## App WorkFlow
The app follows a simple yet well-structured workflow:<br><br>
The app first loads up the `BreakingNews` Fragment.<br><br>
![Breaking_News](https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Breaking_News.png) <br><br>
Then the user can click any article to load up the `Article` Fragment.<br><br>
![Article](https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Article.png)<br><br>
The user can choose to save the current news article in the ROOM database for offline access by clicking on the save button.<br><br>
![Article_Saved](https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Article_Saved.png)<br><br>
The user can view all the saved news articles in the `SavedNews` Fragment.<br><br>
![Saved_News](https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Saved_News.png)<br><br>
Further the user can delete any saved news articles by swiping left or right on the article itself.<br><br>
![Article_Deleted](https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Article_Deleted.png)<br><br>
Lastly, the user can enter a custom search keyword in the `SearchNews` Fragment to search for news of their interest.<br><br>
![Search_News](https://raw.githubusercontent.com/abuthegr8/news_app_kotlin/master/raw/main/images/Search_News.png)<br><br>
