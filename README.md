<!DOCTYPE html>
<html>
<body>
  <H3>Flow Program</H3><br>
  <img width="458" alt="Screenshot 2023-12-28 103017" src="https://github.com/dewaasmara589/Dependency-Room-for-SQLite-in-Android-Java/assets/88615190/706b965c-47ce-47b6-afcd-fb51726b614e">
 <br><br>
  <H3>Summary</H3>
   The components of the app are:
   <p>- MainActivity: displays words in a list using a RecyclerView and the WordListAdapter. In MainActivity, there is an Observer that observes the words LiveData from the database and is notified when they change.
    - NewWordActivity: adds a new word to the list. <br>
    - WordViewModel: provides methods for accessing the data layer, and it returns LiveData so that MainActivity can set up the observer relationship. <br>
    - LiveData<List<Word>>: Makes possible the automatic updates in the UI components. In the MainActivity, there is an Observer that observes the words LiveData from the database and is notified when they change.<br>
    - Repository: manages one or more data sources. The Repository exposes methods for the ViewModel to interact with the underlying data provider. In this app, that backend is a Room database.<br>
    - Room: is a wrapper around and implements a SQLite database. Room does a lot of work for you that you used to have to do yourself.<br>
    - DAO: maps method calls to database queries, so that when the Repository calls a method such as getAlphabetizedWords(), Room can execute SELECT * FROM word_table ORDER BY word ASC.<br>
    - Word: is the entity class that contains a single word.<br>
    - Views and Activities (and Fragments) only interact with the data through the ViewModel. As such, it doesn't matter where the data comes from.<br>
  </p>
</body>
</html>
