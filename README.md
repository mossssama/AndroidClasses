AndroidJavaClasses<a name="TOP"></a>
===================
For [Kotlin Repo](https://github.com/mossssama/AndroidKotlinClasses)

- - - - 
# SharedPreferences #
Shared Preferences: is key-value pair storage
- Used to store user-specified configuration details, such as settings, and to keep the user logged in to the app.
- Used to store small amount of data which doesn’t require any specific structure.

[1] Write the following inside the class you want to use sharedPreferences in it

    SINGLETON_SharedPref.init(getContext());

[2] Then use its functions directly by using class name

    SINGLETON_SharedPref.write("Mohamed Osama","Best Engineer");
    SINGLETON_SharedPref.remove("Mohamed Osama");
    
and so on

# SQLiteDatabase #
[1] Write the following inside the class you want to use SQLiteDatabase in it

    DBHelper dbHelper=new DBHelper(getApplicationContext());
    ClassModel recordOne = new ClassModel(clmOneData,clmTwoData);
    
[2] Use classModel instances as an input parameters to the SQLite DBHelper

    ClassModel recordOne = new ClassModel(clmOneData,clmTwoData);
    dbHelper.addRecord(recordOne);
    
OR    
   
    dbHelper.addRecord(new ClassModel(clmOneData,clmTwoData));
    
[3] Use any function inside DBHelper using dbHelper instance

    dbHelper.getColumn(1);
    
and so on



# To Be Continued #

    Stay Tuned

