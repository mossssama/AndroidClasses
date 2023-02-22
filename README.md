AndroidJavaClasses<a name="TOP"></a>
===================
For [Kotlin Repo](https://github.com/mossssama/AndroidKotlinClasses)

- - - - 
# 1. SharedPreferences #
**Shared Preferences: are key-value pair storage**
- Used to store user-specified configuration details, such as settings, and to keep the user logged in to the app.
- Used to store small amount of data which doesn’t require any specific structure.
- Check its module Repo with example [here](https://github.com/mossssama/AndroidSharedPreferencesModule)
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
# 4. SQLiteDatabase #
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
# 5. RecyclerViewAdapter #
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
# 5. Room Database #
**Room : is a library in JetPack library to provide an abstraction layer on SQLite to allow easily access to the database**

[1] **Write the following dependencies in build.gradle**
    
    implementation 'androidx.room:room-runtime:2.4.3'
    annotationProcessor 'androidx.room:room-compiler:2.4.3'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    annotationProcessor 'androidx.lifecycle:lifecycle-compiler:2.5.1'

[2] Put the RoomDatabase directory in your project directory
-   **DAO** is interface containg the main queries to be applied on your database   
-   **RoomDB** is a class to build the Room layer on SQLite; it specifies mainDB + populating DB
-   **ModelClass** is a class representing a table in your Room Database
- - - -
# To Be Continued #

    Stay Tuned

