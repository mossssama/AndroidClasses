AndroidJavaClasses<a name="TOP"></a>
===================
For [Kotlin Repo](https://github.com/mossssama/AndroidKotlinClasses)

- - - - 
# 1. SharedPreferences #
**Shared Preferences: is key-value pair storage**
- Used to store user-specified configuration details, such as settings, and to keep the user logged in to the app.
- Used to store small amount of data which doesn’t require any specific structure.

[1] Write the following inside the class you want to use sharedPreferences in it

    SINGLETON_SharedPref.init(getContext());
<br/><br/>
[2] Then use its functions directly by using class name

    SINGLETON_SharedPref.write("Mohamed Osama","Best Engineer");
    SINGLETON_SharedPref.remove("Mohamed Osama");
    
and so on

<br/><br/>
# 2. SQLiteDatabase #
**SQLite : is database used to store data localy & permenantly using CRUD operations in SQL language**

[1] Write the following inside the class you want to use SQLiteDatabase in it

    DBHelper dbHelper=new DBHelper(getApplicationContext());
    ClassModel recordOne = new ClassModel(clmOneData,clmTwoData);
<br/><br/>
[2] Use classModel instances as an input parameters to the SQLite DBHelper

    ClassModel recordOne = new ClassModel(clmOneData,clmTwoData);
    dbHelper.addRecord(recordOne);
    
OR    
   
    dbHelper.addRecord(new ClassModel(clmOneData,clmTwoData));
<br/><br/>
[3] Use any function inside DBHelper using dbHelper instance

    dbHelper.getColumn(1);
    
and so on

<br/><br/>
# 3. RecyclerViewAdapter #
**RecyclerView : ViewGroup contains views corresponding to our data**
**RecyclerViewAdapter : Adapter binds data from dataSet to Views that are displayed inside RecyclerView 

[1] Add a recyclerView widget to the xml file of an activity
    for example activity_main.xml

    <androidx.recyclerview.widget.RecyclerView
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:id="@+id/rv"
        app:layout_constraintBottom_toTopOf="@+id/button4"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
<br/><br/>
[2] Create an xml layout to specify the how will each item in the recycler View will look like
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
<br/><br/>
[3] Add the RecyclerView Adapter class to your project directory

<br/><br/>
**At the class which it's layout contains the recyclerView widget; do number 4,5,6**
<br><br/>
[4] Add the following function to the class which it's layout contains the recyclerView widget
    Here in our example is MainActivity.class

    public static RecyclerViewAdapter adapter;
    public void recyclerViewInit(ArrayList dataSource, RecyclerView rv, Context context,RecyclerViewAdapter.ItemClickListener click){
        // set up the RecyclerView
        rv.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RecyclerViewAdapter(context, dataSource);
        adapter.setClickListener(click);
        rv.setAdapter(adapter);
    }
    
<br/><br/>
[5] Put the data you want to fill the recyclerView with in an array; 
    Hint: here we used the array as the dataSource in the previous recyclerViewInit function
    
[5.1] Populate using an array directly

    ArrayList arr = new ArrayList<String>();
    arr.add("Horse");   arr.add("Cow"); arr.add("Camel");   arr.add("Sheep");   arr.add("Goat");
    arr.add("Horse");   arr.add("Cow"); arr.add("Camel");   arr.add("Sheep");
         
OR  
    
[5.2] Using SharedPrefs
    
    SharedPrefSingleton.init(getApplicationContext());
    SharedPrefSingleton.write("0","Horse"); SharedPrefSingleton.write("1","Cow");   SharedPrefSingleton.write("2","Camel");
    SharedPrefSingleton.write("3","Sheep"); SharedPrefSingleton.write("4","Goat");  SharedPrefSingleton.write("5","Horse");
    ArrayList arr = SharedPrefSingleton.readAll();

OR  
    
[5.3] return all rows from database inform of array; previous SQLite class contains returning rows inform of array
    
    DBHelper dbHelper=new DBHelper(getApplicationContext());
    dbHelper.addRecord(new ClassModel(1,"mohamed"));
    dbHelper.addRecord(new ClassModel(2,"m"));
    dbHelper.addRecord(new ClassModel(3,"messi"));
    ArrayList arr = dbHelper.getColumn(1);

<br/><br/>
[6]. Call the recyclerViewInit function
    
    recyclerViewInit(arr,findViewById(R.id.rv),getApplicationContext(),this);
    
<br/><br/>
# 4. APIs #
**API : WebService provided by remote servers & developed by backEnd developers**
- They are set of methods/classes build in any scripting language & can be used without knowing their implementation
- We needs agreement/protocol & key to use an API
<br/><br/>
They are provided in different protocols & architectures as:
Protocols(TCP/IP): 1-HTTP 2-SMTP 3-FTP
Architectures: 1-REST 2-SOAP
<br/><br/>
- App -FTP/SMTP/HTTP-> Server (API Request)
- App <-XML/HTML/JSON- Server (API Response)
<br/><br/>
    |    vs    |    SOAP   |      REST     |
    |:--------:|:---------:|:-------------:|
    |  Request | HTTP/SMTP |      HTTP     |
    | Response |    XML    | XML/HTML/JSON |
    | Security |    High   |      Low      |
<br/><br/>
API response return with code (code & information in case of successful request) as the following
<br/><br/>
| Response Code |         Meaning        |
|:-------------:|:----------------------:|
|    100->199   | Informational response |
|    200->299   |   Successful response  |
|    300->399   |        Redirects       |
|    400->499   |      Client errors     |
|    500->599   |      Server errors     |
<br/><br/>
APIs request must support Asynchronous code to get red of application stuck during waiting for API response
We have two Android libraries supporting Asychronous code
1- Volley: official documented library
2- Retrofit: part of JetPack Compose;libraries & best practices revelead by Google in 2019

## prerequisites
[1] Write the following dependencies in build.gradle

    // API doc: Dependency to use Retrofit Library(Gives Asynchronous network request)
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'

    // API doc: Dependency to use GSON as notation while converting from JSON->POJO
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
<br/><br/>
[2] Write the following permissions in AndroidManifext.xml

    <!-- Api doc: Permissions to use Internet & -->
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<br/><br/>
[3] Paste the following after application tag in AndroidManifest.xml to allow using http along with https
    
    android:usesCleartextTraffic="true"
<br/><br/>

## In projects directory
1. Put the SingletonRetrofitClient.java class in your project
2. Put Api.java interface in your project
3. Convert JSON response to POJO using [JSON->POJO](https://www.jsonschema2pojo.org/) & put the result java classes in your project
4. Put the following in the activity class you want to use an API in it
<br/><br/>
    Call<Verse> callConstantVerse = SingletonRetrofitClient.getInstance().getApi().getConstantVerse();
    callDynamicVerse.enqueue(new Callback<Verse>() {
                    @Override
                    public void onResponse(Call<Verse> call, Response<Verse> response) {
                        Verse verse= response.body();
                        String verseString= verse.getData().getText();
                        String verseSurah= verse.getData().getSurah().getName();
                        tvAyah.setText(verseString);
                        tvSurah.setText(verseSurah);
                    }

                    @Override
                    public void onFailure(Call<Verse> call, Throwable t) {
                        tvAyah.setText("Ahhh");
                        Log.d("ahhhhhhhhhhhhhhhhhhh","");
                    }
                });
<br/><br/>
    
# To Be Continued #

    Stay Tuned

