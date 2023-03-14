AndroidClasses<a name="TOP"></a>
===================
- - - - 
# 1. SharedPreferences #
**Shared Preferences: are key-value pair storage**
- Used to store user-specified configuration details, such as settings, and to keep the user logged in to the app.
- Used to store small amount of data which doesn’t require any specific structure.
- Check its module Repo with example In [Java](https://github.com/mossssama/AndroidSharedPreferencesModule) & [Kotlin](https://github.com/mossssama/-AndroidKtSharedPreferencesModule)
- - - - 
# 2. Notifications #
**Notifications: are critical component of modern Android development**
- Used to alert users to important events, messages, or updates within an app, even when the app is not currently in use.
- Displayed in the status bar, on the lock screen, and as pop-up alerts.
- Can be customized notifications to fit the needs of their app, including setting custom sounds, vibration patterns, and LED colors.
- Can include images, text, and actions that allow users to quickly respond to the notification without having to open the app.
- Check its module Repo with example [here](https://github.com/mossssama/AndroidNotificationModule)
- - - -
# 3. REST APIs & Retrofit #
**REST APIs: type of web service that uses HTTP requests to GET, POST, PUT & DELETE data**
**Retrofit: type-safe HTTP client for Android that makes it easy to consume RESTful web services by simplifing the process of sending and receiving data over the network by abstracting much of the complexity involved in making network requests.**
- Retrofit allows us to define interfaces that specify the REST API endpoints they want to consume.
- These interfaces can then be used to make network requests and receive responses while Retrofit takes care of the low-level details of the HTTP protocol.
- It's often used in conjunction with other libraries such as Gson (a JSON serialization/deserialization library) and OkHttp (an HTTP client library) to create a powerful and flexible networking layer for Android applications.
- Check its module Repo with example [here](https://github.com/mossssama/RetrofitModule)
- - - -
# 4. Room Database #
**Room : is a persistence library that's built on top of SQLite as it provids an abstraction layer over the database**
- It reduces the amount of boilerplate code needed to manage SQLite databases
- It provides compile-time checks to help prevent common errors.
- It's easier to use than raw SQLite as in handling database transactions, handling complex queries and providing reliable, and consistent APIs.
- Room has some extra features not available in SQLite, such as LiveData and RxJava, which make it easier to observe and update database data from UI components.
- Check its module Repo with example [here](https://github.com/mossssama/RoomModule)
- - - - 
# 5. DataBinding #
**DataBinding: library allows us to directly bind the data objects to the UI components eliminating the boilerplate code required when using FindViewById**
- DataBinding
    - Generates optimized code at compile-time causing faster app performance
    - Ensures that the app's UI & data objects are always in sync reducing errors occurring
    - Separates the UI code from the business logic making the codebase easier to understand/maintain
    - Facilitates testing the UI components of an app since the data objects can be easily mocked/injected into the UI components
- FindViewById
    - Performs runtime lookup for every view slowing down the app
    - Leads to errors if a view isn't properly assigned or if its ID is incorrect.
    - Intermingles UI code with the business logic which makes the code more difficult to read/maintain.
    - Testing UI components with FindViewById is more difficult and time-consuming.
- Check its module Repo with example [here](https://github.com/mossssama/DataBindingModule)
- - - - 
# 6. Firebase #
**Firebase : backEnd as a service which allows building scalable apps with high quality**
- Important Features
    - **Realtime DB**: JSON tree based DB that enables us to create real-time applications that update instantly across all devices.
    - **Cloud Firestore**: Document based DB that enables us to make more complex queries specially on large scaled DB
    - **Authentication**: Enable us to authenticate users with popular authentication providers such as Email, Phone, Facebook, Twitter, Google and others
- Check its module Repo with example [here](https://github.com/mossssama/FirebaseModule)
- - - -
# 7. RXJava #
**RXJava : Java-based reactive programming library helps in writing asynchronous, event-driven code in a more concise and composable way**
- Important Features
    - Reactive programming: Writing code in a reactive manner which means reacting to data changes in real-time helping in building responsive interactive UIs.
    - Asynchronous programming: Performing asynchronous tasks (Network requests/DB operations/file I/O) without blocking the main thread preventing UI freezes.
    - Composability: Offering a set of operators used to combine & transform data streams which makes it easy to create complex operations by composing simple ones.
    - Error handling: Providing a powerful error-handling mechanism that can be used to gracefully handle errors and failures in reactive code.
    - Backpressure: Supporting backpressure(Mechanism controlling data production/consumption rate) which prevents outOfMemory errors & ensures that the app runs smoothly even under heavy load.
- Check its documentation [here](https://github.com/mossssama/RXJavaModule)    
- Check its usage with Retrofit by example [here](https://github.com/mossssama/RetrofitModule)
- Check its usage with Room by example [here](https://github.com/mossssama/RoomModule)
- - - - 
# 8. AutoCompleteTextView with Footer #
**AutoCompleteTextView : UI component in Android that allows users to input text & automatically suggests matching options based on the entered text**
- Adding a footer to the AutoCompleteTextView allows displaying additional information or actions related to the suggestions shown in the dropdown list
    - It can improve UX by reducing the time & effort required to enter data & providing quick access to related actions or information.
    - It's commonly used in search features, form fields, and messaging applications, among other use cases
    - It can be customized to match the app's design and behavior, such as adjusting the suggestion dropdown's width, font size, and animation
- Check its module Repo with example [here](https://github.com/mossssama/AutoCompleteTextViewWithFooter)
- - - - 
# 9. AlertDialog #
**AlertDialog : dialog box that pops up on the screen to display information or prompt the user for a response**
- Usage
    - Displays important information such as an error message or confirmation dialog.
    - Prompts the user for i/p such as selecting an option or entering text.
    - Displays notifications or alerts to the user.
- Types
    - Standard AlertDialog: a simple dialog box with a title, message, and buttons. Check its repoe [here](https://github.com/mossssama/StandardAlertDialog)
    - List AlertDialog: displays a list of items for the user to select from.
    - Single Choice AlertDialog: presents the user with a list of options, allowing them to select only one.
    - Multi-Choice AlertDialog: similar to the single choice dialog, but allows the user to select multiple options.
    - Custom AlertDialog: provides the ability to fully customize the dialog box. Check its repo [here](https://github.com/mossssama/CustomAlertDialog)
- - - - 
# 10. SQLiteDatabase #
**SQLite : is database used to store data localy & permenantly using CRUD operations in SQL language**

[1] **Write the following inside the class you want to use SQLiteDatabase in it**

    DBHelper dbHelper=new DBHelper(getApplicationContext());
    ClassModel recordOne = new ClassModel(clmOneData,clmTwoData);
[2] **Use classModel instances as an input parameters to the SQLite DBHelper**

    ClassModel recordOne = new ClassModel(clmOneData,clmTwoData);
    dbHelper.addRecord(recordOne);
    
OR    
   
    dbHelper.addRecord(new ClassModel(clmOneData,clmTwoData));
[3] **Use any function inside DBHelper using dbHelper instance**

    dbHelper.getColumn(1);
    
and so on
- - - -
# 11. RecyclerViewAdapter #
**RecyclerView : ViewGroup contains views corresponding to our data**
**RecyclerViewAdapter : Adapter binds data from dataSet to Views that are displayed inside RecyclerView 

[1] **Add a recyclerView widget to the xml file of an activity**
    for example activity_main.xml

    <androidx.recyclerview.widget.RecyclerView
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:id="@+id/rv"
        app:layout_constraintBottom_toTopOf="@+id/button4"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
[2] **Create an xml layout to specify the how will each item in the recycler View will look like**
    for example create recyclerview_item.xml and add this to it; we assume item contains only textView

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:padding="10dp">

        <TextView
            android:id="@+id/textViewID"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="20sp"/>

    </LinearLayout>
[3] **Add the RecyclerView Adapter class to your project directory**

**At the class which it's layout contains the recyclerView widget; do number 4,5,6**
[4] **Add the following function to the class which it's layout contains the recyclerView widget**
    Here in our example is MainActivity.class

    public static RecyclerViewAdapter adapter;
    public void recyclerViewInit(ArrayList dataSource, RecyclerView rv, Context context,RecyclerViewAdapter.ItemClickListener click){
        // set up the RecyclerView
        rv.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RecyclerViewAdapter(context, dataSource);
        adapter.setClickListener(click);
        rv.setAdapter(adapter);
    }
    
[5] **Put the data you want to fill the recyclerView with in an array;** 
    Hint: here we used the array as the dataSource in the previous recyclerViewInit function
    
[5.1] **Populate using an array directly**

    ArrayList arr = new ArrayList<String>();
    arr.add("Horse");   arr.add("Cow"); arr.add("Camel");   arr.add("Sheep");   arr.add("Goat");
    arr.add("Horse");   arr.add("Cow"); arr.add("Camel");   arr.add("Sheep");
         
OR  
    
[5.2] **Using SharedPrefs**
    
    SharedPrefSingleton.init(getApplicationContext());
    SharedPrefSingleton.write("0","Horse"); SharedPrefSingleton.write("1","Cow");   SharedPrefSingleton.write("2","Camel");
    SharedPrefSingleton.write("3","Sheep"); SharedPrefSingleton.write("4","Goat");  SharedPrefSingleton.write("5","Horse");
    ArrayList arr = SharedPrefSingleton.readAll();

OR  
  
[5.3] **Using Room**
    
    RoomDB db = RoomDB.getInstance(getApplicationContext());
    DAO dao = db.Dao();
    ArrayList arr = (ArrayList) dao.getColumn()

OR

[5.4] **return all rows from database inform of array; previous SQLite class contains returning rows inform of array**
    
    DBHelper dbHelper=new DBHelper(getApplicationContext());
    dbHelper.addRecord(new ClassModel(1,"mohamed"));
    dbHelper.addRecord(new ClassModel(2,"m"));
    dbHelper.addRecord(new ClassModel(3,"messi"));
    ArrayList arr = dbHelper.getColumn(1);
  
  
[6]. **Call the recyclerViewInit function**
    
    recyclerViewInit(arr,findViewById(R.id.rv),getApplicationContext(),this);
    
- - - -
# To Be Continued #

    Stay Tuned

