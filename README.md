# JavaFlix - Movie Recommendation System
### A recommendation system, complete with UI built using Java in IntelliJ IDEA
---

The recommendation engine displays a list of 10 movies to the user and allows them to rate them, and then based on their ratings it displays the recommendations.

The user can also filter the results based on Year of Release, Running Time, Directors, and Genre.

The UI adapts to the OS and might look different on your system, the screenshots below were taken on Ubuntu 18.04, with [Canta theme](https://github.com/vinceliuice/Canta-theme)

###### *This project was built for my 4th Semester Software Engineering Class at MIT, Manipal.*

### Steps to use:
>**import** the project into IntelliJ and select 'Use existing sources' when prompted.

>Open the **TempLoader.java** file and run it

#### Homepage
<img src="https://i.imgur.com/rG2kGKk.png?1" alt="Homepage" width=400>


#### Recommendations
<img src="https://i.imgur.com/biHHfgK.png?1" alt="Recommendations" width=500>

---

### Class Diagram
Refer this diagram to understand how the different classes interact with each other, and how the interfaces are implemented. 
The diagram was generated automoatically inside InterlliJ.

*(Click on the image to enlarge it)*

<img src="https://i.imgur.com/En7v2v3.jpg" alt="Recommendations" width=500>

---

The recommendation engine uses an open source data set from the [Movie Tweetings project](https://github.com/sidooms/MovieTweetings) which is present in the 'data' Folder.

The project also uses Apache Commons and edu.duke open source Java Libraries, which are also included in the source.

---

### Known Issues
- The recommendation results sometimes also include movies that the user rated to get the recommendation in the first place 
- Add scrolling to the recommendation window

(easy fixes - contributions welcome)
