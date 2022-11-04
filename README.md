AndroidJavaClasses<a name="TOP"></a>
===================

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
Write the following inside the class you want to use  in it

    SINGLETON_SharedPref.init(getContext());

Then use its functions directly by using class name

    SINGLETON_SharedPref.write("Mohamed Osama","Best Engineer");
    SINGLETON_SharedPref.remove("Mohamed Osama");
    
and so on



# To Be Continued #

    Stay Tuned

